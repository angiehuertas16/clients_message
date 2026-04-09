package com.symplifica.clients_message.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class NoticiasJob {

	private final RssService rssService;
	private final AiService aiService;

	public NoticiasJob(RssService rssService, AiService aiService) {
		this.rssService = rssService;
		this.aiService = aiService;
	}

	public String runNoticiasJob() {
		List<String> titles = rssService.getNewsTitles();
		String resumen = aiService.summarizeNews(titles);
		return resumen;
	}

}
