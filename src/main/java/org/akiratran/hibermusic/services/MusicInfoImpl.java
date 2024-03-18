package org.akiratran.hibermusic.services;

import org.akiratran.hibermusic.model.MusicInfo;
import org.akiratran.hibermusic.repositories.MusicInfoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<MusicInfo> findMusicInfoBySongName(String songName) {
        return musicInfoRepository.findBySongName(songName);
    }

    @Override
    public List<MusicInfo> findMusicInfoByArtistName(String artistName) {
        return musicInfoRepository.findByArtistName(artistName);
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
