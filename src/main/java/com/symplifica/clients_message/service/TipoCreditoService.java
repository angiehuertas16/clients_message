package com.symplifica.clients_message.service;

import java.util.List;
import org.springframework.http.ResponseEntity;
import com.symplifica.clients_message.model.TipoCredito;

public interface TipoCreditoService {

    ResponseEntity<List<TipoCredito>> obteneristTipoCredito();

}