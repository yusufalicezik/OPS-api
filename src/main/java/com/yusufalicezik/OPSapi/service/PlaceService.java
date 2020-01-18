package com.yusufalicezik.OPSapi.service;

import com.yusufalicezik.OPSapi.entity.Place;

import java.util.List;

public interface PlaceService {
    List<Place> getAllPlaces();
    Place getPlaceByName(String name);
    Place getPlaceById(int id);
    Place save(Place place);
}
