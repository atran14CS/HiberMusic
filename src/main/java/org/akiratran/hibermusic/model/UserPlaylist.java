package org.akiratran.hibermusic.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.util.ArrayList;
import java.util.List;

/**
 * UserPlaylist Model Class describes what a UserPlaylist is and the relationship it has
 * with other entities
 */

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString
public class UserPlaylist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pid;

    @Column(nullable = false)
    private String playlistName;

    @ManyToOne
    @JoinColumn(name = "uid")
    private User user;

    @ManyToMany
    @JoinTable(name = "userplaylist_music",
            joinColumns = @JoinColumn(name = "pid", referencedColumnName = "pid"),
            inverseJoinColumns = @JoinColumn(name = "mid", referencedColumnName = "mid"))
    private List<MusicInfo> musicInformation = new ArrayList<>();

    public UserPlaylist(String playlistName, User user, List<MusicInfo> musicInformation) {
        this.playlistName = playlistName;
        this.user = user;
        this.musicInformation = musicInformation;
    }
}
