package org.akiratran.hibermusic.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString


public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false)
    String firstName;
    String lastName;
    String email;
    String location;
    @Column(nullable = false, unique = true)
    String password;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_music",
    joinColumns =
    {@JoinColumn(name = "user_id", referencedColumnName = "id")},
    inverseJoinColumns =
    {@JoinColumn(name = "music_id", referencedColumnName = "mid")})
    public List<MusicInfo> userMusicInfo = new ArrayList<>();

    public User(Long id, String firstName, String lastName, String email, String location, String password, List<MusicInfo> userMusicInfo) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.location = location;
        this.password = password;
        this.userMusicInfo = userMusicInfo;
    }
}
