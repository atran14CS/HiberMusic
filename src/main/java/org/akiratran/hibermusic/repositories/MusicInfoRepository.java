package org.akiratran.hibermusic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.akiratran.hibermusic.model.MusicInfo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Provides MusicInfo access to CRUD operations from JpaRepository
 */

public interface MusicInfoRepository extends JpaRepository<MusicInfo, Long> {

    /**
     * Following FIND_BY_SONG_OR_ARTIST_QUERY, FIND_TRENDING_SONG_QUERY, FIND_MOST_LIKED_SONG_QUERY
     * are constant variable use for querying results with MusicInfo
     */
    public static final String FIND_BY_SONG_OR_ARTIST_QUERY = "SELECT m FROM MusicInfo m WHERE m.artistName like %:searchPhrase% or m.songName like %:searchPhrase";
    public static final String FIND_TRENDING_SONG_QUERY = "SELECT m FROM MusicInfo m ORDER BY m.views DESC LIMIT 6";
    public static final String FIND_MOST_LIKED_SONG_QUERY = "SELECT m FROM MusicInfo m ORDER BY m.likes DESC LIMIT 6";

    /**
     * Finds the MusicInfo by the mid
     * @param mid {Long} - mid of the MusicInfo trying to find
     * @return {Object} - returns the MusicInfo corresponding to the mid.
     */
    MusicInfo findByMid(long mid);

    /**
     * Custom query 1 finds the MusicInfo based on the search phrase
     * @param searchPhrase {String} - the search entry in the search bar to find MusicInfos
     * @return {Object} - returns a list of MusicInfo that relate to the searchPhrase
     */
    @Query(FIND_BY_SONG_OR_ARTIST_QUERY)
    List<MusicInfo> findBySongNameOrArtistName(@Param("searchPhrase") String searchPhrase);


    /**
     * Saves the MusicInfo
     * @param musicInfo {Object} - the MusicInfo that is being saved
     * @return {Object} -returns the save MusicInfo
     */
    MusicInfo save(MusicInfo musicInfo);

    /**
     * Custom query 2 finds the MusicInfos with the most views
     * @return {object} - returns a list of the top 6 most viewed songs in DESC order
     */
    @Query(FIND_TRENDING_SONG_QUERY)
    List<MusicInfo> findTrendingSong();

    /**
     * Custom query 3 finds the MusicInfos with the most likes
     * @return {Object} - returns a list of the top 6 liked songs in DESC order
     */
    @Query(FIND_MOST_LIKED_SONG_QUERY)
    List<MusicInfo> findMostLikedSong();
}

