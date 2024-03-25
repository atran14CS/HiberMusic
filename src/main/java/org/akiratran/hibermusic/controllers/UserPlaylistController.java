package org.akiratran.hibermusic.controllers;

import org.akiratran.hibermusic.model.LikeMusic;
import org.akiratran.hibermusic.model.MusicInfo;
import org.akiratran.hibermusic.model.User;
import org.akiratran.hibermusic.model.UserPlaylist;
import org.akiratran.hibermusic.services.LikeMusicService;
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
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * controls the different endpoints around UserPlaylist
 */

@Controller
public class UserPlaylistController {
    private UserPlaylistService userPlaylistService;
    private MusicInfoService musicInfoService;
    private UserService userService;
    private List<MusicInfo> temporaryPlaylist = new ArrayList<>();

    /**
     * Creates a new Instance of the UserPlaylistController
     * @param userPlaylistService {object}
     * @param userService {Object} - contains methods use for User data manipulation
     * @param musicInfoService {Object} - contains methods use for MusicInfo data manipulation
     */
    @Autowired
    public UserPlaylistController(UserPlaylistService userPlaylistService, MusicInfoService musicInfoService,
                                  UserService userService) {
        this.userPlaylistService = userPlaylistService;
        this.musicInfoService = musicInfoService;
        this.userService = userService;
    }

    /**
     * Adds clicked music into a current playlist to show the current list of added music
     * @param mid {Long} - The mid that belongs to added song
     * @param model {Object} - The model object contains the current list of added music
     * @return {String} - Returns the profile string to view the profile view page
     */
    @PostMapping("/profile/addToPlaylist")
    public String addToPlaylist(@RequestParam("mid") Long mid, Model model) {
        MusicInfo clickedMusicInfo = musicInfoService.findMusicInfoByMid(mid);
        temporaryPlaylist.add(clickedMusicInfo);
        System.out.println(temporaryPlaylist + " this is the temp playlist!!!!!!!!!!!!!!!!"); //debug statement
        System.out.println(temporaryPlaylist.size() + " this is the size!!!!!!!!!!!"); //debug statement
        model.addAttribute("temporaryPlaylist", temporaryPlaylist);
        System.out.println(temporaryPlaylist + " this is the playlist");
        return "/profile";
    }

    @PostMapping("/profile/createPlaylist")
    public String createPlaylist(Principal principal) {
        String email = principal.getName();
        System.out.println(email); //debug statement
        User currentUser = userService.findByUserEmail(email);

        UserPlaylist newPlayList = new UserPlaylist("newPlaylist1", currentUser, temporaryPlaylist);

        System.out.println(newPlayList + " this is the current playlist made");
//        System.out.println(currentUser.getPlaylists() + " this is the user playlists");
//        userPlaylistService.savePlaylist(newPlayList);
        //saving playlist to user playlists
//        currentUser.getPlaylists().add(newPlayList);
//        userService.saveUser(currentUser);
        temporaryPlaylist.clear();
        return "redirect:/profile";
    }
}


