package com.symplifica.clients_message.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    private String email;

    private String password_hash;
    
    private boolean activo;
    
    private LocalDateTime fecha_creacion;
    
    private LocalDateTime fecha_actualizacion;
    
    @ManyToOne
	@JoinColumn(name = "tipo_documento_id")
	private TipoDocumento tipo_documento;
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	private List<Credito> lista_creditos;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword_hash() {
		return password_hash;
	}

	public void setPassword_hash(String password_hash) {
		this.password_hash = password_hash;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public LocalDateTime getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(LocalDateTime fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public LocalDateTime getFecha_actualizacion() {
		return fecha_actualizacion;
	}

	public void setFecha_actualizacion(LocalDateTime fecha_actualizacion) {
		this.fecha_actualizacion = fecha_actualizacion;
	}

	public TipoDocumento getTipo_documento() {
		return tipo_documento;
	}

	public void setTipo_documento(TipoDocumento tipo_documento) {
		this.tipo_documento = tipo_documento;
	}

	public List<Credito> getLista_creditos() {
		return lista_creditos;
	}

	public void setLista_creditos(List<Credito> lista_creditos) {
		this.lista_creditos = lista_creditos;
	}

	public Usuario(Integer id, String nombre, String email, String password_hash, boolean activo,
			LocalDateTime fecha_creacion, LocalDateTime fecha_actualizacion, TipoDocumento tipo_documento,
			List<Credito> lista_creditos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.password_hash = password_hash;
		this.activo = activo;
		this.fecha_creacion = fecha_creacion;
		this.fecha_actualizacion = fecha_actualizacion;
		this.tipo_documento = tipo_documento;
		this.lista_creditos = lista_creditos;
	}

	public Usuario() {
		super();
	}
    
}
