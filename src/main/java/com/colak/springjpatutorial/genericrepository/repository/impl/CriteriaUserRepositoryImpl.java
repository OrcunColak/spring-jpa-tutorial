package com.colak.springjpatutorial.genericrepository.repository.impl;

import com.colak.springjpatutorial.genericrepository.baserepository.impl.CriteriaBaseRepositoryImpl;
import com.colak.springjpatutorial.genericrepository.jpa.MyUser;
import com.colak.springjpatutorial.genericrepository.repository.UserRepository;
import org.springframework.stereotype.Component;

@Component(value = "criteriaUserRepository")
public class CriteriaUserRepositoryImpl extends CriteriaBaseRepositoryImpl<MyUser, Integer> implements UserRepository {

    public CriteriaUserRepositoryImpl() {
        super(MyUser.class);
    }
}
