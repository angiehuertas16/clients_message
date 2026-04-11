package com.symplifica.clients_message.serviceImp;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.symplifica.clients_message.exceptions.CustomException;
import com.symplifica.clients_message.exceptions.ExceptionDescriptions;
import com.symplifica.clients_message.model.Usuario;
import com.symplifica.clients_message.repository.UsuarioRepository;
import com.symplifica.clients_message.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	private final UsuarioRepository usuarioRepository;

	public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	@Override
	public ResponseEntity<Usuario> crearUsuario(Usuario usuario) {
		try {
			usuario = usuarioRepository.save(usuario);
		} catch (Exception e) {
			throw new CustomException(ExceptionDescriptions.DATA_NOT_SAVE, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Usuario> obtenerUsuarioPorId(Integer id) {

		Usuario usuario = null;

		try {
			usuario = usuarioRepository.findById(id).get();
		} catch (Exception e) {
			throw new CustomException(ExceptionDescriptions.DATA_NOT_FOUND, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Usuario> actualizarUsuario(Integer id, Usuario usuario) {
		Optional<Usuario> usuarioBD = usuarioRepository.findById(id);
		if (usuarioBD.isPresent()) {
			try {
				usuarioBD.get().setNombre(usuario.getNombre());
				usuarioBD.get().setEmail(usuario.getEmail());
				usuarioBD.get().setPassword_hash(usuario.getPassword_hash());
				usuarioBD.get().setTipo_documento(usuario.getTipo_documento());
				usuarioRepository.save(usuarioBD.get());
			} catch (Exception e) {
				throw new CustomException(ExceptionDescriptions.DATA_NOT_SAVE, HttpStatus.NOT_FOUND);
			}
		}
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Map<String, Object>> eliminarUsuario(Integer id) {
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		try {
			Optional<Usuario> usuario = usuarioRepository.findById(id);
			if (usuario.isPresent()) {
				usuario.get().setActivo(false);
				usuarioRepository.save(usuario.get());
			}
			map.put("description", "Usuario eliminado exitosamente");
		} catch (Exception e) {
			throw new CustomException(ExceptionDescriptions.DATA_NOT_DELETED, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
}