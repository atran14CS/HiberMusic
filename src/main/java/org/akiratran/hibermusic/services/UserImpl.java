package org.akiratran.hibermusic.services;

import org.akiratran.hibermusic.model.User;
import org.akiratran.hibermusic.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserImpl implements UserService{
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UserImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void saveUser(User newUser) {
        User user = new User();
        user.setFirstName(newUser.getFirstName());
        user.setLastName(newUser.getLastName());
        user.setEmail(newUser.getEmail());
        user.setLocation(newUser.getLocation());
        user.setUserMusicInfo(newUser.getUserMusicInfo());
        user.setPassword(passwordEncoder.encode(newUser.getPassword()));
        userRepository.save(user);
    }

    @Override
    public User findByUserId(Long id) {
        return userRepository.findByUid(id);
    }

}
