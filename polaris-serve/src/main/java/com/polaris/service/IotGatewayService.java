package com.polaris.service;

import com.polaris.entity.IotGateway;
import com.baomidou.mybatisplus.extension.service.IService;
import com.polaris.entity.RespBean;
import com.polaris.model.iot.CreateGatewayRequest;

/**
* @author cntia
* @description 针对表【iot_gateway】的数据库操作Service
* @createDate 2023-02-08 14:38:33
*/
public interface IotGatewayService extends IService<IotGateway> {
    RespBean createIotGateway(CreateGatewayRequest request);

    RespBean getIotGatewayCount(Long projectId);

    RespBean getGatewayIdByProject(Long projectId);

    RespBean getGatewayDetail(Long gatewayId);
}
