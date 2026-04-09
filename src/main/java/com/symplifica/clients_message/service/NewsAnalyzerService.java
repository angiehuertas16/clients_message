package com.symplifica.clients_message.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class NewsAnalyzerService {
	
	
	   private final RssService rssService;
	   private final OllamaService ollamaService;
	
	   public NewsAnalyzerService(RssService rssService, OllamaService ollamaService) {
	        this.rssService = rssService;
	        this.ollamaService = ollamaService;
	    }

	   public String analyzeLatestNews() {
	        List<String> titles = rssService.getNewsTitles();
	        return ollamaService.analyzeNews(titles);
	    }
	   
}
