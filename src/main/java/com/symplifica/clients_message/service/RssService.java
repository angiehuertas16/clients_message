package com.symplifica.clients_message.service;

import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import java.io.InputStreamReader;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;


@Service
public class RssService {

	public List<String> getNewsTitles() {

		List<String> titles = new ArrayList<>();

		try {

			HttpClient client = HttpClient.newHttpClient();

			HttpRequest request = HttpRequest.newBuilder()
					.uri(URI.create("https://www.portafolio.co/rss/tendencias/entretenimiento.xml")).GET().build();
			
			HttpResponse<InputStream> response = client.send(request, HttpResponse.BodyHandlers.ofInputStream());

			SyndFeedInput input = new SyndFeedInput();
			SyndFeed feed = input.build(new InputStreamReader(response.body()));
			
			
			
			for (SyndEntry entry : feed.getEntries()) {
				titles.add(entry.getTitle());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return titles;
	}

}
