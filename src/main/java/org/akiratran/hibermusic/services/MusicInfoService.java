package org.akiratran.hibermusic.services;

import org.akiratran.hibermusic.model.MusicInfo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Defines what methods are available for the MusicInfoService
 */

public interface MusicInfoService {
    /**
     * Finds the MusicInfo by mid
     * @param mid {Long} - the mid that belongs to the musicInfo
     * @return {Object} - returns the musicInfo that has the corresponding of mid
     */
    MusicInfo findMusicInfoByMid(Long mid); //

    /**
     * Finds the musicInfo based on the search phrase
     * @param searchPhrase {String} - the search phrase to find musicInfo
     * @return {Object} - returns the matching musicInfo that relate to the search phrase
     */
    List<MusicInfo> findMusicInfoBySongNameOrArtistName(String searchPhrase);
    void saveMusicInfo(MusicInfo musicInfo);

    /**
     * Finds the trending songs
     * @return {Object} - returns the top 6 trending songs
     */
    List<MusicInfo> findTrendingSong();

    /**
     * Finds the most like songs
     * @return {Object} - returns the top 6 like songs
     */
    List<MusicInfo> findMostLikedSong();
}
