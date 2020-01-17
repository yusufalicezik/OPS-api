package com.yusufalicezik.OPSapi.controller;

import com.yusufalicezik.OPSapi.dto.Request.UserRequestDto;
import com.yusufalicezik.OPSapi.dto.Response.UserResponseDto;
import com.yusufalicezik.OPSapi.service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {


    @Autowired
    private UserServiceImpl userService;

    @PostMapping
    public ResponseEntity<UserResponseDto> addNewUser(@RequestBody UserRequestDto userRequestDto){
        return ResponseEntity.ok(userService.save(userRequestDto));
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserResponseDto>> getAllUser(){
        return ResponseEntity.ok(userService.getAllUser());
    }

    @GetMapping("/{plateNo}")
    public ResponseEntity<UserResponseDto> getUserByPlateNo(@PathVariable String plateNo){
        return ResponseEntity.ok(userService.getUserByPlate(plateNo));
    }

}