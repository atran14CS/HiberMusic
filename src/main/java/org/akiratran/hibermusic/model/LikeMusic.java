package org.akiratran.hibermusic.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString
public class LikeMusic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne
    @JoinColumn(name = "music_id")
    MusicInfo musicInfo;

    LocalDateTime likeDate;

    public LikeMusic(User user, MusicInfo musicInfo, LocalDateTime likeDate) {
        this.user = user;
        this.musicInfo = musicInfo;
        this.likeDate = likeDate;
    }
}
