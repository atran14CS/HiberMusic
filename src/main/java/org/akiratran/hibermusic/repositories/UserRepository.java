package org.akiratran.hibermusic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.akiratran.hibermusic.model.User;

/**
 * Provides User access to CRUD operations from JpaRepository
 */
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * Finds the User by the id
     * @param id {Long} - the id of the user wanting to find
     * @return {Object} - the user with the corresponding id
     */
    User findByUid(long id);

    /**
     * Finds the User by the email
     * @param email {String} - the email belonging to the user wanting to find
     * @return {Object} - returns the User with the corresponding email
     */
    User findByEmail(String email);

    /**
     * Saves the User
     * @param user {Object} - the user that is needing to nave
     * @return {Object} - returns the save User
     */
    User save(User user);

    /**
     * Deletes the User by the email
     * @param email {String} - the email of the user being deleted
     * @return {Object} - returns the deleted user with the corresponding email
     */
    User deleteUsersByEmail(String email);
}
