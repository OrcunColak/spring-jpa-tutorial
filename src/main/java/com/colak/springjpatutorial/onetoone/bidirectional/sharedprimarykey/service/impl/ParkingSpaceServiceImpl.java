package com.colak.springjpatutorial.onetoone.bidirectional.sharedprimarykey.service.impl;

import com.colak.springjpatutorial.onetoone.bidirectional.sharedprimarykey.jpa.ParkingSpace;
import com.colak.springjpatutorial.onetoone.bidirectional.sharedprimarykey.repository.ParkingSpaceRepository;
import com.colak.springjpatutorial.onetoone.bidirectional.sharedprimarykey.service.ParkingSpaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ParkingSpaceServiceImpl implements ParkingSpaceService {

    private final ParkingSpaceRepository parkingSpaceRepository;

    @Transactional(readOnly = true)
    @Override
    public List<ParkingSpace> findAll() {
        return parkingSpaceRepository.findAll();
    }
}
