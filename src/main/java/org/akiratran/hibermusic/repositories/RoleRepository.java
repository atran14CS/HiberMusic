package org.akiratran.hibermusic.repositories;

import org.akiratran.hibermusic.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Provides Role access to CRUD operations from JpaRepository
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
    /**
     * Finds the role by the name
     * @param name {String} name of the role
     * @return the role
     */
    Role findByRoleName(String name);
}
