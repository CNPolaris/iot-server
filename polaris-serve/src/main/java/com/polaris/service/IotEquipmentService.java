package com.polaris.service;

import com.polaris.entity.IotEquipment;
import com.baomidou.mybatisplus.extension.service.IService;
import com.polaris.entity.RespBean;
import com.polaris.model.iot.CreateEquipmentRequest;

/**
* @author cntia
* @description 针对表【iot_equipment】的数据库操作Service
* @createDate 2023-02-08 13:43:41
*/
public interface IotEquipmentService extends IService<IotEquipment> {
    RespBean createIotEquipment(CreateEquipmentRequest request);
}
