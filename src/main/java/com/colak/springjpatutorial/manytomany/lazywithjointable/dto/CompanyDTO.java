package com.colak.springjpatutorial.manytomany.lazywithjointable.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
@Accessors(chain = true)
public class CompanyDTO {

    private int id;

    private String name;

    private Set<Integer> projectIds;
}
