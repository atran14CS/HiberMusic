package org.akiratran.hibermusic.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString

public class UserPlaylist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long upid;
    @Column(nullable = false)
    String playListName;
    long id;
    long mid;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL);
    List<MusicInfo> musicForPlayList = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL);
    List<>


}
