package com.yusufalicezik.OPSapi.controller;


import com.yusufalicezik.OPSapi.dto.Request.UserRequestDto;
import com.yusufalicezik.OPSapi.dto.Response.UserResponseDto;
import com.yusufalicezik.OPSapi.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserAuthController {

    private final AuthenticationService service;

    @Autowired
    public UserAuthController(AuthenticationService service) {
        this.service = service;
    }
    
    @PostMapping(path = "/login")
    public ResponseEntity<Object> login(@RequestParam String email, @RequestParam String password){
        return new ResponseEntity<Object>(service.login(email, password), HttpStatus.OK);
    }

    @PostMapping("/signUp")
    public ResponseEntity<UserResponseDto> addNewUser(@RequestBody @Validated UserRequestDto userRequestDTO){
        return new ResponseEntity<UserResponseDto>(service.signUp(userRequestDTO), HttpStatus.OK);
    }
}
