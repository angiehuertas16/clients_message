package com.symplifica.clients_message.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import com.symplifica.clients_message.model.Usuario;

public interface UsuarioService {
	
	  ResponseEntity<Usuario> crearUsuario(Usuario usuario);

	  ResponseEntity< Usuario> obtenerUsuarioPorId(Integer id);

	  ResponseEntity< Usuario >actualizarUsuario(Integer id, Usuario usuario);

	  ResponseEntity<Map<String,Object>> eliminarUsuario(Integer id);
	
}
