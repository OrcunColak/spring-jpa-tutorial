package com.colak.springjpatutorial.auditing.repository;

import com.colak.springjpatutorial.auditing.jpa.Supplier;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SupplierRepositoryTest {

    @Autowired
    private SupplierRepository supplierRepository;

    @Test
    void testSave() {
        Supplier supplier = new Supplier();
        supplier.setName("supplier");

        Supplier savedSupplier = supplierRepository.save(supplier);
        assertEquals("Orcun", savedSupplier.getCreatedBy());

    }
}
