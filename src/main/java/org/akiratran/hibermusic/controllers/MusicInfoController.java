package org.akiratran.hibermusic.controllers;

import jakarta.validation.Valid;
import org.akiratran.hibermusic.model.MusicInfo;
import org.akiratran.hibermusic.services.MusicInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Controls the different endpoints around musicInfo
 */

@Controller
public class MusicInfoController {
    private MusicInfoService musicInfoService;

    @Autowired
    public MusicInfoController(MusicInfoService musicInfoService) {
        this.musicInfoService = musicInfoService;
    }

    /**
     * Retrieves the new MusicInfo from the profile view to be further processes in /profile/search
     * @param model - holds the new MusicInfo from the thymeleaf profile view
     * @return {String} - returns the profile string to display the thymeleaf profile view
     */
    @GetMapping("/profile/load")
    public String prepareSearch(Model model) {
        MusicInfo newMusicInfo = new MusicInfo();
        model.addAttribute("newMusicInfo", newMusicInfo);
        return "profile";
    }

    /**
     * Given a search phrase finds if MusicInfo table contains songName or ArtistName like searchPhrase and return
     * the view and the data with according to the searchPhrase
     * @param searchPhrase {String} - A string representing the search phrase
     * @param result {Object} - Result object contains information about the results of the query reject or non reject
     * @param model {Object} - Model object contains the search results of the MusicInfos.
     * @return {String} - returns the string profile to be directed to the profile view page
     */
    @PostMapping("/profile/search")
    public String searchMusicInfo(@ModelAttribute("searchPhrase") String searchPhrase, BindingResult result, Model model) {
        List<MusicInfo> musicInfoResult = musicInfoService.findMusicInfoBySongNameOrArtistName(searchPhrase);
        if(musicInfoResult.isEmpty()) {
            result.rejectValue("songName", "null", "No MusicInfo was found using songName");
            result.rejectValue("artistName", "null", "No MusicInfo was found using artistName");
        }
        if(result.hasErrors()) {
            System.out.println("no results"); //debug statement
        }
        System.out.println(musicInfoResult);
        model.addAttribute("musicInfoResult", musicInfoResult);
        return "profile";
    }
}
