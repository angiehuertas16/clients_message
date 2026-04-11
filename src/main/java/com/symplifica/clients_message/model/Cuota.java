package com.symplifica.clients_message.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cuotas")
public class Cuota {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "credito_id")
	private Credito credito;

	private int numerocuota;

	private double valor_cuota;
	
	private boolean activo;
	
	private LocalDate fecha_pago;

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Credito getCredito() {
		return credito;
	}

	public void setCredito(Credito credito) {
		this.credito = credito;
	}

	public int getNumerocuota() {
		return numerocuota;
	}

	public void setNumerocuota(int numerocuota) {
		this.numerocuota = numerocuota;
	}

	public double getValor_cuota() {
		return valor_cuota;
	}

	public void setValor_cuota(double valor_cuota) {
		this.valor_cuota = valor_cuota;
	}

	public LocalDate getFecha_pago() {
		return fecha_pago;
	}

	public void setFecha_pago(LocalDate fecha_pago) {
		this.fecha_pago = fecha_pago;
	}

	public Cuota(int id, Credito credito, int numerocuota, double valor_cuota, boolean activo, LocalDate fecha_pago) {
		super();
		this.id = id;
		this.credito = credito;
		this.numerocuota = numerocuota;
		this.valor_cuota = valor_cuota;
		this.activo = activo;
		this.fecha_pago = fecha_pago;
	}

	public Cuota() {
		super();
	}
	

}
