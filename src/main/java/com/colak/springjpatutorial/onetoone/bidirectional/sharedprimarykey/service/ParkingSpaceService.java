package com.colak.springjpatutorial.onetoone.bidirectional.sharedprimarykey.service;

import com.colak.springjpatutorial.onetoone.bidirectional.sharedprimarykey.jpa.ParkingSpace;

import java.util.List;

public interface ParkingSpaceService {

    List<ParkingSpace> findAll();
}
