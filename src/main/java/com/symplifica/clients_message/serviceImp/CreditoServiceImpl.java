package com.symplifica.clients_message.serviceImp;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.symplifica.clients_message.exceptions.CustomException;
import com.symplifica.clients_message.exceptions.ExceptionDescriptions;
import com.symplifica.clients_message.model.Credito;
import com.symplifica.clients_message.repository.CreditoRepository;
import com.symplifica.clients_message.service.CreditoService;

@Service
public class CreditoServiceImpl implements CreditoService {

    private final CreditoRepository creditoRepository;

    public CreditoServiceImpl(CreditoRepository creditoRepository) {
        this.creditoRepository = creditoRepository;
    }

    @Override
    public  ResponseEntity<Credito>  crearCredito(Credito credito) {
    	try {
    		credito=creditoRepository.save(credito);	
		} catch (Exception e) {
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
