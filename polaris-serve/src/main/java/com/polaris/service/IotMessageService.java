package com.polaris.service;

import com.polaris.entity.IotMessage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.polaris.entity.RespBean;
import com.polaris.model.iot.EquipmentMessagePushRequest;
import com.polaris.model.iot.PushDataListRequest;

/**
* @author cntia
* @description 针对表【iot_message】的数据库操作Service
* @createDate 2023-02-08 16:17:22
*/
public interface IotMessageService extends IService<IotMessage> {
    RespBean saveEquipmentPushData(PushDataListRequest request);
}
