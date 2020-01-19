package com.yusufalicezik.OPSapi.service;

import com.yusufalicezik.OPSapi.dto.Request.UserRequestDto;
import com.yusufalicezik.OPSapi.dto.Response.UserResponseDto;

public interface AuthenticationService {

    Object login(String email, String password);

    UserResponseDto signUp(UserRequestDto userRequestDTO);
}
