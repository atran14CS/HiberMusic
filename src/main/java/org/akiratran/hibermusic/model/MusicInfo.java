package org.akiratran.hibermusic.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.util.*;
@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString

public class MusicInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long mid;
    private String artistName;
    private String songName;
    private String mp3Link;
    private int views;
    private int likes;

    @ManyToMany(mappedBy = "userMusicInfo")
    private List<User> musicUser = new ArrayList<>();

    @ManyToMany(mappedBy = "musicInformation")
    List<UserPlaylist> playlists = new ArrayList<>();


    public MusicInfo(String artistName, String songName, String mp3Link, int views, int likes, List<User> musicUser) {
        this.artistName = artistName;
        this.songName = songName;
        this.mp3Link = mp3Link;
        this.views = views;
        this.likes = likes;
        this.musicUser = musicUser;
    }
}
