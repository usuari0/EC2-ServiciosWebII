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

import com.idat.EC2.models.Productos;
import com.idat.EC2.models.Usuario;
import com.idat.EC2.services.ProductosService;
import com.idat.EC2.services.UsuarioService;

@RestController
public class ProductosController {
	@Autowired
	ProductosService service;
	
	@PostMapping("/guardar")
	public @ResponseBody ResponseEntity<Void> guardarProductos(@RequestBody Productos producto) {
		try {
			service.guardarProductos(producto);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		} catch(Exception e){
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/actualizar")
	public @ResponseBody ResponseEntity<Void> actualizarProductos(@RequestBody Productos producto) {
		Optional<Productos> p = service.obtenerProductosId(producto.getIdProducto());
		if(p.isPresent()) {
			service.actualizarProductos(producto);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
}
	
	@GetMapping("/listar")
	public @ResponseBody ResponseEntity<List<Productos>> listarProductos(){
		return new ResponseEntity<List<Productos>>(service.listarProductos(), HttpStatus.OK);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public @ResponseBody ResponseEntity<Void> eliminarProductos(@PathVariable Integer id){
		try {
			service.eliminarProductos(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/obtener/{id}")
	public @ResponseBody ResponseEntity<Productos> encontrarProductos(@PathVariable Integer id){
		Optional<Productos> p = service.obtenerProductosId(id);
		if(p.isPresent()) {
			return new ResponseEntity<Productos>(p.get(), HttpStatus.OK);
		}   return new ResponseEntity<Productos>(HttpStatus.NOT_FOUND);
	}
}
