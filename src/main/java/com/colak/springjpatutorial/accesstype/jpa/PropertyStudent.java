package com.colak.springjpatutorial.accesstype.jpa;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Entity;
import lombok.extern.slf4j.Slf4j;

/**
 * Use use getter and setter methods
 */
@Entity
@Access(AccessType.PROPERTY)

@Slf4j
public class PropertyStudent {
    private String firstName;
    private String lastName;

    public String getLastName() {
        log.info("getting lastname");
        return lastName;
    }

    public void setLastName(String lastName) {
        log.info("setting lastname");
        this.lastName = lastName;
    }

    public String getFirstName() {
        log.info("getting firstname");
        return firstName;
    }

    public void setFirstName(String firstName) {
        log.info("setting firstname");
        this.firstName = firstName;
    }
}
