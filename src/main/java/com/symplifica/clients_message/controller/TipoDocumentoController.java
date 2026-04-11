package com.symplifica.clients_message.controller;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.symplifica.clients_message.model.TipoDocumento;
import com.symplifica.clients_message.service.TipoDocumentoService;

@RestController
@RequestMapping("/tipo-documento")
public class TipoDocumentoController {

    private final TipoDocumentoService tipoDocumentoService;

    public TipoDocumentoController(TipoDocumentoService tipoDocumentoService) {
        this.tipoDocumentoService = tipoDocumentoService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<TipoDocumento>> obtenerTiposDocumento() {
        return tipoDocumentoService.obtenerListTipoDocumento();
    }
}