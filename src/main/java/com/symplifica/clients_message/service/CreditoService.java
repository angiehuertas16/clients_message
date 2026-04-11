package com.symplifica.clients_message.service;

import java.util.Map;
import org.springframework.http.ResponseEntity;
import com.symplifica.clients_message.model.Credito;

public interface CreditoService {

  ResponseEntity<Credito> crearCredito(Credito credito);

  ResponseEntity< Credito> obtenerCreditoPorId(Integer id);

  ResponseEntity< Credito >actualizarCredito(Integer id, Credito credito);

  ResponseEntity<Map<String,Object>> eliminarCredito(Integer id);
}