package org.akiratran.hibermusic.services;

import org.akiratran.hibermusic.model.MusicInfo;


public interface MusicInfoService {
    MusicInfo findMusicInfoByMid(Long mid);
    MusicInfo findMusicInfoBySongName(String songName);
    void saveMusicInfo(MusicInfo musicInfo);
}
