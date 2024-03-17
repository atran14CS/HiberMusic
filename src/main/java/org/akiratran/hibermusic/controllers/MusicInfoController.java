package org.akiratran.hibermusic.controllers;

import org.akiratran.hibermusic.model.MusicInfo;
import org.akiratran.hibermusic.services.MusicInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MusicInfoController {
    private MusicInfoService musicInfoService;

    @Autowired
    public MusicInfoController(MusicInfoService musicInfoService) {
        this.musicInfoService = musicInfoService;
    }

//    @PostMapping("/")
}
