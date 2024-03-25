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

    /**
     * All args constructor
     * @param firstName {String} - First name of the user
     * @param lastName {String} - Last name of the user
     * @param email {String} - Email of the user
     * @param location {String} - Location of the user
     * @param password {String} - Password of the user
     * @param userRole {String} - Role of the user
     * @param playlists {Object} - Playlist of the user
     */
    public User(String firstName, String lastName, String email, String location, String password, List<Role> userRole) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.location = location;
        this.password = password;
//        this.userMusicInfo = userMusicInfo;
        this.userRole = userRole;
//        playlists = new ArrayList<>();
//        this.playlists = playlists;
    }
}
