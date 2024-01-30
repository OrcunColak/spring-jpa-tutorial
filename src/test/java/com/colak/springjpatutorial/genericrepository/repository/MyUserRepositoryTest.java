package com.colak.springjpatutorial.genericrepository.repository;


import com.colak.springjpatutorial.genericrepository.jpa.MyUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class MyUserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void testSave() {
        MyUser myUser = new MyUser();
        myUser.setName("user1");
        MyUser savedMyUser = userRepository.save(myUser);
        assertNotNull (savedMyUser.getId());

    }
}
