package org.akiratran.hibermusic.services;
import org.akiratran.hibermusic.model.User;

/**
 * layout for UserImpl
 */

public interface UserService {
    void saveUser(User user);
    User findByUserId(Long id);
    User findByUserEmail(String email);
}
