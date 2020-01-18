package com.yusufalicezik.OPSapi.controller;

import com.yusufalicezik.OPSapi.dto.Request.CameraRequestDto;
import com.yusufalicezik.OPSapi.entity.Camera;
import com.yusufalicezik.OPSapi.service.Impl.CameraServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/camera")
public class CameraController {

    @Autowired
    private CameraServiceImpl cameraService;

    //add new Place de var.

    @PostMapping("/update")
    public Camera updateCameraStatus(@RequestBody CameraRequestDto cameraRequestDto){
        return cameraService.updateCameraStatus(cameraRequestDto);
    }
}
