package com.yusufalicezik.OPSapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Camera")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Camera {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "status", columnDefinition = "boolean default false")
    private boolean status;

    @Column(name = "plateNo", length = 100)
    private String plateNo;

    @Column(name = "amount")
    private int amount;

    @Column(name =  "date")
    private Date date;

}
