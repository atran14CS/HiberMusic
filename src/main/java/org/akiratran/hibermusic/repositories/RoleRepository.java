package org.akiratran.hibermusic.repositories;

import org.akiratran.hibermusic.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRoleName(String name);
}
