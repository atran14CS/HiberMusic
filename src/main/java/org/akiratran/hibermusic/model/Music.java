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


public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long sid;
    String artistName;
    String songName;
    String mp3Link;
    int views;
    int likes;

    @ManyToMany
    List<User> musicUser = new ArrayList<>();

    public Music(long sid, String artistName, String songName, String mp3Link, int views, int likes, List<User> musicUser) {
        this.sid = sid;
        this.artistName = artistName;
        this.songName = songName;
        this.mp3Link = mp3Link;
        this.views = views;
        this.likes = likes;
        this.musicUser = musicUser;
    }
}
