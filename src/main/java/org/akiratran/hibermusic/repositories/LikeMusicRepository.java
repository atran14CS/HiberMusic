package org.akiratran.hibermusic.repositories;

import org.akiratran.hibermusic.model.LikeMusic;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Provides LikeMusic access to CRUD operations from JpaRepository
 */
public interface LikeMusicRepository extends JpaRepository<LikeMusic, Long> {
    LikeMusic findByLid(Long lid);
    LikeMusic save(LikeMusic likeMusic);

}
