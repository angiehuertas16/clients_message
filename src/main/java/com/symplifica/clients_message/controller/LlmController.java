package com.symplifica.clients_message.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.symplifica.clients_message.dto.MensajeClienteRequestDto;
import com.symplifica.clients_message.dto.MensajeClienteResponseDto;
import com.symplifica.clients_message.exceptions.CustomException;
import com.symplifica.clients_message.exceptions.ExceptionDescriptions;
import com.symplifica.clients_message.service.AiService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/ollama")
public class LlmController {

    private final AiService aiservice;

    public LlmController(AiService aiservicee) {
        this.aiservice = aiservicee;
    }

    @PostMapping("/respuesta-cliente")
    public ResponseEntity<MensajeClienteResponseDto> responderCliente(@RequestBody @Valid MensajeClienteRequestDto request) {
    	MensajeClienteResponseDto mensajerespuesta = new MensajeClienteResponseDto();
    	try {
    		String respuesta = aiservice.generarRespuestaCliente(request.getRequest());
            mensajerespuesta.setRespuesta(respuesta);
		} catch (Exception e) {
			   throw new CustomException(ExceptionDescriptions.DATA_NOT_FOUND
 	        		  , HttpStatus.NOT_FOUND);
		}
        return new ResponseEntity<MensajeClienteResponseDto>(mensajerespuesta, HttpStatus.OK);
    }
}