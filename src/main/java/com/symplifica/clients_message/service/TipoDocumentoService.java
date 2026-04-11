package com.symplifica.clients_message.service;


import java.util.List;

import org.springframework.http.ResponseEntity;

import com.symplifica.clients_message.model.TipoDocumento;

public interface TipoDocumentoService {

    ResponseEntity<List<TipoDocumento>> obtenerListTipoDocumento();

}