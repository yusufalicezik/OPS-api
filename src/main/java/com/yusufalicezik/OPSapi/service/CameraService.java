package com.yusufalicezik.OPSapi.service;

import com.yusufalicezik.OPSapi.dto.Request.CameraRequestDto;
import com.yusufalicezik.OPSapi.entity.Camera;

public interface CameraService {
    Camera updateCameraStatus(CameraRequestDto cameraRequestDto);
}