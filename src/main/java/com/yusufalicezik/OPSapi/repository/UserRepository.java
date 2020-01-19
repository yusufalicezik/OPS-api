package com.yusufalicezik.OPSapi.repository;

import com.yusufalicezik.OPSapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User getByPlateNo(String plateNo);
    User getByEmailAndPassword(String email, String password);
    User findByEmail(String email);
}
