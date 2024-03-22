package org.akiratran.hibermusic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.akiratran.hibermusic.model.MusicInfo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Provides methods to run sql query base on method name for MusicInfo table.
 */
public interface MusicInfoRepository extends JpaRepository<MusicInfo, Long> {
    MusicInfo findByMid(long mid); // finds the MusicInfo by mid
    @Query("SELECT m FROM MusicInfo m WHERE m.artistName like %:searchPhrase% or m.songName like %:searchPhrase")
    List<MusicInfo> findBySongNameOrArtistName (@Param("searchPhrase") String searchPhrase);
    List<MusicInfo> findBySongName(String songName); // finds the MusicInfo by songName
    List<MusicInfo> findByArtistName(String artistName); //finds the MusicInfo by the artistName
    MusicInfo save(MusicInfo musicInfo); //saves the new MusicInfo
    @Query("SELECT m FROM MusicInfo m ORDER BY m.views DESC LIMIT 6")
    List<MusicInfo> findTrendingSong();

    @Query("SELECT m FROM MusicInfo m ORDER BY m.likes DESC LIMIT 6")
    List<MusicInfo> findMostLikedSong();
}
