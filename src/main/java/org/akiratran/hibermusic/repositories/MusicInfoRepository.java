package org.akiratran.hibermusic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.akiratran.hibermusic.model.MusicInfo;

import java.util.List;

/**
 * Provides methods to run sql query base on method name for MusicInfo table.
 */
public interface MusicInfoRepository extends JpaRepository<MusicInfo, Long> {
    MusicInfo findByMid(long mid);
    List<MusicInfo> findBySongName(String songName);
    List<MusicInfo> findByArtistName(String artistName);
    MusicInfo save(MusicInfo musicInfo);
}
