package com.symplifica.clients_mesage;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import com.symplifica.clients_message.model.Credito;
import com.symplifica.clients_message.model.TipoCredito;
import com.symplifica.clients_message.model.Usuario;
import com.symplifica.clients_message.repository.CreditoRepository;
import com.symplifica.clients_message.repository.CuotaRepository;
import com.symplifica.clients_message.repository.TipoCreditoRepository;
import com.symplifica.clients_message.serviceImp.CreditoServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.time.LocalDateTime;
import java.util.Optional;


@ExtendWith(MockitoExtension.class)
class CreditoServiceTest {

    @Mock
    private CreditoRepository creditoRepository;

    @InjectMocks
    private CreditoServiceImpl creditoService;
    
    @Mock
    private TipoCreditoRepository tipoCreditoRepository;

    @Mock
    private CuotaRepository cuotaRepository;
    

    @Test
    void deberiaCrearCredito() {

        TipoCredito tipoCredito = new TipoCredito();
        tipoCredito.setId(1);
        tipoCredito.setDescripcion("CREDITO ROTATIVO");
        tipoCredito.setRate(1.2);

        Usuario usuario = new Usuario();
        usuario.setNombre("Angie");
        usuario.setFecha_creacion(LocalDateTime.now());
        usuario.setActivo(true);

        Credito credito = new Credito();
        credito.setActivo(true);
        credito.setValor(5000000.0);
        credito.setMeses(12);
        credito.setFecha_creado(LocalDateTime.now());
        credito.setUsuario(usuario);
        credito.setTipo_credito(tipoCredito);

        Mockito.when(creditoRepository.save(Mockito.any()))
                .thenReturn(credito);

        Mockito.when(tipoCreditoRepository.findById(Mockito.any()))
                .thenReturn(Optional.of(tipoCredito));

        ResponseEntity<Credito> response = creditoService.crearCredito(credito);

        assertNotNull(response);
        assertEquals(200, response.getStatusCode().value());
    }
}