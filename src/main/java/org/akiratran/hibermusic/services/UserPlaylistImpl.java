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

    public UserPlaylistImpl(UserPlaylistRepository userPlaylistRepository) {
        this.userPlaylistRepository = userPlaylistRepository;
    }

    /**
     * Saves the userPlaylist into the database
     * @param newUserPlaylist {Object} - the playlist
     */
    @Override
    public void savePlaylist(UserPlaylist newUserPlaylist) {
        UserPlaylist userPlaylist = new UserPlaylist();
        userPlaylist.setPlaylistName(newUserPlaylist.getPlaylistName());
        userPlaylist.setMusicInformation(newUserPlaylist.getMusicInformation());
        userPlaylist.setUser(newUserPlaylist.getUser());
        userPlaylistRepository.save(userPlaylist);
    }

    /**
     * Finds the userPlaylist by the playlist name
     * @param userPlaylistName {String} - name of the playlist trying to find
     * @return {Object} - returns the playlist that has the playlist name
     */
    @Override
    public UserPlaylist findByUserPlaylistName(String userPlaylistName) {
        return userPlaylistRepository.findByPlaylistName(userPlaylistName);
    }

    /**
     * Finds the userPlaylist by the pid
     * @param pid {Long} - the pid of the userPlayList
     * @return {Object} - returns the UserPlaylist with the given pid
     */
    @Override
    public UserPlaylist findByUserPlaylistPid(Long pid) {
        return userPlaylistRepository.findByPid(pid);
    }

    /**
     * Deletes the UserPlaylist by the playlist name
     * @param userPlayListName {String} - name of the playlist trying to delete
     */
    @Override
    public void deleteUserPlaylistByName(String userPlayListName) {
        userPlaylistRepository.deleteUserPlaylistByPlaylistName(userPlayListName);
    }

    /**
     * Deletes the UserPlayList by the pid
     * @param pid {Long} - pid of the playlist trying to be deleted
     */
    public void deleteUserPlaylistByPid(Long pid) {
        userPlaylistRepository.deleteUserPlaylistByPid(pid);
    }
}
