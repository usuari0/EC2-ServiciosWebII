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
import com.idat.EC2.models.Cliente;
import com.idat.EC2.services.BodegaService;
import com.idat.EC2.services.ClienteService;

@RestController
public class BodegaController {
	@Autowired
	BodegaService service;
	
	@PostMapping("/guardar")
	public @ResponseBody ResponseEntity<Void> guardarBodega(@RequestBody Bodega bodega) {
		try {
			service.guardarBodega(bodega);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		} catch(Exception e){
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/actualizar")
	public @ResponseBody ResponseEntity<Void> actualizarBodega(@RequestBody Bodega bodega) {
		Optional<Bodega> p = service.obtenerBodegaId(bodega.getIdBodega());
		if(p.isPresent()) {
			service.actualizarBodega(bodega);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
}
	
	@GetMapping("/listar")
	public @ResponseBody ResponseEntity<List<Bodega>> listarBodega(){
		return new ResponseEntity<List<Bodega>>(service.listarBodega(), HttpStatus.OK);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public @ResponseBody ResponseEntity<Void> eliminarBodega(@PathVariable Integer id){
		try {
			service.eliminarBodega(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/obtener/{id}")
	public @ResponseBody ResponseEntity<Bodega> encontrarBodega(@PathVariable Integer id){
		Optional<Bodega> p = service.obtenerBodegaId(id);
		if(p.isPresent()) {
			return new ResponseEntity<Bodega>(p.get(), HttpStatus.OK);
		}   return new ResponseEntity<Bodega>(HttpStatus.NOT_FOUND);
	}
}
