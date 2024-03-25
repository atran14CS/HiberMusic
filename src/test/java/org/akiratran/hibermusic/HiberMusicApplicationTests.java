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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
class HiberMusicApplicationTests {
    User user1;
    User user2;
    UserRepository userRepository;
    PasswordEncoder passwordEncoder;
    UserService userService;
    UserImpl userImpl;


    @BeforeEach
    public void setUpUserTest(UserImpl userImpl) throws Exception {
        List<Role> role = new ArrayList<>();
        user1 = new User();
        user2 = new User("Monkey D.", "Luffy", "monkeydluffy@gmail.com", "East Blue", "password", role);
        this.userImpl = userImpl;
    }

    @Test
    public void testFindByEmail() {
        assertNotEquals(user2, userImpl.findByUserEmail("monkeydluffy@gmail.com"));
    }

}
