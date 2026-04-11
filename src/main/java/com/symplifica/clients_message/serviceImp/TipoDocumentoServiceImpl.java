package com.symplifica.clients_message.serviceImp;


import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.symplifica.clients_message.exceptions.CustomException;
import com.symplifica.clients_message.exceptions.ExceptionDescriptions;
import com.symplifica.clients_message.model.TipoDocumento;
import com.symplifica.clients_message.repository.TipoDocumentoRepository;
import com.symplifica.clients_message.service.TipoDocumentoService;

@Service
public class TipoDocumentoServiceImpl implements TipoDocumentoService {

    private final TipoDocumentoRepository tipoDocumentoRepository;

    public TipoDocumentoServiceImpl(TipoDocumentoRepository tipoDocumentoRepository) {
        this.tipoDocumentoRepository = tipoDocumentoRepository;
    }

    @Override
    public ResponseEntity<List<TipoDocumento>> obtenerListTipoDocumento() {
        List<TipoDocumento> listTipoDocumento = new ArrayList<TipoDocumento>();
        try {
            listTipoDocumento = tipoDocumentoRepository.findAll();
        } catch (Exception e) {
            throw new CustomException(
                    ExceptionDescriptions.DATA_NOT_SAVE,
                    HttpStatus.NOT_FOUND
            );
        }
        return new ResponseEntity<List<TipoDocumento>>(listTipoDocumento, HttpStatus.OK);
    }
}