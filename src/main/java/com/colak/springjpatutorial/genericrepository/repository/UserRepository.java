package com.colak.springjpatutorial.genericrepository.repository;

import com.colak.springjpatutorial.genericrepository.baserepository.BaseRepository;
import com.colak.springjpatutorial.genericrepository.jpa.MyUser;

public interface UserRepository extends BaseRepository<MyUser, Integer> {
}
