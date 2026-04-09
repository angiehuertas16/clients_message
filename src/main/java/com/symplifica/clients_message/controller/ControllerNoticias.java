package com.symplifica.clients_message.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.symplifica.clients_message.service.NewsAnalyzerService;

@RestController
@RequestMapping("/news")
public class ControllerNoticias {

	private final NewsAnalyzerService analyzer;

	public ControllerNoticias(NewsAnalyzerService analyzer) {
		this.analyzer = analyzer;
	}

	@GetMapping("/analysis")
	public String analyze() {
		return analyzer.analyzeLatestNews();
	}
	
	

}
