package com.yusufalicezik.OPSapi.service.Impl;

import com.yusufalicezik.OPSapi.config.auth.JWT.TokenManager;
import com.yusufalicezik.OPSapi.dto.Request.UserRequestDto;
import com.yusufalicezik.OPSapi.dto.Response.UserResponseDto;
import com.yusufalicezik.OPSapi.dto.authDto.UserAuthResponseDto;
import com.yusufalicezik.OPSapi.entity.User;
import com.yusufalicezik.OPSapi.repository.UserRepository;
import com.yusufalicezik.OPSapi.service.AuthenticationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    @Autowired
    public AuthenticationServiceImpl(ModelMapper modelMapper, UserRepository userRepository) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
    }

    @Override
    public Object login(String email, String password) {

        UserAuthResponseDto userAuthResponseDto = new UserAuthResponseDto();
        User user = userRepository.getByEmailAndPassword(email, password);
            if(user != null){
                String jwt = TokenManager.generateToken(email);
                userAuthResponseDto.setToken(jwt);
                UserResponseDto userResponseDTO = modelMapper.map(user, UserResponseDto.class);
                userAuthResponseDto.setUser(userResponseDTO);

                return userAuthResponseDto;
            } else {
                return new ResponseEntity(HttpStatus.UNAUTHORIZED);
            }

    }

    @Override
    public UserResponseDto signUp(UserRequestDto userRequestDTO) {
        User user = modelMapper.map(userRequestDTO, User.class);
        try {
            user = userRepository.save(user);
        }catch (Exception e ){
            return null;
        }
        UserResponseDto userResponseDTO = modelMapper.map(user, UserResponseDto.class);
        return userResponseDTO;
    }
}
