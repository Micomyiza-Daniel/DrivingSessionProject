package com.bus.service.implementation;

import com.bus.model.DriverModel;
import com.bus.repository.DriverRepository;
import com.bus.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverImplementation implements DriverService {

    @Autowired


    DriverRepository driverRepo;
    @Override
    public DriverModel registerDriver(DriverModel driver) {
        return driverRepo.save(driver);
    }

    @Override
    public DriverModel updateDriver(DriverModel driver) {
       DriverModel d = findDriverById(driver);
       if(d!=null){
           d.setId(driver.getId());
           d.setSurname(driver.getSurname());
           d.setEmail(driver.getEmail());
           d.setUsername(driver.getUsername());
           d.setPassword(driver.getPassword());
           return driverRepo.save(d);
       }else {
           return registerDriver(driver);
       }

    }

    @Override
    public List<DriverModel> userList() {
        return driverRepo.findAll();
    }

    @Override
    public DriverModel findDriverById(DriverModel driver) {
        return driverRepo.findById(driver.getId()).get();
    }

    @Override
    public void deleteDriver(DriverModel driver) {
        driverRepo.delete(driver);
    }
}
