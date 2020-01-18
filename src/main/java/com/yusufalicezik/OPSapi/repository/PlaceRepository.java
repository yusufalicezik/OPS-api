package com.yusufalicezik.OPSapi.repository;

import com.yusufalicezik.OPSapi.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlaceRepository extends JpaRepository<Place, Integer> {
    Place save(Place place);
    Place findByName(String name);
    Place findById(int id);
}