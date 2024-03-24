package org.akiratran.hibermusic.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.annotation.Bean;

import java.util.*;

/**
 * MusicInfo Model Class describes what a MusicInfo is and the relationship between other entities
 */

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString
//@Bean
public class MusicInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long mid;
    private String artistName;
    private String songName;
    private String mp3Link;
    private int views;
    private int likes;

//    @ManyToMany(mappedBy = "userMusicInfo")
//    private List<User> musicUser = new ArrayList<>();

//    @ManyToMany(mappedBy = "musicInformation")
//    List<UserPlaylist> playlists = new ArrayList<>();

    // remove the last 2 field intializer in the constructor debating if needed to try to save
    // playlist to user make things less complicated.

    /**
     * All args constructor
     * @param artistName {String} - Artist name of the music
     * @param songName {String} - Song name of the music
     * @param mp3Link {String} - The mp3 link of the music
     * @param views {int} - Number of views of the music
     * @param likes {int} - number of likes of the music
     */
    public MusicInfo(String artistName, String songName, String mp3Link, int views, int likes) {
        this.artistName = artistName;
        this.songName = songName;
        this.mp3Link = mp3Link;
        this.views = views;
        this.likes = likes;
//        this.musicUser = musicUser;
//        this.playlists = playlists;
    }
}
