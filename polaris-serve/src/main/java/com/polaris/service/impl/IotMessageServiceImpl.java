package com.polaris.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.polaris.entity.IotMessage;
import com.polaris.entity.RespBean;
import com.polaris.model.iot.EquipmentMessagePushRequest;
import com.polaris.model.iot.PushDataListRequest;
import com.polaris.service.IotMessageService;
import com.polaris.mapper.IotMessageMapper;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

/**
* @author cntia
* @description 针对表【iot_message】的数据库操作Service实现
* @createDate 2023-02-08 16:17:22
*/
@Service
public class IotMessageServiceImpl extends ServiceImpl<IotMessageMapper, IotMessage>
    implements IotMessageService{

    @Override
    public RespBean saveEquipmentPushData(PushDataListRequest request) {
        for(EquipmentMessagePushRequest msg: request.getMessages()){
            IotMessage iotMessage = new IotMessage();
            iotMessage.setBody(msg.getBody());
            iotMessage.setEquipmentId(msg.getEquipmentId());
            long time = System.currentTimeMillis();
            iotMessage.setCreateTime(new Timestamp(time));
            save(iotMessage);
        }
        return RespBean.success("数据推送成功");
    }
}




