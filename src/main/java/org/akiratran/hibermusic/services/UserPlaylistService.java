package org.akiratran.hibermusic.services;

import org.akiratran.hibermusic.model.MusicInfo;
import org.akiratran.hibermusic.model.User;
import org.akiratran.hibermusic.model.UserPlaylist;

import java.util.List;

/**
 * Defines what methods are available for the UserPlayListService
 */

public interface UserPlaylistService {

    /**
     * Saves the userPlaylist into the database
     * @param userPlaylist {Object} - the playlist
     */
    void savePlaylist(UserPlaylist userPlaylist);

    /**
     * Finds the userPlaylist by the playlist name
     * @param userPlaylistName {String} - name of the playlist trying to find
     * @return {Object} - returns the playlist that has the playlist name
     */
    UserPlaylist findByUserPlaylistName(String userPlaylistName);

    /**
     * Finds the UserPlaylist by the pid
     * @param pid {Long} - the pid of the userPlayList
     * @return {Object} - returns the UserPlaylist with the given pid
     */
    UserPlaylist findByUserPlaylistPid(Long pid);

    /**
     * Deletes the UserPlaylist by the playlist name
     * @param userPlayListName {String} - name of the playlist trying to delete
     */
    void deleteUserPlaylistByName(String userPlayListName);

    /**
     * Deletes the UserPlayList by the pid
     * @param pid {Long} - pid of the playlist trying to be deleted
     */
    void deleteUserPlaylistByPid(Long pid);
}
