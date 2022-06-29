package com.idat.EC2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.EC2.models.Bodega;
import com.idat.EC2.repository.BodegaRepository;

@Service
public class BodegaService {
	@Autowired
	BodegaRepository repository;

	public void guardarBodega(Bodega bodega) {
		repository.save(bodega);
	}

	public void actualizarBodega(Bodega bodega) {
		repository.saveAndFlush(bodega);
	}

	public void eliminarBodega(Integer id) {
		repository.deleteById(id);
	}

	public List<Bodega> listarBodega() {
		return repository.findAll();
	}

	public Optional<Bodega> obtenerBodegaId(Integer id) {
		return repository.findById(id);
	}
}
