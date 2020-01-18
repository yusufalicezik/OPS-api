package com.yusufalicezik.OPSapi.dto.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CameraRequestDto {
    private int id; //park edilip, çıkıldığında kullanılacak DTO
    private String name;
    private boolean status;
    private String plateNo;
    private boolean exitStatus;
    private Date date;
}
