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

import com.idat.EC2.models.Cliente;
import com.idat.EC2.services.ClienteService;

@RestController
public class ClienteController {
	@Autowired
	ClienteService service;
	
	@PostMapping("/guardar")
	public @ResponseBody ResponseEntity<Void> guardarCliente(@RequestBody Cliente cliente) {
		try {
			service.guardarCliente(cliente);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		} catch(Exception e){
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/actualizar")
	public @ResponseBody ResponseEntity<Void> actualizarCliente(@RequestBody Cliente cliente) {
		Optional<Cliente> p = service.obtenerClienteId(cliente.getIdCliente());
		if(p.isPresent()) {
			service.actualizarCliente(cliente);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
}
	
	@GetMapping("/listar")
	public @ResponseBody ResponseEntity<List<Cliente>> listarCliente(){
		return new ResponseEntity<List<Cliente>>(service.listarCliente(), HttpStatus.OK);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public @ResponseBody ResponseEntity<Void> eliminarCliente(@PathVariable Integer id){
		try {
			service.eliminarCliente(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/obtener/{id}")
	public @ResponseBody ResponseEntity<Cliente> encontrarCliente(@PathVariable Integer id){
		Optional<Cliente> p = service.obtenerClienteId(id);
		if(p.isPresent()) {
			return new ResponseEntity<Cliente>(p.get(), HttpStatus.OK);
		}   return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
	}
}
