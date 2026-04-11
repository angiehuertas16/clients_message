package com.symplifica.clients_message.dto;

public class MensajeClienteResponseDto {

    private String respuesta;

    public MensajeClienteResponseDto(String respuesta) {
        this.respuesta = respuesta;
    }

    public String getRespuesta() {
        return respuesta;
    }

	public MensajeClienteResponseDto() {
		super();
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}
    
    
}