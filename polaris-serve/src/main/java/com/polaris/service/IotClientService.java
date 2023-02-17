package com.polaris.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.polaris.entity.IotGateway;
import com.polaris.entity.RespBean;

/**
 * @author: polaris
 */
public interface IotClientService extends IService<IotGateway> {
    RespBean authGateway(String[] strings);

    RespBean getGatewayIntroductions(Long gatewayId);
}
