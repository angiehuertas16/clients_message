package com.symplifica.clients_message.controller;

import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.symplifica.clients_message.model.Credito;
import com.symplifica.clients_message.service.CreditoService;

@RestController
@RequestMapping("/creditos")
public class CreditoController {

    private final CreditoService creditoService;

    public CreditoController(CreditoService creditoService) {
        this.creditoService = creditoService;
    }

    @PostMapping("/guardar")
    public  ResponseEntity<Credito> crearCredito(@RequestBody Credito credito) {
        return creditoService.crearCredito(credito);
    }

    @GetMapping("/obtener/{id}")
    public ResponseEntity<Credito> obtenerCreditoPorId(@PathVariable Integer id) {
        return creditoService.obtenerCreditoPorId(id);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Credito> actualizarCredito(@PathVariable Integer id, @RequestBody Credito credito) {
        return creditoService.actualizarCredito(id, credito);
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<Map<String,Object>>  eliminarCredito(@PathVariable Integer id) {
       return creditoService.eliminarCredito(id);
    }
}