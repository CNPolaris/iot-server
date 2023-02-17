package com.polaris.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.polaris.entity.IotEquipment;
import com.polaris.entity.IotGateway;
import com.polaris.entity.IotProject;
import com.polaris.entity.RespBean;
import com.polaris.mapper.IotEquipmentMapper;
import com.polaris.mapper.IotGatewayMapper;
import com.polaris.mapper.IotProjectMapper;
import com.polaris.model.iot.AuthGatewayResponse;
import com.polaris.service.IotClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: polaris
 */
@Service
public class IotClientServiceImpl extends ServiceImpl<IotGatewayMapper, IotGateway> implements IotClientService {
    @Resource
    private IotProjectMapper projectMapper;
    @Resource
    private IotGatewayMapper gatewayMapper;
    @Resource
    private IotEquipmentMapper equipmentMapper;

    @Override
    public RespBean authGateway(String[] strings) {
        try{
            QueryWrapper<IotProject> projectQueryWrapper = new QueryWrapper<IotProject>().eq("project_key", strings[0]);
            IotProject iotProject = projectMapper.selectOne(projectQueryWrapper);

            QueryWrapper<IotGateway> gatewayQueryWrapper = new QueryWrapper<IotGateway>().eq("gateway_key", strings[1]);
            IotGateway iotGateway = gatewayMapper.selectOne(gatewayQueryWrapper);
            if(iotGateway.getProjectId().equals(iotProject.getId())){
                AuthGatewayResponse gatewayResponse = new AuthGatewayResponse();
                gatewayResponse.setGatewayId(iotGateway.getId());
                return RespBean.success("验证通过", gatewayResponse);
            } else {
                return RespBean.error("网关密钥验证失败");
            }
        } catch (Exception e){
            return RespBean.error("网关密钥验证失败");
        }
    }

    @Override
    public RespBean getGatewayIntroductions(Long gatewayId) {
        try{
            IotGateway iotGateway = gatewayMapper.selectById(gatewayId);
            QueryWrapper<IotEquipment> equipmentQueryWrapper = new QueryWrapper<IotEquipment>().eq("gateway_id", iotGateway.getId());
            List<IotEquipment> iotEquipments = equipmentMapper.selectList(equipmentQueryWrapper);
            return RespBean.success("获取指令成功", iotEquipments);
        } catch (Exception e){
            return RespBean.error("网关不存在");
        }
    }
}
