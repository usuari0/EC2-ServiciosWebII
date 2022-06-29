package com.idat.EC2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.EC2.models.Cliente;
import com.idat.EC2.repository.ClienteRepository;

@Service
public class ClienteService {
	@Autowired
	ClienteRepository repository;

	public void guardarCliente(Cliente cliente) {
		repository.save(cliente);
	}

	public void actualizarCliente(Cliente cliente) {
		repository.saveAndFlush(cliente);
	}

	public void eliminarCliente(Integer id) {
		repository.deleteById(id);
	}

	public List<Cliente> listarCliente() {
		return repository.findAll();
	}

	public Optional<Cliente> obtenerClienteId(Integer id) {
		return repository.findById(id);
	}
}
