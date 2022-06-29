package com.idat.EC2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.EC2.models.Bodega;
import com.idat.EC2.models.Productos;
import com.idat.EC2.repository.BodegaRepository;
import com.idat.EC2.repository.ProductosRepository;

@Service
public class ProductosService {
	@Autowired
	ProductosRepository repository;

	public void guardarProductos(Productos producto) {
		repository.save(producto);
	}

	public void actualizarProductos(Productos producto) {
		repository.saveAndFlush(producto);
	}

	public void eliminarProductos(Integer id) {
		repository.deleteById(id);
	}

	public List<Productos> listarProductos() {
		return repository.findAll();
	}

	public Optional<Productos> obtenerProductosId(Integer id) {
		return repository.findById(id);
	}
}
