package com.idat.EC2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.EC2.models.Usuario;
import com.idat.EC2.repository.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	UsuarioRepository repository;

	public void guardarUsuario(Usuario usuario) {
		repository.save(usuario);
	}

	public void actualizarUsuario(Usuario usuario) {
		repository.saveAndFlush(usuario);
	}

	public void eliminarUsuario(Integer id) {
		repository.deleteById(id);
	}

	public List<Usuario> listarUsuario() {
		return repository.findAll();
	}

	public Optional<Usuario> obtenerUsuarioId(Integer id) {
		return repository.findById(id);
	}
}
