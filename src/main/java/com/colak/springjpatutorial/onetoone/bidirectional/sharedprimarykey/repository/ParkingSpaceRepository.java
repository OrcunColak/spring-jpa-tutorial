package com.colak.springjpatutorial.onetoone.bidirectional.sharedprimarykey.repository;

import com.colak.springjpatutorial.onetoone.bidirectional.sharedprimarykey.jpa.ParkingSpace;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkingSpaceRepository extends JpaRepository<ParkingSpace, Integer> {
}
