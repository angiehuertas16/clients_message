package com.symplifica.clients_message.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class NoticiasJob {

	private final RssService rssService;
	private final AiService aiService;
	private final EmailService emailService;

	public NoticiasJob(RssService rssService, AiService aiService,EmailService emailService) {
		this.rssService = rssService;
		this.aiService = aiService;
		this.emailService=emailService;
	}

	public void runNoticiasJob() {
		List<String> titles = rssService.getNewsTitles();
		String resumen = aiService.summarizeNews(titles);
		try {
			emailService.sendEmail(resumen);
			System.out.println("Mail enviado");
		} catch (Exception e) {
			System.out.println("Email no enviado " + e.getMessage());
		}
	}

}
