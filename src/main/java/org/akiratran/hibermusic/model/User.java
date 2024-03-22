package org.akiratran.hibermusic.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.util.ArrayList;
import java.util.List;

/**
 * User Model Class describe what a user is and the relationships between other entities
 */

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;
    @Column(nullable = false)
    private String firstName;
    private String lastName;
    private String email;
    private String location;
    @Column(nullable = false, unique = true)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_music",
            joinColumns = @JoinColumn(name = "uid", referencedColumnName = "uid"),
            inverseJoinColumns = @JoinColumn(name = "mid", referencedColumnName = "mid"))
    private List<MusicInfo> userMusicInfo = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "uid", referencedColumnName = "uid"),
            inverseJoinColumns = @JoinColumn(name = "rid", referencedColumnName = "rid"))
    private List<Role> userRole = new ArrayList<>();

//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//    private List<UserPlaylist> playlists;

    public User(String firstName, String lastName, String email, String location, String password, List<MusicInfo> userMusicInfo, List<Role> userRole, List<UserPlaylist> playlists) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.location = location;
        this.password = password;
        this.userMusicInfo = userMusicInfo;
        this.userRole = userRole;
//        playlists = new ArrayList<>();
//        this.playlists = playlists;
    }
}
