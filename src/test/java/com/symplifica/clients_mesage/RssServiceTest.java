package com.symplifica.clients_mesage;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;

import com.symplifica.clients_message.service.RssService;

@ExtendWith(MockitoExtension.class)
public class RssServiceTest {

	@InjectMocks
	private RssService rssService;

	   @Test
	    void shouldReturnNewsTitles() {
	        List<String> titles = rssService.getNewsTitles();
	        assertNotNull(titles);
	        assertFalse(titles.isEmpty());
	        assertTrue(titles.size() > 0);
	    }
	
}
