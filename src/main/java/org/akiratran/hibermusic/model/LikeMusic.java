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

public class LikeMusic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long lid;
    @Column(nullable = false)
    long id;
    long mid;
}
