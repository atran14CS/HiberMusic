package org.akiratran.hibermusic.services;

import org.akiratran.hibermusic.model.LikeMusic;
import org.akiratran.hibermusic.repositories.LikeMusicRepository;
import org.springframework.stereotype.Service;

/**
 * Implementation of the likeMusic service
 */

@Service
public class LikeMusicImpl {
    private LikeMusicRepository likeMusicRepository;

    /**
     * Constructs a new instance of LikeMusicImpl
     * @param likeMusicRepository {Object} - Respiratory contains methods for
     * manipulation of likeMusic data
     */
    public LikeMusicImpl(LikeMusicRepository likeMusicRepository) {
        this.likeMusicRepository = likeMusicRepository;
    }

    /**
     * Finds the LikeMusic by the lid
     * @param lid {Long} - lid of the likeMusic
     * @return {Object} - returns the likeMusic corresponding to the lid
     */
    public LikeMusic findLikeMusicByLid (Long lid) {
        return likeMusicRepository.findByLid(lid);
    }

    /**
     * Saves the LikeMusic into the database
     * @param likeMusic {Object} - The likeMusic being saved
     */
    public void saveLikeMusic(LikeMusic likeMusic) {
        LikeMusic newLikeMusic = new LikeMusic();
        newLikeMusic.setMusicInfo(likeMusic.getMusicInfo());
        newLikeMusic.setLikeDate(likeMusic.getLikeDate());
        newLikeMusic.setUser(likeMusic.getUser());
        likeMusicRepository.save(newLikeMusic);
    }
}
