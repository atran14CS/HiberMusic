package org.akiratran.hibermusic;

import org.akiratran.hibermusic.model.Role;
import org.akiratran.hibermusic.model.User;
import org.akiratran.hibermusic.repositories.UserRepository;
import org.akiratran.hibermusic.services.UserImpl;
import org.akiratran.hibermusic.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class HiberMusicApplicationTests {
    User user1;
    User user2;
    UserRepository userRepository;
    PasswordEncoder passwordEncoder;
    UserImpl userImpl;


    @BeforeEach
    public void setUpUserTest() throws Exception {
        List<Role> role = new ArrayList<>();
        user1 = new User();
        user2 = new User("Monkey D.", "Luffy", "monkeydluffy@gmail.com", "East Blue", "password", role);
        userImpl = new UserImpl(userRepository, passwordEncoder);
    }

//    @Test
//    public void testUser() {
//        assert.e
//    }

    @Test
    void contextLoads() {
    }

}
