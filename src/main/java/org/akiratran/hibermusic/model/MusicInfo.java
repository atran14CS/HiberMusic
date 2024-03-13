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
    long mid;
    String artistName;
    String songName;
    String mp3Link;
    int views;
    int likes;

    @ManyToMany
    List<User> musicUser = new ArrayList<>();

    public MusicInfo(long mid, String artistName, String songName, String mp3Link, int views, int likes, List<User> musicUser) {
        this.mid = mid;
        this.artistName = artistName;
        this.songName = songName;
        this.mp3Link = mp3Link;
        this.views = views;
        this.likes = likes;
        this.musicUser = musicUser;
    }
}
