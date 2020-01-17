package com.yusufalicezik.OPSapi.service;

import com.yusufalicezik.OPSapi.dto.Request.UserRequestDto;
import com.yusufalicezik.OPSapi.dto.Response.UserResponseDto;

import java.util.List;

public interface UserService {
    UserResponseDto save(UserRequestDto userRequestDto);
    List<UserResponseDto> getAllUser();
    UserResponseDto getUserByPlate(String plateNo);

}

