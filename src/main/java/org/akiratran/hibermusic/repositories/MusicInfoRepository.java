package org.akiratran.hibermusic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.akiratran.hibermusic.model.MusicInfo;

public interface MusicInfoRepository extends JpaRepository<MusicInfo, Long> {

    MusicInfo findByMusicId(long id);

}
