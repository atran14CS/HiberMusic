package org.akiratran.hibermusic.repositories;
import org.akiratran.hibermusic.model.MusicInfo;
import org.akiratran.hibermusic.model.User;
import org.akiratran.hibermusic.model.UserPlaylist;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Provides UserPlaylist access to CRUD operations from JpaRepository
 */
public interface UserPlaylistRepository extends JpaRepository<UserPlaylist, Long> {
    /**
     * Finds the UserPlaylist by the pid
     * @param pid {Long} - the pid of the playlist trying to be found
     * @return {Object} - returns the UserPlaylist with the matching pid
     */
    UserPlaylist findByPid(long pid);

    /**
     * Finds the UserPlaylist by the name
     * @param playlistName {String} - the name of the playlist trying to be found
     * @return {Object} - returns the UserPlaylist with the matching playlsitName
     */
    UserPlaylist findByPlaylistName(String playlistName);

    /**
     * Saves the userPlaylist
     * @param userPlaylist {Object} - the UserPlaylist that is being saved
     * @return {Object} - returns the save UserPlaylist
     */
    UserPlaylist save(UserPlaylist userPlaylist);

    /**
     * Deletes the UserPlaylist by the playlist name
     * @param playlistName {String} - the name of the playlist wanting to be deleted
     * @return {Object} - returns the deleted playlist
     */
    UserPlaylist deleteUserPlaylistByPlaylistName(String playlistName);

    /**
     * Deletes the UserPlaylist by the pid
     * @param pid {Long} the pid of the playlist wanting to be deleted
     * @return {Object} - returns the deleted playlist
     */
    UserPlaylist deleteUserPlaylistByPid(Long pid);
}
