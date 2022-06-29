package com.idat.EC2.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.idat.EC2.models.Bodega;
import com.idat.EC2.models.Usuario;
import com.idat.EC2.services.BodegaService;
import com.idat.EC2.services.UsuarioService;

@RestController
public class UsuarioController {
	@Autowired
	UsuarioService service;
	
	@PostMapping("/guardar")
	public @ResponseBody ResponseEntity<Void> guardarUsuario(@RequestBody Usuario usuario) {
		try {
			service.guardarUsuario(usuario);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		} catch(Exception e){
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/actualizar")
	public @ResponseBody ResponseEntity<Void> actualizarUsuario(@RequestBody Usuario usuario) {
		Optional<Usuario> p = service.obtenerUsuarioId(usuario.getIdUsuario());
		if(p.isPresent()) {
			service.actualizarUsuario(usuario);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
}
	
	@GetMapping("/listar")
	public @ResponseBody ResponseEntity<List<Usuario>> listarUsuario(){
		return new ResponseEntity<List<Usuario>>(service.listarUsuario(), HttpStatus.OK);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public @ResponseBody ResponseEntity<Void> eliminarUsuario(@PathVariable Integer id){
		try {
			service.eliminarUsuario(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/obtener/{id}")
	public @ResponseBody ResponseEntity<Usuario> encontrarUsuario(@PathVariable Integer id){
		Optional<Usuario> p = service.obtenerUsuarioId(id);
		if(p.isPresent()) {
			return new ResponseEntity<Usuario>(p.get(), HttpStatus.OK);
		}   return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
	}
}
