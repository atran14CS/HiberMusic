package org.akiratran.hibermusic.services;

import org.akiratran.hibermusic.model.LikeMusic;
import org.akiratran.hibermusic.repositories.LikeMusicRepository;
import org.springframework.stereotype.Service;

@Service
public class LikeMusicImpl {
    private LikeMusicRepository likeMusicRepository;

    public LikeMusicImpl(LikeMusicRepository likeMusicRepository) {
        this.likeMusicRepository = likeMusicRepository;
    }

    public LikeMusic findLikeMusicByLid (Long lid) {
        return likeMusicRepository.findByLid(lid);
    }

    public void saveLikeMusic(LikeMusic likeMusic) {
        LikeMusic newLikeMusic = new LikeMusic();
        newLikeMusic.setMusicInfo(likeMusic.getMusicInfo());
        newLikeMusic.setLikeDate(likeMusic.getLikeDate());
        newLikeMusic.setUser(likeMusic.getUser());
        likeMusicRepository.save(newLikeMusic);
    }
}
