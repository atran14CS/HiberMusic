package org.akiratran.hibermusic.services;
import org.akiratran.hibermusic.model.LikeMusic;
import org.springframework.stereotype.Service;


public interface LikeMusicService {
    void saveLikeMusic(LikeMusic likeMusic);
    LikeMusic findLikeMusicByLid(Long lid);
}
