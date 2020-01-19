package com.yusufalicezik.OPSapi.dto.authDto;

import com.yusufalicezik.OPSapi.dto.Response.UserResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAuthResponseDto {

    private String token;
    private UserResponseDto user;

}
