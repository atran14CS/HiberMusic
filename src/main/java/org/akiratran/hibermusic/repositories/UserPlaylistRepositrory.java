package org.akiratran.hibermusic.repositories;
import org.akiratran.hibermusic.model.UserPlaylist;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserPlaylistRepositrory extends JpaRepository<UserPlaylist, Long> {
    UserPlaylist findByPlayListId(long id);
}
