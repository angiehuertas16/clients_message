package com.symplifica.clients_message.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "creditos")
public class Credito {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "tipo_credito_id")
	private TipoCredito tipo_credito;

	@Column(name = "fecha_creado")
	private LocalDateTime fecha_creado;

	@OneToMany(mappedBy = "credito", cascade = CascadeType.ALL)
	private List<Cuota> lista_cuotas;

	private Integer meses;

	private Double valor;

	private Boolean  activo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public TipoCredito getTipo_credito() {
		return tipo_credito;
	}

	public void setTipo_credito(TipoCredito tipo_credito) {
		this.tipo_credito = tipo_credito;
	}

	public LocalDateTime getFecha_creado() {
		return fecha_creado;
	}

	public void setFecha_creado(LocalDateTime fecha_creado) {
		this.fecha_creado = fecha_creado;
	}

	public List<Cuota> getLista_cuotas() {
		return lista_cuotas;
	}

	public void setLista_cuotas(List<Cuota> lista_cuotas) {
		this.lista_cuotas = lista_cuotas;
	}

	public Integer getMeses() {
		return meses;
	}

	public void setMeses(Integer meses) {
		this.meses = meses;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	

	public Credito(Integer id, Usuario usuario, TipoCredito tipo_credito, LocalDateTime fecha_creado,
			List<Cuota> lista_cuotas, Integer meses, Double valor, Boolean activo) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.tipo_credito = tipo_credito;
		this.fecha_creado = fecha_creado;
		this.lista_cuotas = lista_cuotas;
		this.meses = meses;
		this.valor = valor;
		this.activo = activo;
	}

	public Credito() {
		super();
	}
	
	

}
