package com.colak.springjpatutorial.auditing.repository;

import com.colak.springjpatutorial.auditing.jpa.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier,Long> {
}
