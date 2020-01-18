package com.yusufalicezik.OPSapi.controller;


import com.yusufalicezik.OPSapi.entity.Place;
import com.yusufalicezik.OPSapi.service.Impl.PlaceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/place")

public class PlaceController {
    @Autowired
    private PlaceServiceImpl placeService;

    @PostMapping
    public ResponseEntity<Place> addNewPlace(@RequestBody Place place){
        return ResponseEntity.ok(placeService.save(place));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Place>> getAllPlaces(){
        return ResponseEntity.ok(placeService.getAllPlaces());
    }

    @GetMapping("/{name}")
    public ResponseEntity<Place> getPlaceByName(@PathVariable String name){
        return ResponseEntity.ok(placeService.getPlaceByName(name));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Place> getPlaceByID(@PathVariable int id){
        return ResponseEntity.ok(placeService.getPlaceById(id));
    }
}
