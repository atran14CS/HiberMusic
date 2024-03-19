package org.akiratran.hibermusic.controllers;

import org.akiratran.hibermusic.model.MusicInfo;
import org.akiratran.hibermusic.model.User;
import org.akiratran.hibermusic.model.UserPlaylist;
import org.akiratran.hibermusic.services.MusicInfoService;
import org.akiratran.hibermusic.services.UserPlaylistService;
import org.akiratran.hibermusic.services.UserService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserPlaylistController {
    private UserPlaylistService userPlaylistService;
    private MusicInfoService musicInfoService;
    private UserService userService;


    @Autowired
    public UserPlaylistController(UserPlaylistService userPlaylistService, MusicInfoService musicInfoService, UserService userService) {
        this.userPlaylistService = userPlaylistService;
        this.musicInfoService = musicInfoService;
        this.userService = userService;
    }






    @PostMapping("/profile/addToPlaylist")
    public String addToPlaylist(@RequestParam("mid") Long mid, Principal principal) {
        // find the adding music
        System.out.println(mid); //debug statement
        MusicInfo clickedMusicInfo = musicInfoService.findMusicInfoByMid(mid);

        //create and add to playlist
        UserPlaylist newPlaylist = new UserPlaylist();
        List<MusicInfo> currentList = newPlaylist.getMusicInformation();
        currentList.add(clickedMusicInfo);
        System.out.println(currentList);
//        newPlaylist.setMusicInformation(currentList);

        //add playlist to current logged-in user
        String currentName = principal.getName();
        System.out.println(currentName); //debug statement
        User currentUser = userService.findByUserEmail(currentName);
        System.out.println(currentUser.toString()); //debug statement;
//        currentUser.getPlaylists().add(newPlaylist);




//        MusicInfo musicInfo = musicInfoService.findMusicInfoByMid(mid);
//        userPlaylistService.addMusicToCurrentUserPlaylist(musicInfo, currentUser);
//        System.out.println(currentUser.getPlaylists());
        // Add the MusicInfo to the user's playlist
        // (Assuming you have a method in your service to add MusicInfo to a playlist)
        // Example: userPlaylistService.addMusicInfoToPlaylist(musicInfo, user);
        // Redirect back to the profile page
        return "redirect:/profile";
    }
}
