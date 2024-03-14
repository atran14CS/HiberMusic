package org.akiratran.hibermusic.services;
import org.akiratran.hibermusic.model.User;

public interface UserService {
    void saveUser(User user);
    User findByUserId(Long id);
}
