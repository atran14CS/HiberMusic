package org.akiratran.hibermusic.services;

import org.akiratran.hibermusic.model.MusicInfo;
import org.akiratran.hibermusic.repositories.MusicInfoRepository;
import org.springframework.stereotype.Service;

@Service
public class MusicInfoImpl implements MusicInfoService{
    private MusicInfoRepository musicInfoRepository;

    public MusicInfoImpl(MusicInfoRepository musicInfoRepository) {
        this.musicInfoRepository = musicInfoRepository;
    }

    @Override
    public MusicInfo findMusicInfoByMid(Long mid) {
        return musicInfoRepository.findByMid(mid);
    }

    @Override
    public MusicInfo findMusicInfoBySongName(String songName) {
        return musicInfoRepository.findBySongName(songName);
    }

    public void saveMusicInfo(MusicInfo newMusicInfo) {
        MusicInfo musicInfo = new MusicInfo();
        musicInfo.setArtistName(newMusicInfo.getArtistName());
        musicInfo.setSongName(newMusicInfo.getSongName());
        musicInfo.setMp3Link(newMusicInfo.getMp3Link());
        musicInfo.setViews(newMusicInfo.getViews());
        musicInfo.setLikes(newMusicInfo.getLikes());
        musicInfo.setMusicUser(musicInfo.getMusicUser());
        musicInfo.setPlaylists(musicInfo.getPlaylists());
        musicInfoRepository.save(musicInfo);
    }
}
