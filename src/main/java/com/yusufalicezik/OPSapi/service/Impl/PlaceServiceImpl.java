package com.yusufalicezik.OPSapi.service.Impl;

import com.yusufalicezik.OPSapi.entity.Place;
import com.yusufalicezik.OPSapi.repository.PlaceRepository;
import com.yusufalicezik.OPSapi.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceServiceImpl implements PlaceService {

    @Autowired
    private PlaceRepository placeRepository;

    @Override
    public List<Place> getAllPlaces() {
        return placeRepository.findAll();
    }

    @Override
    public Place getPlaceByName(String name) {
        return placeRepository.findByName(name);
    }

    @Override
    public Place getPlaceById(int id) {
        return placeRepository.findById(id);
    }

    @Override
    public Place save(Place place) {
        return placeRepository.save(place);
    }
}
