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
    public static final String FIND_BY_SONG_OR_ARTIST_QUERY = "SELECT m FROM MusicInfo m WHERE m.artistName like %:searchPhrase% or m.songName like %:searchPhrase";
    public static final String FIND_TRENDING_SONG_QUERY = "SELECT m FROM MusicInfo m ORDER BY m.views DESC LIMIT 6";
    public static final String FIND_MOST_LIKED_SONG_QUERY = "SELECT m FROM MusicInfo m ORDER BY m.likes DESC LIMIT 6";
    MusicInfo findByMid(long mid);
    @Query(FIND_BY_SONG_OR_ARTIST_QUERY)
    List<MusicInfo> findBySongNameOrArtistName(@Param("searchPhrase") String searchPhrase);
    MusicInfo save(MusicInfo musicInfo);
    @Query(FIND_TRENDING_SONG_QUERY)
    List<MusicInfo> findTrendingSong();
    @Query(FIND_MOST_LIKED_SONG_QUERY)
    List<MusicInfo> findMostLikedSong();
}

