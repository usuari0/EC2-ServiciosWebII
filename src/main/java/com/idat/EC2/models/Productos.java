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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name = "productos")
@Entity
public class Productos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProducto;
	
	private String producto;
	private String descripcion;
	private Double precio;
	private Integer stock;
	
	@OneToMany(mappedBy = "productos")
	private List<Bodega> bodega = new ArrayList<>();
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(
			name = "producto_cliente",
			joinColumns = @JoinColumn(
				name = "idProducto",
				nullable = false,
				foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (idProducto) references productos(idProducto)")
			),
			inverseJoinColumns = @JoinColumn(
				name = "idCliente",
				nullable = false,
				foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (idCliente) references cliente(idCliente)")
			)
		)
	private List<Cliente> cliente = new ArrayList<>();
	
	public Productos() {}
	
	public Integer getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	
	
}
