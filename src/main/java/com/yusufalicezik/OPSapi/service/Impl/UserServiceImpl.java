package com.yusufalicezik.OPSapi.service.Impl;

import com.yusufalicezik.OPSapi.dto.Request.UserRequestDto;
import com.yusufalicezik.OPSapi.dto.Response.UserResponseDto;
import com.yusufalicezik.OPSapi.entity.User;
import com.yusufalicezik.OPSapi.repository.UserRepository;
import com.yusufalicezik.OPSapi.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public UserResponseDto save(UserRequestDto userRequestDto) {
        User savedUser = modelMapper.map(userRequestDto, User.class);
        UserResponseDto responseDto = modelMapper.map(userRepository.save(savedUser), UserResponseDto.class);
        return responseDto;
    }

    @Override
    public List<UserResponseDto> getAllUser() {
        List<User> userList = userRepository.findAll();
        return Arrays.asList(modelMapper.map(userList, UserResponseDto[].class));
    }

    @Override
    public UserResponseDto getUserByPlate(String plateNo) {
        return modelMapper.map(userRepository.getByPlateNo(plateNo), UserResponseDto.class);
    }
}