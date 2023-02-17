package com.polaris.controller.iot;

import com.polaris.api.iot.IotEquipmentApi;
import com.polaris.model.iot.CreateEquipmentRequest;
import com.polaris.service.IotEquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: polaris
 */
@RestController("IotEquipmentController")
public class IotEquipmentController implements IotEquipmentApi {
    @Autowired
    private IotEquipmentService equipmentService;

    @Override
    public ResponseEntity<Object> iotApiEquipmentPost(String authorization, CreateEquipmentRequest request) {
        return new ResponseEntity<>(equipmentService.createIotEquipment(request), HttpStatus.OK);
    }
}
