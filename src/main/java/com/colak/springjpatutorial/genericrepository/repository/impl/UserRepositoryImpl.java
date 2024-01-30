package com.colak.springjpatutorial.genericrepository.repository.impl;

import com.colak.springjpatutorial.genericrepository.baserepository.impl.BaseRepositoryImpl;
import com.colak.springjpatutorial.genericrepository.jpa.MyUser;
import com.colak.springjpatutorial.genericrepository.repository.UserRepository;
import org.springframework.stereotype.Component;

@Component(value = "userRepository")
public class UserRepositoryImpl extends BaseRepositoryImpl<MyUser, Integer> implements UserRepository {

    public UserRepositoryImpl() {
        super(MyUser.class);
    }
}
