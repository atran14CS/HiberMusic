package org.akiratran.hibermusic.services;

import org.akiratran.hibermusic.model.MusicInfo;

import java.util.List;

/**
 * layout for MusicInfoImpl
 */

public interface MusicInfoService {
    MusicInfo findMusicInfoByMid(Long mid);
    List<MusicInfo> findMusicInfoBySongName(String songName);
    List<MusicInfo> findMusicInfoByArtistName(String artistName);
    void saveMusicInfo(MusicInfo musicInfo);
}
