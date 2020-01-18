package com.yusufalicezik.OPSapi.controller;

import com.yusufalicezik.OPSapi.controller.error.CameraAlreadyExistError;
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

    //addNew,  Place de var.

    @PostMapping("/update")
    public Camera updateCameraStatus(@RequestBody CameraRequestDto cameraRequestDto) throws CameraAlreadyExistError { //Error: Henüz çıkış yapılmamış parkı var. Çıkış yapılmadan yeni giriş olamaz.
        return cameraService.updateCameraStatus(cameraRequestDto);
    }
}
