package com.symplifica.clients_message.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.symplifica.clients_message.model.TipoCredito;

@Repository
public interface TipoCreditoRepository extends JpaRepository<TipoCredito, Integer> {

}