package com.colak.springjpatutorial.auditing.repository;

import com.colak.springjpatutorial.auditing.config.SpringSecurityAuditorAwareImpl;
import com.colak.springjpatutorial.auditing.jpa.Supplier;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class SupplierRepositoryTest {

    @Autowired
    private SupplierRepository supplierRepository;

    @Test
    void testSave() {
        Supplier supplier = new Supplier();
        supplier.setName("supplier");

        Supplier savedSupplier1 = supplierRepository.saveAndFlush(supplier);

        // Auditor names
        // Created by is set by SpringSecurityAuditorAwareImpl object
        assertEquals(SpringSecurityAuditorAwareImpl.AUDITOR_NAME, savedSupplier1.getCreatedBy());
        assertEquals(SpringSecurityAuditorAwareImpl.AUDITOR_NAME, savedSupplier1.getLastModifiedBy());

        // @Temporal(TemporalType.TIMESTAMP) fields are set by Spring
        assertNotNull(savedSupplier1.getCreatedDate());
        assertNotNull(savedSupplier1.getLastModifiedDate());

        // Update
        Supplier updateSupplier = new Supplier();
        updateSupplier.setId(savedSupplier1.getId());
        updateSupplier.setName("new supplier");
        // Save entity does not read not updated columns
        supplierRepository.save(updateSupplier);

        // So we need to read the updated entity again to compare with the first entity
        Supplier savedSupplier2 = supplierRepository.findById(savedSupplier1.getId())
                .get();

        assertNotEquals(savedSupplier1.getName(), savedSupplier2.getName());

        // Auditor names
        assertEquals(savedSupplier1.getCreatedBy(), savedSupplier2.getCreatedBy());
        assertEquals(savedSupplier1.getLastModifiedBy(), savedSupplier2.getLastModifiedBy());

        // Temporal timestamps
        assertEquals(savedSupplier1.getCreatedDate(), savedSupplier1.getCreatedDate());
        assertNotEquals(savedSupplier1.getLastModifiedDate(), savedSupplier2.getLastModifiedDate());

    }
}
