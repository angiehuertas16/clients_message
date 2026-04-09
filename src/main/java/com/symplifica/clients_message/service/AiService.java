package com.symplifica.clients_message.service;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.langchain4j.model.ollama.OllamaChatModel;

@Service
public class AiService {

    private final OllamaChatModel model;

    public AiService() {
        this.model = OllamaChatModel.builder()
                .baseUrl("http://localhost:11434")
                .modelName("llama3")
                .build();
    }

    public String summarizeNews(List<String> titles) {

        String prompt = """
                Resume las siguientes noticias en máximo 3 párrafos en español.
                Ordena de la más relevante a la menos relevante.

                Noticias:
                """ + String.join("\n", titles);

        return model.chat(prompt);
    }
}