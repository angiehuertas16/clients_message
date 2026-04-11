package com.symplifica.clients_message.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class MensajeClienteRequestDto {
	
	public void setRequest(String request) {
		this.request = request;
	}

	@NotBlank(message = "El mensaje no puede estar vacío")
	@Size(min = 5, max = 300, message = "El mensaje no puede tener más de 300 caracteres y menos de 5")
    @Pattern(
        regexp = "^[a-zA-Z ]+$",
        message = "Solo se permiten letras y espacios"
    )
	private String request;

    public MensajeClienteRequestDto(String request) {
        this.request = request;
    }

    public String getRequest() {
        return request;
    }
	
}
