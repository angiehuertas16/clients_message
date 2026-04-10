package com.symplifica.clients_message.exceptions;



public enum ExceptionDescriptions {

	DEFAULT_EXCEPTION(1, "Ocurrio un error interno, por favor inténtelo nuevamente o comuníquese con soporte técnico"),
	METHOD_NOT_ALLOWED(2, "Método no permitido para este endpoint"),
	BAD_REQUEST(3, "La información ingresada no es correcta, verifique los parámetros enviados"),
	CANNOT_SAVE_USER(4, "No se puede guardar el usuario, por favor verifique los datos"),
	WRONG_PASSWORD(5, "La contraseña digitada no es correcta"),
	USER_NOT_FOUND(6, "El usuario no se encuentra en la base de datos"),
	DATA_NOT_FOUND(7, "Informacion no encontrada.");
	
	private int code;
	private String description;
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	private ExceptionDescriptions(int code, String description) {
		this.code = code;
		this.description = description;
	}
}	
