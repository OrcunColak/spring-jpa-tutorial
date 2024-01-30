package com.colak.springjpatutorial.auditing.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

/**
 * "@CreatedBy, @CreatedDate, @LastModifiedBy, and @LastModifiedDate" annotations empower you to effortlessly
 * incorporate auditing attributes into your entity classes
 * <p>
 * "@MappedSuperclass" annotation marks this class as a non-persistent class and hibernate will not create/look up a
 * table mapping for this class.
 * <p>
 * "@EntityListeners" annotation specifies one or more listener classes that implement
 * the corresponding JPA callback methods for an entity class.
 * These methods will be invoked automatically when specified events occur  on the entity, such as
 * entity creation, update, or deletion.
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)

@Getter
@NoArgsConstructor
@SuperBuilder
public class AuditBase {

    @CreatedBy
    @Column(updatable = false)
    private String createdBy;

    @CreatedDate
    @Column(updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @LastModifiedBy
    private String lastModifiedBy;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;
}
