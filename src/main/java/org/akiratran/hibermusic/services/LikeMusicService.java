package org.akiratran.hibermusic.services;
import org.akiratran.hibermusic.model.LikeMusic;
import org.springframework.stereotype.Service;

/**
 * Defines what methods are available for LikeMusicService
 */
public interface LikeMusicService {
    /**
     * Saves the likeMusic
     * @param likeMusic {Object} - The likeMusic object
     */
    void saveLikeMusic(LikeMusic likeMusic);

    /**
     * Finds the likeMusic by lid
     * @param lid {Long} - the lid of the likeMusic
     * @return {Object} - returns the like music that corresponds to the lid
     */
    LikeMusic findLikeMusicByLid(Long lid);
}
