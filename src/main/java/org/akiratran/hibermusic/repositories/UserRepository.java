package org.akiratran.hibermusic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.akiratran.hibermusic.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUid(long id);
    User findByEmail(String email);
    User save(User user);
}
