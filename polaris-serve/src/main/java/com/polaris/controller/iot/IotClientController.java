package com.polaris.controller.iot;

import cn.hutool.json.JSONUtil;
import com.polaris.api.iot.IotClientApi;
import com.polaris.entity.RespBean;
import com.polaris.model.iot.*;
import com.polaris.service.IotClientService;
import com.polaris.service.IotMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.charset.StandardCharsets;

/**
 * @author: polaris
 */
@RestController("IOTClientController")
public class IotClientController implements IotClientApi {
    @Autowired
    private IotClientService clientService;
    @Autowired
    private IotMessageService messageService;

    @Override
    public ResponseEntity<RespBean> authIotGatewayApiPost(AuthGatewayRequest request) {
        String[] strings = request.getAccessKey().split("&");
        if(strings.length != 2){
            return new ResponseEntity<>(RespBean.error("注册包密钥不合法"), HttpStatus.OK);
        }
        return new ResponseEntity<>(clientService.authGateway(strings), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<RespBean> getGatewayIntroduction(GetGatewayIntroductionRequest request) {
        if(request.getGatewayId()==null){
            return new ResponseEntity<>(RespBean.error("注册包密钥不合法"), HttpStatus.BAD_GATEWAY);
        }
        return new ResponseEntity<>(clientService.getGatewayIntroductions(request.getGatewayId()), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<RespBean> iotGatewayPushDataPost(PushDataListRequest request) {
        return new ResponseEntity<>(messageService.saveEquipmentPushData(request), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<RespBean> iotGatewayPushCommand(PushCommandRequest request) {
        try{
            Socket socket = new Socket("127.0.0.1", 9960);
            // 向服务器端发送数据
            OutputStream out = socket.getOutputStream();
            // 说明是下发命令
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out, StandardCharsets.UTF_8));
            bw.write("order");
            bw.flush();
            // 读取服务器端数据
            InputStream inputStream = socket.getInputStream();
            byte[] bytes = new byte[2048];
            int len;
            StringBuilder sb = new StringBuilder();
            len = inputStream.read(bytes);
            sb.append(new String(bytes, 0, len, StandardCharsets.UTF_8));
            // 如果接收到recv 可以实现命令下发
            if("recv".equals(sb.toString())) {
                bw.write(JSONUtil.toJsonStr(request));
                bw.flush();
            }
            // 接收命令下发反馈
            byte[] respBytes = new byte[2048];
            StringBuilder resp = new StringBuilder();
            int read = inputStream.read(respBytes);
            resp.append(new String(respBytes, 0, read, StandardCharsets.UTF_8));

            // 关闭
            inputStream.close();
            out.close();
            socket.close();
            return new ResponseEntity<>(RespBean.success("命令下发成功", resp.toString()), HttpStatus.OK);
        } catch (IOException e){
            System.out.println(e);
            return new ResponseEntity<>(RespBean.error("命令下发失败"), HttpStatus.OK);
        }
    }
    public void readStreamWithRecursion(InputStream inStream, int timeout) throws Exception {
        long start = System.currentTimeMillis();
        while (inStream.available() == 0) {
            if ((System.currentTimeMillis() - start) > timeout) {//超时退出
                throw new SocketTimeoutException("超时读取");
            }
        }
        byte[] buffer = new byte[2048];
        int read = inStream.read(buffer);

        int a = inStream.available();//再判断一下，是否有可用字节数或者根据实际情况验证报文完整性
        if (a > 0) {
            System.out.println("========还有剩余：" + a + "个字节数据没读");
            readStreamWithRecursion(inStream,timeout);
        }
    }
}
