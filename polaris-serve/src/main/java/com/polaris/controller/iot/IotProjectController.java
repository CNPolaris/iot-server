package com.polaris.controller.iot;

import com.polaris.api.iot.IotProjectApi;
import com.polaris.entity.RespBean;
import com.polaris.model.iot.CreateProjectRequest;
import com.polaris.model.iot.GetMyProjectRequest;
import com.polaris.service.IotProjectService;
import com.polaris.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: polaris
 */
@RestController("IotProjectController")
public class IotProjectController implements IotProjectApi {
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private IotProjectService projectService;

    @Override
    public ResponseEntity<RespBean> iotProjectPost(String authorization, CreateProjectRequest request) {
        Long userId = jwtTokenUtil.getUserId(authorization);
        Integer role = jwtTokenUtil.getRole(authorization);
        return new ResponseEntity<>(projectService.createIotProject(userId, role, request), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<RespBean> iotProjectGet(String authorization, GetMyProjectRequest request) {
        // 暂时不分页查询
        Long userId = jwtTokenUtil.getUserId(authorization);
        return new ResponseEntity<>(projectService.getMyProject(userId), HttpStatus.OK);
    }
}
