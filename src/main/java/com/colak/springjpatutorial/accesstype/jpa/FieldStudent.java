package com.colak.springjpatutorial.accesstype.jpa;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.extern.slf4j.Slf4j;

/**
 * AccessType.FIELD is the default behavior. It uses member fields rather than getters and setters.
 * This example uses it in mixed fashion for lastName field
 */
@Entity
@Access(AccessType.FIELD)

@Slf4j
public class FieldStudent {

    @Id
    private int id;

    private String firstName;

    @Access(AccessType.PROPERTY)
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
