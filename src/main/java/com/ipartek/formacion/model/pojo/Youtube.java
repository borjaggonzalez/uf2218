package com.ipartek.formacion.model.pojo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Youtube {

	private int id;
	@NotNull
	@Size(min =3, max = 150)
	private String nombre;
	
	@NotNull
	@Size(min =11, max = 11)
	private String codigo;


	public Youtube() {
		super();
		this.id=-1;
		this.nombre="";
		this.codigo="";
	}

	public Youtube(int id, String nombre, String codigo, int reproducciones) {
		super();
		setId(id);
		setNombre(nombre);
		setCodigo(codigo);
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	@Override
	public String toString() {
		return "Youtube [id=" + id + ", nombre=" + nombre + ", codigo=" + codigo + "]";
	}

}
