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

@Controller
public class UserPlaylistController {
    private UserPlaylistService userPlaylistService;
    private MusicInfoService musicInfoService;
    private UserService userService;
//    private LikeMusicService likeMusicService;
    private List<MusicInfo> temporaryPlaylist = new ArrayList<>();



    @Autowired
    public UserPlaylistController(UserPlaylistService userPlaylistService, MusicInfoService musicInfoService,
                                  UserService userService) {
        this.userPlaylistService = userPlaylistService;
        this.musicInfoService = musicInfoService;
        this.userService = userService;
//        this.likeMusicService = likeMusicService;
    }

//    @PostMapping("/profile/addToPlaylist")
//    public String addToPlaylist(@RequestParam("mid") Long mid, Model model) {
//        // find the adding music
//        System.out.println(mid); //debug statement
//        MusicInfo clickedMusicInfo = musicInfoService.findMusicInfoByMid(mid);
//        //create and add to playlist
//        currentPlaylist.add(clickedMusicInfo);
//        model.addAttribute("currentPlaylist", currentPlaylist);
//
//        return "redirect:/profile";
//    }

//        @PostMapping("/profile/addToPlaylist")
//        public String addToPlaylist(@RequestParam("mid") Long mid, Model model) {
//        currentPlaylist = new ArrayList<>();
//        System.out.println(mid); //debug statement
//        MusicInfo clickedMusicInfo = musicInfoService.findMusicInfoByMid(mid);
//        //create and add to playlist
//        currentPlaylist.add(clickedMusicInfo);
//        System.out.println(currentPlaylist);
//        model.addAttribute("currentPlaylist", currentPlaylist);
//        return "redirect:/profile";
//    }

    // when click create playlist button
    // use the userService method to return all the mid with the current uid
    // from all the mid in thymeleaf loop through and use findMusicInfoByMid to
    // get the musicinforamtion for mid to be displayed


//    @PostMapping("/profile/addToPlaylist")
//    public String addToPlaylist(@RequestParam("mid") Long mid, Model model, Principal principal) {
//        //use the userService clas to add the user and the MusicInfo into the user_muisc table
//        String email = principal.getName();
//        User currentUser = userService.findByUserEmail(email);
//        LocalDateTime likeDate = LocalDateTime.now();
//        MusicInfo clickedMusic = musicInfoService.findMusicInfoByMid(mid);
//
////        MusicInfo clickedMusicInfo = musicInfoService.findMusicInfoByMid(mid);
////        UserPlaylist newPlayList = new UserPlaylist();
////
////        List<MusicInfo> currentPlayList = newPlayList.getMusicInformation();
////        currentPlayList.add(clickedMusicInfo);
////        model.addAttribute("currentPlayList", currentPlayList);
////        return "/profile";
//    }


//    @PostMapping("/profile/addToPlaylist")
//    public String addToPlaylist(@RequestParam("mid") Long mid, Model model) {
//        // find the adding music
//        System.out.println(mid); //debug statement
//        MusicInfo clickedMusicInfo = musicInfoService.findMusicInfoByMid(mid);
//        //create and add to playlist
//        UserPlaylist newPlaylist = new UserPlaylist();
//        List<MusicInfo> currentPlaylist = newPlaylist.getMusicInformation();
//        currentPlaylist.add(clickedMusicInfo);
//        System.out.println(currentPlaylist);
//        model.addAttribute("currentPlaylist", currentPlaylist);
//        return "/profile";
//    }

    // Endpoint to add a song to the temporary playlist
    @PostMapping("/profile/addToPlaylist")
    public String addToPlaylist(@RequestParam("mid") Long mid, Model model) {
        MusicInfo clickedMusicInfo = musicInfoService.findMusicInfoByMid(mid);
        temporaryPlaylist.add(clickedMusicInfo);
        System.out.println(temporaryPlaylist + "this is the temp playlist!!!!!!!!!!!!!!!!");
        System.out.println(temporaryPlaylist.size() + "this is the size!!!!!!!!!!!");
        model.addAttribute("temporaryPlaylist", temporaryPlaylist);
        return "redirect:/profile";
    }
}


