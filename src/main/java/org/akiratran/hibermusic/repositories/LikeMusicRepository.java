package org.akiratran.hibermusic.repositories;
import org.akiratran.hibermusic.model.LikeMusic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeMusicRepository extends JpaRepository<LikeMusic, Long> {
    LikeMusic findByLikeId(Long id);
}
