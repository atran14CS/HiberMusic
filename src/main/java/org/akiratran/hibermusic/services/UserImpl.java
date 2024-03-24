package org.akiratran.hibermusic.services;

import jakarta.transaction.Transactional;
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

    /**
     * Constructs a new instance of the UserImpl
     * @param userRepository {Object} - Contains the methods used for data manipulation of Users
     * @param passwordEncoder {Object} - Use to turn the password into hash
     */
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
     * Finds and returns the User of the given email
     * @param email - email of user
     * @return {object} - User object that matches email
     */
    public User findByUserEmail(String email) {
        return userRepository.findByEmail(email);
    }

    /**
     * Deletes the user by the email
     * @param email {String} email of the user needed to be deleted
     */
    @Transactional
    @Override
    public void deleteUser(String email) {
        User user = userRepository.findByEmail(email);
        if (user != null) {
            userRepository.delete(user);
        } else {
            // Handle case when user does not exist
            System.out.println("no user found");
        }
    }
}
