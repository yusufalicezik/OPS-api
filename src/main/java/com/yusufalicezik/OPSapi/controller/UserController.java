package com.yusufalicezik.OPSapi.controller;

import com.yusufalicezik.OPSapi.config.auth.JWT.TokenManager;
import com.yusufalicezik.OPSapi.controller.error.GlobalError;
import com.yusufalicezik.OPSapi.dto.Request.UserRequestDto;
import com.yusufalicezik.OPSapi.dto.Response.UserResponseDto;
import com.yusufalicezik.OPSapi.service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {


    @Autowired
    private UserServiceImpl userService;

    /*@Autowired
    private AuthenticationManager authenticationManager;
     */

    @Autowired
    private TokenManager tokenManager;

    @PostMapping("/register")
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

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(HttpServletRequest httpServletRequest, @RequestParam String email, @RequestParam String password) throws GlobalError {
        try{
           // authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
            return ResponseEntity.ok(tokenManager.generateToken(email));
        }catch (Exception e){
            return ResponseEntity.ok(e.getLocalizedMessage() + e.getMessage());
        }
        //return "ResponseEntity.ok(userService.loginWithEmailAndPassword(email, password));"
    }

}