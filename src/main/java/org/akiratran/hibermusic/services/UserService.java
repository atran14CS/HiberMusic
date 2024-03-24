package org.akiratran.hibermusic.services;
import org.akiratran.hibermusic.model.User;

/**
 * Defines what methods are available for UserService
 */

public interface UserService {

    /**
     * Saves the user into the database
     * @param user - the user needing to be saved
     */
    void saveUser(User user);

    /**
     * Finds the user by the given email
     * @param email {String} - email of user wanting to find
     * @return {Object} - returns user object corresponding to the email
     */
    User findByUserEmail(String email);

    /**
     * Deletes the user by the email
     * @param email {String} email of the user needed to be deleted
     */
    void deleteUser(String email);
}
