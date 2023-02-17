package com.polaris.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.polaris.entity.IotEquipment;
import com.polaris.entity.RespBean;
import com.polaris.model.iot.CreateEquipmentRequest;
import com.polaris.service.IotEquipmentService;
import com.polaris.mapper.IotEquipmentMapper;
import com.polaris.utils.Commons;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

/**
* @author cntia
* @description 针对表【iot_equipment】的数据库操作Service实现
* @createDate 2023-02-08 13:43:41
*/
@Service
public class IotEquipmentServiceImpl extends ServiceImpl<IotEquipmentMapper, IotEquipment>
    implements IotEquipmentService{

    @Override
    public RespBean createIotEquipment(CreateEquipmentRequest request) {
        IotEquipment iotEquipment = new IotEquipment();
        iotEquipment.setModbusBusadd(request.getModbusBusadd());
        iotEquipment.setModbusFeaturesCode(request.getModbusFeaturesCode());
        iotEquipment.setModbusFeaturesAddrStart(request.getModbusRegisterAddrStart());
        iotEquipment.setModbusFeaturesAddrEnd(request.getModbusRegisterAddrEnd());
        iotEquipment.setModbusReadStart(request.getModbusReadStart());
        iotEquipment.setModbusReadEnd(request.getModbusReadEnd());
        iotEquipment.setModbusCrcCheck(request.getModbusCrcCheck());
        iotEquipment.setName(request.getName());
        iotEquipment.setGatewayId(request.getGatewayId());
        iotEquipment.setParamTemplateId(request.getParamTemplateId());
        long time = System.currentTimeMillis();
        iotEquipment.setCreateTime(new Timestamp(time));
        iotEquipment.setStatus(Commons.YES);
        save(iotEquipment);
        return RespBean.success("添加设备成功");
    }
}




