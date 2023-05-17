package com.bus.service;

import com.bus.model.DriverModel;
import com.bus.model.UserModel;

import java.util.List;

public interface DriverService {
    DriverModel registerDriver(DriverModel driver);
    DriverModel updateDriver(DriverModel driver);
    List<DriverModel> userList();
    DriverModel findDriverById(DriverModel driver);

    void deleteDriver(DriverModel driver);
}
