package com.yusufalicezik.OPSapi.dto.Request;

import com.yusufalicezik.OPSapi.entity.UserDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto {

    private String fullName;
    private String plateNo;
    private String phone;
    private int userType;
    private String email;
    private String password;
    private UserDetail userDetail;

}