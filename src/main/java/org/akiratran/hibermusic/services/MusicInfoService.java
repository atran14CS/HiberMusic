package org.akiratran.hibermusic.services;

import org.akiratran.hibermusic.model.MusicInfo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * layout for MusicInfoImpl
 */

public interface MusicInfoService {
    MusicInfo findMusicInfoByMid(Long mid); //
    List<MusicInfo> findMusicInfoBySongNameOrArtistName(String searchPhrase);
    List<MusicInfo> findMusicInfoByArtistName(String artistName);
    List<MusicInfo> findMusicInfoBySongName(String artistName);
    void saveMusicInfo(MusicInfo musicInfo);
    List<MusicInfo> findTrendingSong();
    List<MusicInfo> findMostLikedSong();
}
