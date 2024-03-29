package org.akiratran.hibermusic.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

/**
 * LikeMusic Model Class Describes what a LikeMusic is and the relationship between other entities
 */

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString
public class LikeMusic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lid;

    @CreationTimestamp
    private LocalDateTime likeDate;

    @ManyToOne
    @JoinColumn(name = "uid")
    private User user;

    @ManyToOne
    @JoinColumn(name = "mid")
    private MusicInfo musicInfo;


    /**
     * All args constructor
     * @param user {Object} - The user of the like music
     * @param musicInfo {Object} - Music info of the music
     * @param likeDate {Object} - Date of when music was like
     */
    public LikeMusic(User user, MusicInfo musicInfo, LocalDateTime likeDate) {
        this.user = user;
        this.musicInfo = musicInfo;
        this.likeDate = likeDate;
    }
}
