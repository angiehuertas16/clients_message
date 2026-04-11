package com.symplifica.clients_message.service;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.langchain4j.model.ollama.OllamaChatModel;

@Service
public class AiService {

    private final OllamaChatModel model;
    
    public AiService(OllamaChatModel model) {
        this.model = model;
    }

    public String summarizeNews(List<String> titles) {

        String prompt = """
                Resume las siguientes noticias en máximo 3 párrafos en español.
                Ordena de la más relevante a la menos relevante.

                Noticias:
                """ + String.join("\n", titles);

        return model.chat(prompt);
    }
    
    public String generarRespuestaCliente(String mensaje) {

        String prompt = """
        Eres un asistente de atención al cliente para una empresa de créditos.

        Responde de forma profesional, clara y amable.

        Mensaje del cliente:
        %s
        """.formatted(mensaje);

        return  model.chat(prompt);
    }
    
}