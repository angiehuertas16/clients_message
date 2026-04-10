package com.symplifica.clients_mesage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.symplifica.clients_message.service.RssService;

@ExtendWith(MockitoExtension.class)
public class RssServiceTest {

	@InjectMocks
	private RssService rssService;

	@Mock
	private HttpClient client;

	@Mock
	HttpResponse<InputStream> response;

	@SuppressWarnings("unchecked")
	@Test
	void shouldReturnNewsTitles() throws IOException, InterruptedException {
		String fakeRss = """
				<rss version="2.0">
				  <channel>
				    <title>Noticias</title>
				    <item>
				      <title>Noticia 1</title>
				    </item>
				    <item>
				      <title>Noticia 2</title>
				    </item>
				  </channel>
				</rss>
				""";
		InputStream fakeStream = new ByteArrayInputStream(fakeRss.getBytes());
		
		when(client.send(
		        any(HttpRequest.class),
		        any(HttpResponse.BodyHandler.class)
		)).thenReturn(response);
		
		when(response.body()).thenReturn(fakeStream);
		
		List<String> titles = rssService.getNewsTitles();

		assertEquals(2, titles.size());
		assertTrue(titles.contains("Noticia 1"));
		assertTrue(titles.contains("Noticia 2"));

		assertNotNull(titles);
		assertFalse(titles.isEmpty());
		assertTrue(titles.size() > 0);
	}

}
