package com.yusufalicezik.OPSapi.dto.Response;

import com.yusufalicezik.OPSapi.entity.UserDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {
    private int id;
    private String fullName;
    private String plateNo;
    private String phone;
    private String email;
    private int userType;
    private UserDetail userDetail;
}
