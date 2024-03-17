package org.akiratran.hibermusic.services;

import org.akiratran.hibermusic.model.UserPlaylist;

public interface UserPlaylistService {
    void savePlaylist(UserPlaylist userPlaylist);
    UserPlaylist findByUserPlaylistName(String userPlaylistName);
    UserPlaylist findByUserPlaylistPid(Long pid);
    void deleteUserPlaylistByName(String userPlayListName);
    void deleteUserPlaylistByPid(Long pid);
}
