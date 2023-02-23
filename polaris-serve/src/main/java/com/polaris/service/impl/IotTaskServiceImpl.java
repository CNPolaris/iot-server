package com.polaris.service.impl;

import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.polaris.entity.IotTask;
import com.polaris.entity.RespBean;
import com.polaris.model.iot.CreateTaskRequest;
import com.polaris.model.iot.GetTaskListResponse;
import com.polaris.model.iot.TaskResponseBean;
import com.polaris.service.IotTaskService;
import com.polaris.mapper.IotTaskMapper;
import com.polaris.utils.Commons;

import cn.hutool.core.bean.BeanUtil;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;
/**
 * @author cntia
 * @description 针对表【iot_task】的数据库操作Service实现
 * @createDate 2023-02-12 14:25:51
 */
@Service
public class IotTaskServiceImpl extends ServiceImpl<IotTaskMapper, IotTask>
        implements IotTaskService {
    @Value("${iot-tcp.ip}")
    private String iotIp;

    @Value("${iot-tcp.port}")
    private Integer iotPort;

    @Resource
    private IotTaskMapper taskMapper;

    @Override
    public RespBean createTask(Long gatewayId, CreateTaskRequest request) {
        IotTask iotTask = new IotTask();
        iotTask.setTaskJson(request.getTaskJson());
        iotTask.setStatus(Commons.YES);
        iotTask.setType(1);
        iotTask.setTime(60); // 60s
        iotTask.setCreateTime(new Date());
        iotTask.setGatewayId(gatewayId);
        iotTask.setClockType(request.getClockType());
        save(iotTask);
        return RespBean.success("创建任务成功");
    }

    @Override
    public ResponseEntity<RespBean> getTaskList(Long gatewayId, Integer page, Integer limit) {
        // TODO Auto-generated method stub
        Page<IotTask> taskPage = new Page<>(page, limit);
        QueryWrapper<IotTask> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("gateway_id", gatewayId);
        taskPage = taskMapper.selectPage(taskPage, queryWrapper);

        GetTaskListResponse resp = new GetTaskListResponse();
        resp.setTotal(taskPage.getTotal());
        resp.setSize(taskPage.getRecords().size());

        List<TaskResponseBean> list = taskPage.getRecords().stream()
            .map(task -> BeanUtil.toBean(task, TaskResponseBean.class))
            .collect(Collectors.toList());
        resp.setList(list);
        return new ResponseEntity<>(RespBean.success("成功", resp), HttpStatus.OK);
    }

    @Override
    public RespBean pushTask(Long gatewayId, Long taskId) {
        QueryWrapper<IotTask> queryWrapper = new QueryWrapper<IotTask>().eq("id", taskId);
        IotTask iotTask = taskMapper.selectOne(queryWrapper);
        try {
            Socket socket = new Socket(iotIp, iotPort);
            // 向服务器端发送数据
            OutputStream out = socket.getOutputStream();
            // 说明是任务命令
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out, StandardCharsets.UTF_8));
            bw.write("task");
            bw.flush();
            // 读取服务器端数据
            InputStream inputStream = socket.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            String msg = bufferedReader.readLine();
            System.out.println(msg);
            if("recv".equals(msg)){
                bw.write(JSONUtil.toJsonStr(iotTask));
                bw.flush();
            }
            inputStream.close();
            out.close();
            socket.close();
            return RespBean.success("执行任务成功");
        } catch (Exception e){
            System.out.println(e);
            return RespBean.error("执行任务失败", e);
        }
    }
    public static byte[] readData(InputStream is,int length) throws IOException {
        byte[] bytes = new byte[length];
        int index = 0;
        int len = 0;
        while(index < length){
            len = is.read(bytes,index,length - index);
            //每次读取完判断数据是否全部读取完毕
            if(len > 0){
                index += len;
            }else {
                break;
            }
        }
        return bytes;
    }

}
