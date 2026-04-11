package com.symplifica.clients_message.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.symplifica.clients_message.model.TipoCredito;
import com.symplifica.clients_message.service.TipoCreditoService;

@RestController
@RequestMapping("/tipo-credito")
public class TipoCreditoController {

    private final TipoCreditoService tipoCreditoService;

    public TipoCreditoController(TipoCreditoService tipoCreditoService) {
        this.tipoCreditoService = tipoCreditoService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<TipoCredito>> obtener(){
        return tipoCreditoService.obteneristTipoCredito();
    }

   
}