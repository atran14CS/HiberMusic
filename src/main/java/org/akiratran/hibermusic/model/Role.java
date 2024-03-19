package org.akiratran.hibermusic.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.util.ArrayList;
import java.util.List;

/**
 * Role Model Class describes what a Role is and the relationship between other entities
 */

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Role {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long rid;
    @Column(nullable=false, unique = true)
    String roleName;
    @ManyToMany(mappedBy = "userRole")
    List<User> roleUser = new ArrayList<>();

    public Role(String roleName, List<User> roleUser) {
        this.roleName = roleName;
        this.roleUser = roleUser;
    }
}

