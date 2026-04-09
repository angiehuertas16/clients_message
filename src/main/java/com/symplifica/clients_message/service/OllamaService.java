package com.symplifica.clients_message.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OllamaService {

	
	 private final RestTemplate restTemplate = new RestTemplate();

	    @SuppressWarnings("rawtypes")
		public String analyzeNews(List<String> titles) {

	        String prompt = "Resume estas noticias:\n" + String.join("\n", titles);

	        Map<String, Object> request = new HashMap<>();
	        request.put("model", "llama3");
	        request.put("prompt", prompt);
	        request.put("stream", false);

	        String url = "http://localhost:11434/api/generate";

	        ResponseEntity<Map> response =
	                restTemplate.postForEntity(url, request, Map.class);

	        return response.getBody().get("response").toString();
	    }
	
	
	
	
	
	
	
}
