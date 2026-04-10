package com.symplifica.clients_message.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;

    private String email;

    private String password_hash;
    
    private boolean activo;
    
    private LocalDateTime fecha_creacion;
    
    private LocalDateTime fecha_actualizacion;
    
	
}
