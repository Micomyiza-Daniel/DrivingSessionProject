package com.bus.repository;

import com.bus.model.DriverModel;
import com.bus.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DriverRepository extends JpaRepository<DriverModel, Integer> {

    Optional<DriverModel> findById(Integer id);
    Optional<DriverModel> findFirstById(Integer id);



}
