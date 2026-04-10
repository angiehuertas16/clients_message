package com.symplifica.clients_mesage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.ArgumentMatchers.anyString;
import com.symplifica.clients_message.service.AiService;
import dev.langchain4j.model.ollama.OllamaChatModel;

@ExtendWith(MockitoExtension.class)
public class AiServiceTest {

	@InjectMocks
	private AiService aiService;

	@Mock
	private OllamaChatModel model;

	@Test
	void shouldReturnaiservice() {

		List<String> titles = List.of("OpenAI lanza nuevo modelo de IA", "Tesla anuncia robot doméstico",
				"Nueva tecnología revoluciona baterías");
		String fakeResponse = "Resumen generado por IA";

	    when(model.chat(anyString())).thenReturn(fakeResponse);

	    String result = aiService.summarizeNews(titles); 
	    
	    System.out.println(result + " que da el modelo");

	    assertEquals(fakeResponse, result);

	    verify(model).chat(anyString());


	}

	
	@Test
    void shouldCallRealOllamaModel() {

		
		AiService aiService2 = new AiService(
			    OllamaChatModel.builder()
			        .baseUrl("http://localhost:11434")
			        .modelName("llama3")
			        .build()
			);
		
        List<String> titles = List.of(
                "OpenAI lanza nuevo modelo de IA",
                "Tesla anuncia robot doméstico",
                "Nueva tecnología revoluciona baterías"
        );

        String result = aiService2.summarizeNews(titles);

        System.out.println("Respuesta real del modelo:");
        System.out.println(result);

        assertNotNull(result);
        assertFalse(result.isBlank());
    }
	
	
}
