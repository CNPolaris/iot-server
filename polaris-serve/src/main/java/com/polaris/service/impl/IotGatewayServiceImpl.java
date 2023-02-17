package com.polaris.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.polaris.entity.IotGateway;
import com.polaris.entity.RespBean;
import com.polaris.enums.StatusTypeEnum;
import com.polaris.mapper.IotProjectMapper;
import com.polaris.model.iot.CreateGatewayRequest;
import com.polaris.service.IotGatewayService;
import com.polaris.mapper.IotGatewayMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
* @author cntia
* @description 针对表【iot_gateway】的数据库操作Service实现
* @createDate 2023-02-08 14:38:33
*/
@Service
public class IotGatewayServiceImpl extends ServiceImpl<IotGatewayMapper, IotGateway>
    implements IotGatewayService{
    @Resource
    private IotGatewayMapper gatewayMapper;

    @Override
    public RespBean createIotGateway(CreateGatewayRequest request) {
        IotGateway gateway = new IotGateway();
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        gateway.setGatewayKey(uuid);

        gateway.setName(request.getName());
        gateway.setProjectId(request.getProjectId());
        gateway.setStatus(StatusTypeEnum.YES.getCode());
        long time = System.currentTimeMillis();
        gateway.setCreateTime(new Timestamp(time));
        save(gateway);
        return RespBean.success("创建网关设备成功", gateway);
    }

    @Override
    public RespBean getIotGatewayCount(Long projectId) {
        QueryWrapper<IotGateway> queryWrapper = new QueryWrapper<IotGateway>().eq("project_id", projectId);
        Long count = gatewayMapper.selectCount(queryWrapper);
        return RespBean.success(count);
    }

    @Override
    public RespBean getGatewayIdByProject(Long projectId) {
        QueryWrapper<IotGateway> queryWrapper = new QueryWrapper<IotGateway>().eq("project_id", projectId);
        List<IotGateway> iotGateways = gatewayMapper.selectList(queryWrapper);
        return RespBean.success(iotGateways);
    }

    @Override
    public RespBean getGatewayDetail(Long gatewayId) {
        QueryWrapper<IotGateway> queryWrapper = new QueryWrapper<IotGateway>().eq("id", gatewayId);
        IotGateway iotGateway = gatewayMapper.selectOne(queryWrapper);
        return RespBean.success(iotGateway);
    }
}




