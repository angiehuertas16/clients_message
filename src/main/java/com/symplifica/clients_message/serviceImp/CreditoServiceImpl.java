package com.symplifica.clients_message.serviceImp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.symplifica.clients_message.exceptions.CustomException;
import com.symplifica.clients_message.exceptions.ExceptionDescriptions;
import com.symplifica.clients_message.helpers.Helpers;
import com.symplifica.clients_message.model.Credito;
import com.symplifica.clients_message.model.Cuota;
import com.symplifica.clients_message.model.TipoCredito;
import com.symplifica.clients_message.repository.CreditoRepository;
import com.symplifica.clients_message.repository.CuotaRepository;
import com.symplifica.clients_message.repository.TipoCreditoRepository;
import com.symplifica.clients_message.service.CreditoService;

@Service
public class CreditoServiceImpl implements CreditoService {

    private final CreditoRepository creditoRepository;
    
    private final CuotaRepository cuotaRepository;
    
    private final TipoCreditoRepository tipoCreditoRepository;

    public CreditoServiceImpl(CreditoRepository creditoRepository, CuotaRepository cuotaRepository,TipoCreditoRepository tipoCreditoRepository) {
        this.creditoRepository = creditoRepository;
        this.cuotaRepository = cuotaRepository;
        this.tipoCreditoRepository =tipoCreditoRepository;
    }

    @Override
    public  ResponseEntity<Credito>  crearCredito(Credito credito) {
    	try {
    		credito=creditoRepository.save(credito);	
    		Cuota cuota ;
    		
    		TipoCredito tipoCredito = tipoCreditoRepository
    		        .findById(credito.getTipo_credito().getId())
    		        .orElseThrow(() -> new RuntimeException("Tipo credito no existe"));
    		
    		Double valor_cuota = Helpers.extractQuota(credito.getValor(), credito.getMeses(), tipoCredito.getRate());
    		List<Cuota> listaCuotas = new ArrayList<Cuota>();
    		LocalDateTime fecha = credito.getFecha_creado().plusMonths(1);
    		for (int i = 1; i <= credito.getMeses()  ; i++) {
    			cuota = new Cuota();
    			cuota.setActivo(true);
    			cuota.setNumerocuota(i);
    			cuota.setCredito(credito);
    			cuota.setFecha_pago(fecha.toLocalDate());
    			cuota.setActivo(true);
    			cuota.setValor_cuota(valor_cuota);
    			fecha.plusMonths(1);
    			listaCuotas.add(cuota);
			}
    		cuotaRepository.saveAll(listaCuotas);
		} catch (Exception e) {
			e.printStackTrace();
			  throw new CustomException(ExceptionDescriptions.DATA_NOT_SAVE
	        		  , HttpStatus.NOT_FOUND);
		}
        return new ResponseEntity<Credito>(credito, HttpStatus.OK);
    }
 

    @Override
    public ResponseEntity<Credito> obtenerCreditoPorId(Integer id) {
    	Credito credito = null;
    	try {
    		credito= creditoRepository.findById(id).get();
		} catch (Exception e) {
			  throw new CustomException(ExceptionDescriptions.DATA_NOT_SAVE
	        		  , HttpStatus.NOT_FOUND);
		}
        return new ResponseEntity<Credito>(credito, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Credito> actualizarCredito(Integer id, Credito credito) {
    	 Optional<Credito> creditobd = creditoRepository.findById(id);
		 if(creditobd.isPresent()) {
			 try {
				 creditobd.get().setValor(credito.getValor());
				 creditobd.get().setMeses(credito.getMeses());
				 creditoRepository.save(creditobd.get());
			} catch (Exception e) {
				  throw new CustomException(ExceptionDescriptions.DATA_NOT_SAVE
		        		  , HttpStatus.NOT_FOUND);
			}
		 }
	     return new ResponseEntity<Credito>(credito, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map<String,Object>> eliminarCredito(Integer id) {
    	Map<String, Object> map = new LinkedHashMap<String, Object>();
    	try {
    		 Optional<Credito> credito = creditoRepository.findById(id);
    		 if(credito.isPresent()) {
    			 credito.get().setActivo(false);
    			 creditoRepository.save(credito.get());
    		 }
    		map.put("description","Credito eliminado exitosamente");
		} catch (Exception e) {
		      throw new CustomException(ExceptionDescriptions.DATA_NOT_DELETED
	        		  , HttpStatus.NOT_FOUND);
		}
        return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
    }
}
