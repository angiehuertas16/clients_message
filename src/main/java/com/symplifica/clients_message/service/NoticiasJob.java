package com.symplifica.clients_message.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("summary", resumen);
		String correo ="esteban_-456@hotmail.com";
		String path = "src/main/resources/templates/news-email.html";
		String subjec ="Tu Resumen Díario De Noticias";
		try {
			emailService.sendEmail(map, path,correo,subjec);
			System.out.println("Mail enviado");
		} catch (Exception e) {
			System.out.println("Email no enviado " + e.getMessage());
		}
	}

}
