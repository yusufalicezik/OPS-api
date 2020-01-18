package com.yusufalicezik.OPSapi.service.Impl;

import com.yusufalicezik.OPSapi.dto.Request.CameraRequestDto;
import com.yusufalicezik.OPSapi.entity.Camera;
import com.yusufalicezik.OPSapi.entity.Park;
import com.yusufalicezik.OPSapi.entity.User;
import com.yusufalicezik.OPSapi.repository.CameraRapository;
import com.yusufalicezik.OPSapi.repository.UserRepository;
import com.yusufalicezik.OPSapi.service.CameraService;
import com.yusufalicezik.OPSapi.utils.DateFormatter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class CameraServiceImpl implements CameraService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    CameraRapository cameraRapository;

    @Autowired
    UserRepository userRepository;

    @Override
    public Camera updateCameraStatus(CameraRequestDto cameraRequestDto) { //Park cameraları, bağlı merkezler ve kullanıcının park detay/hesap detay/borç güncellenir.
        User parkedUser = userRepository.getByPlateNo(cameraRequestDto.getPlateNo());
        if(parkedUser != null){
            List<Park> oldParks = parkedUser.getUserDetail().getParkList();
            Park newPark = new Park();
            newPark.setPlaceName(cameraRequestDto.getName());
            newPark.setOut(!cameraRequestDto.isStatus());
            newPark.setPaid(false);
            newPark.setDate(Calendar.getInstance().getTime());
            if(cameraRequestDto.isStatus()){ //park giriş ise
                newPark.setAmount(0);
                oldParks.add(newPark);
            }else{
                for(int i = 0; i<oldParks.size();i++){ //update last entered park
                    if(!oldParks.get(i).isOut()){
                        Park p = oldParks.get(i);
                        p.setOut(true);
                        p.setAmount(new DateFormatter().getTotalAmountFromDate(p.getDate(), newPark.getDate(),
                            cameraRapository.findById(cameraRequestDto.getId()).get().getAmount()));
                        oldParks.set(i, p);
                    }
                }
            }
            parkedUser.getUserDetail().setParkList(oldParks);
            userRepository.save(parkedUser);

        }//else durumu guest user create
        else{

        }
        return cameraRapository.save(modelMapper.map(cameraRequestDto, Camera.class));
    }
}
