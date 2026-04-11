package com.symplifica.clients_message.serviceImp;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.symplifica.clients_message.exceptions.CustomException;
import com.symplifica.clients_message.exceptions.ExceptionDescriptions;
import com.symplifica.clients_message.model.TipoCredito;
import com.symplifica.clients_message.repository.TipoCreditoRepository;
import com.symplifica.clients_message.service.TipoCreditoService;

@Service
public class TipoCreditoServiceImpl implements TipoCreditoService {

	private final TipoCreditoRepository tipoCreditoRepository;

	public TipoCreditoServiceImpl(TipoCreditoRepository tipoCreditoRepository) {
		this.tipoCreditoRepository = tipoCreditoRepository;
	}

	@Override
	public ResponseEntity<List<TipoCredito>> obteneristTipoCredito() {
		List<TipoCredito> listTipoCredito = new ArrayList<TipoCredito>();
		try {
			listTipoCredito = tipoCreditoRepository.findAll();
		} catch (Exception e) {
			throw new CustomException(ExceptionDescriptions.DATA_NOT_SAVE, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<TipoCredito>>(listTipoCredito, HttpStatus.OK);
	}

}
