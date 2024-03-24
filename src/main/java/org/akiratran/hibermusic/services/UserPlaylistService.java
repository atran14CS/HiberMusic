package org.akiratran.hibermusic.services;

import org.akiratran.hibermusic.model.MusicInfo;
import org.akiratran.hibermusic.model.User;
import org.akiratran.hibermusic.model.UserPlaylist;

import java.util.List;


public interface UserPlaylistService {
    void savePlaylist(UserPlaylist userPlaylist);
    UserPlaylist findByUserPlaylistName(String userPlaylistName);
    UserPlaylist findByUserPlaylistPid(Long pid);
    void deleteUserPlaylistByName(String userPlayListName);
    void deleteUserPlaylistByPid(Long pid);
    void addMusicToCurrentUserPlaylist(MusicInfo musicInfo, User user);
    List<MusicInfo> currentPlaylist(MusicInfo musicInfo);
}
