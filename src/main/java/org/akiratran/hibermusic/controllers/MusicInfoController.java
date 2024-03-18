package org.akiratran.hibermusic.controllers;

import jakarta.validation.Valid;
import org.akiratran.hibermusic.model.MusicInfo;
import org.akiratran.hibermusic.services.MusicInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MusicInfoController {
    private MusicInfoService musicInfoService;

    @Autowired
    public MusicInfoController(MusicInfoService musicInfoService) {
        this.musicInfoService = musicInfoService;
    }

    @PostMapping("/profile/search")
    public String searchMusicInfo(@Valid @ModelAttribute("newMusicInfo") MusicInfo newMusicInfo, BindingResult result, Model model) {
        List<MusicInfo> musicInfoResult = new ArrayList<>();
        List<MusicInfo> songList = musicInfoService.findMusicInfoBySongName(newMusicInfo.getSongName());
        System.out.println("song list" + songList);
        if(!songList.isEmpty()) {
            System.out.println("song found"); //debug statement
            musicInfoResult.addAll(songList);
        }
        List<MusicInfo> artistlist = musicInfoService.findMusicInfoByArtistName(newMusicInfo.getArtistName());
        System.out.println("artist list" + artistlist);
        if(!artistlist.isEmpty()) {
            System.out.println("artists found"); //debug statement
            musicInfoResult.addAll(artistlist);
        }
        if(musicInfoResult.isEmpty()) {
            result.rejectValue("songName", "null", "No MusicInfo was found using songName");
            result.rejectValue("artistName", "null", "No MusicInfo was found using artistName");
        }
        System.out.println(musicInfoResult);
        // Always add the newMusicInfo object to the model
        model.addAttribute("newMusicInfo", newMusicInfo);
        // Add the list of MusicInfo objects to the model
        model.addAttribute("musicInfoResult", musicInfoResult);

        return "profile"; // Return the name of your Thymeleaf template
    }
}
