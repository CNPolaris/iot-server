package com.polaris.controller.iot;

import cn.hutool.json.JSONUtil;
import com.polaris.api.iot.IotClientApi;
import com.polaris.entity.RespBean;
import com.polaris.model.iot.*;
import com.polaris.service.IotClientService;
import com.polaris.service.IotMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @author: polaris
 */
@RestController("IOTClientController")
public class IotClientController implements IotClientApi {
    @Value("${iot-tcp.ip}")
    private String iotIp;

    @Value("${iot-tcp.port}")
    private Integer iotPort;
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
            Socket socket = new Socket(iotIp, iotPort);
            // 向服务器端发送数据
            OutputStream out = socket.getOutputStream();
            // 说明是下发命令
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out, StandardCharsets.UTF_8));
            bw.write("order");
            bw.flush();
            // 读取服务器端数据
            InputStream inputStream = socket.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            String msg = bufferedReader.readLine();
            if("recv".equals(msg)){
                bw.write(JSONUtil.toJsonStr(request));
                bw.flush();
            }
            // 关闭
            inputStream.close();
            out.close();
            socket.close();
            return new ResponseEntity<>(RespBean.success("命令下发成功"), HttpStatus.OK);
        } catch (IOException e){
            return new ResponseEntity<>(RespBean.error("命令下发失败"), HttpStatus.OK);
        }
    }
}
