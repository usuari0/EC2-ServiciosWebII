package com.idat.EC2.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "bodega")
@Entity
public class Bodega {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idBodega;
	
	private String nombre;
	
	private String direccion;
	
	@ManyToOne
	@JoinColumn(
		name = "idProducto",
		nullable = false,
		foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (idProducto) references productos(idProducto)")
	)
	private Productos productos;
	
	public Integer getIdBodega() {
		return idBodega;
	}
	public void setIdBodega(Integer idBodega) {
		this.idBodega = idBodega;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Productos getProductos() {
		return productos;
	}
	public void setProductos(Productos productos) {
		this.productos = productos;
	}
}
