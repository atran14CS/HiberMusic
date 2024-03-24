package org.akiratran.hibermusic.repositories;
import org.akiratran.hibermusic.model.MusicInfo;
import org.akiratran.hibermusic.model.User;
import org.akiratran.hibermusic.model.UserPlaylist;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Provides UserPlaylist access to CRUD operations from JpaRepository
 */
public interface UserPlaylistRepository extends JpaRepository<UserPlaylist, Long> {
    UserPlaylist findByPid(long pid);
    UserPlaylist findByPlaylistName(String playlistName);
    UserPlaylist save(UserPlaylist userPlaylist);
    UserPlaylist deleteUserPlaylistByPlaylistName(String playlistName);
    UserPlaylist deleteUserPlaylistByPid(Long pid);
    UserPlaylist findByUser(User user);
}
