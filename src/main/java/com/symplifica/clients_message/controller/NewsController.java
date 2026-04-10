package com.symplifica.clients_message.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.symplifica.clients_message.service.RssService;

@RestController
@RequestMapping("/news")
public class NewsController {

    private final RssService rssService;

    public NewsController(RssService rssService) {
        this.rssService = rssService;
    }

    @GetMapping("/titles")
    public List<String> getNews() {
        return rssService.getNewsTitles();
    }
}