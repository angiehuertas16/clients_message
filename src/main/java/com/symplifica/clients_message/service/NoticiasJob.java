package com.symplifica.clients_message.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class NoticiasJob {

	private final RssService rssService;

	public NoticiasJob(RssService rssService) {
		this.rssService = rssService;
	}

	public void runNoticiasJob() {
		  List<String> titles = rssService.getNewsTitles();
	        System.out.println(titles);
	}

}
