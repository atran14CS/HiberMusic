package org.akiratran.hibermusic.services;

import org.akiratran.hibermusic.model.User;
import org.akiratran.hibermusic.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Provides implemented methods of actions to be used in controller
 */
@Service
public class UserImpl implements UserService{
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UserImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Takes a new User and saves the new User information
     * @param newUser - The user being saved
     */
    @Override
    public void saveUser(User newUser) {
        User user = new User();
        user.setFirstName(newUser.getFirstName());
        user.setLastName(newUser.getLastName());
        user.setEmail(newUser.getEmail());
        user.setLocation(newUser.getLocation());
        user.setUserMusicInfo(newUser.getUserMusicInfo());
//        user.setPlaylists(newUser.getPlaylists());
        user.setUserRole(newUser.getUserRole());
        user.setPassword(passwordEncoder.encode(newUser.getPassword()));
        userRepository.save(user);
    }

    /**
     * Finds and return User of given id
     * @param id - id of User
     * @return {object} - User object that matches id
     */
    @Override
    public User findByUserId(Long id) {
        return userRepository.findByUid(id);
    }

    /**
     * Finds and returns the User of the given email
     * @param email - email of user
     * @return {object} - User object that matches email
     */
    public User findByUserEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
