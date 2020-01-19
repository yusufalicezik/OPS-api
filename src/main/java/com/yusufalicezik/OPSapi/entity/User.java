package com.yusufalicezik.OPSapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "User")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column(name = "fullName", length = 100)
    private String fullName;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "plateNo", length = 50, unique = true)
    private String plateNo;

    @Column(name = "phone", length = 100)
    private String phone;

    @Column(name = "userType", columnDefinition = "int default 2")
    private int userType = 2; //def.

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_detail_id")
    private UserDetail userDetail;
}
