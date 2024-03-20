package org.akiratran.hibermusic.services;

import org.akiratran.hibermusic.model.MusicInfo;
import org.akiratran.hibermusic.model.User;
import org.akiratran.hibermusic.model.UserPlaylist;
import org.akiratran.hibermusic.repositories.UserPlaylistRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserPlaylistImpl implements UserPlaylistService{
    private UserPlaylistRepository userPlaylistRepository;

    private List<MusicInfo> currentPlay;

    public UserPlaylistImpl(UserPlaylistRepository userPlaylistRepository, List<MusicInfo> currentPlay) {
        this.userPlaylistRepository = userPlaylistRepository;
        this.currentPlay = currentPlay;
    }

    @Override
    public void savePlaylist(UserPlaylist newUserPlaylist) {
        UserPlaylist userPlaylist = new UserPlaylist();
        userPlaylist.setPlaylistName(newUserPlaylist.getPlaylistName());
        userPlaylist.setMusicInformation(newUserPlaylist.getMusicInformation());
        userPlaylist.setUser(newUserPlaylist.getUser());
        userPlaylistRepository.save(userPlaylist);
    }

    @Override
    public UserPlaylist findByUserPlaylistName(String userPlaylistName) {
        return userPlaylistRepository.findByPlaylistName(userPlaylistName);
    }

    public UserPlaylist findByUserPlaylistPid(Long pid) {
        return userPlaylistRepository.findByPid(pid);
    }

    @Override
    public void deleteUserPlaylistByName(String userPlayListName) {
        userPlaylistRepository.deleteUserPlaylistByPlaylistName(userPlayListName);
    }

    public void deleteUserPlaylistByPid(Long pid) {
        userPlaylistRepository.deleteUserPlaylistByPid(pid);
    }

    @Override
    public void addMusicToCurrentUserPlaylist(MusicInfo musicInfo, User user) {
        // Fetch the current user's playlist
        UserPlaylist userPlaylist = userPlaylistRepository.findByUser(user);
        // Add the selected music to the playlist
        userPlaylist.getMusicInformation().add(musicInfo);
        // Save the updated playlist
        userPlaylistRepository.save(userPlaylist);
    }

    @Override
    public List<MusicInfo> currentPlaylist(MusicInfo musicInfo) {
        currentPlay.add(musicInfo);
        return currentPlay;
    }
}
