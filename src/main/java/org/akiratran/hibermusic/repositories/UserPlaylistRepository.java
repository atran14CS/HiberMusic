package org.akiratran.hibermusic.repositories;
import org.akiratran.hibermusic.model.UserPlaylist;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserPlaylistRepository extends JpaRepository<UserPlaylist, Long> {
    UserPlaylist findByPid(long pid);
}
