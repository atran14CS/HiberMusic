package org.akiratran.hibermusic.services;

import org.akiratran.hibermusic.model.MusicInfo;
import org.akiratran.hibermusic.repositories.MusicInfoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service methods used to help with MusicInfo data manipulation
 */

@Service
public class MusicInfoImpl implements MusicInfoService{
    private MusicInfoRepository musicInfoRepository;

    public MusicInfoImpl(MusicInfoRepository musicInfoRepository) {
        this.musicInfoRepository = musicInfoRepository;
    }

    /**
     * Finds the MusicInfo with the matching mid
     * @param mid - id of MusicInfo
     * @return {object} - returns the MusicInfo Object pertaining to the mid
     */
    @Override
    public MusicInfo findMusicInfoByMid(Long mid) {
        return musicInfoRepository.findByMid(mid);
    }

    /**
     * Finds the MusicInfos by the songName
     * @param songName - name of the song
     * @return {object} - list of MusicInfo pertaining to the song name
     */
    @Override
    public List<MusicInfo> findMusicInfoBySongName(String songName) {
        return musicInfoRepository.findBySongName(songName);
    }

    /**
     * Finds the MusicInfos by the artistName
     * @param artistName - name of the artist
     * @return {Object} - list of MusicInfo pertaining to the artist
     */
    @Override
    public List<MusicInfo> findMusicInfoByArtistName(String artistName) {
        return musicInfoRepository.findByArtistName(artistName);
    }

    /**
     * Finds the MusicInfos of the searchPhrase
     * @param searchPhrase{String} - the song name or artist name
     * @return {Object} Music info of the search phrase
     */
    @Override
    public List<MusicInfo> findMusicInfoBySongNameOrArtistName(String searchPhrase) {
        return musicInfoRepository.findBySongNameOrArtistName(searchPhrase);
    }

    /**
     * Finds the trendy songs
     * @return {Object} - returns a list of MusicInfo representing the most viewed songs in order DESC
     */
    @Override
    public List<MusicInfo> findTrendingSong() {
        return musicInfoRepository.findTrendingSong();
    }

    /**
     * Finds the most liked songs
     * @return {Object} - returns a list of MusicInfo representing the most liked song in order DESC
     */
    @Override
    public List<MusicInfo> findMostLikedSong() {
        return musicInfoRepository.findMostLikedSong();
    }

    /**
     * Saves new music infos
     * @param newMusicInfo
     */
    public void saveMusicInfo(MusicInfo newMusicInfo) {
        MusicInfo musicInfo = new MusicInfo();
        musicInfo.setArtistName(newMusicInfo.getArtistName());
        musicInfo.setSongName(newMusicInfo.getSongName());
        musicInfo.setMp3Link(newMusicInfo.getMp3Link());
        musicInfo.setViews(newMusicInfo.getViews());
        musicInfo.setLikes(newMusicInfo.getLikes());
        musicInfo.setMusicUser(musicInfo.getMusicUser());
//        musicInfo.setPlaylists(musicInfo.getPlaylists());
        musicInfoRepository.save(musicInfo);
    }
}
