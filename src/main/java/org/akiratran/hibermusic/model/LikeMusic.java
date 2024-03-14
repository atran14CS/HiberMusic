package org.akiratran.hibermusic.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

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



    public LikeMusic(User user, MusicInfo musicInfo, LocalDateTime likeDate) {
        this.user = user;
        this.musicInfo = musicInfo;
        this.likeDate = likeDate;
    }
}
