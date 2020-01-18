package com.yusufalicezik.OPSapi.dto.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CameraRequest {
    private String name;
    private boolean status;
    private String plateNo;
}
