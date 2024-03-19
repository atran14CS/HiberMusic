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
    public String addToPlaylist(@RequestParam("mid") Long mid, Model model) {
        // find the adding music
        System.out.println(mid); //debug statement
        MusicInfo clickedMusicInfo = musicInfoService.findMusicInfoByMid(mid);

        //create and add to playlist
        UserPlaylist newPlaylist = new UserPlaylist();
        List<MusicInfo> currentPlaylist = newPlaylist.getMusicInformation();
        currentPlaylist.add(clickedMusicInfo);
        System.out.println(currentPlaylist);

        model.addAttribute("currentPlaylist", currentPlaylist);


        return "/profile";
    }
}
