package com.colak.springjpatutorial.accesstype.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.extern.slf4j.Slf4j;

/**
 * Even though the default access type for the class is field, the introduction of @Id on top of the getter method
 * changes the default for the entire class to property.
 */
@Entity

@Slf4j
public class Student {
    private long id;
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

    @Id
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
