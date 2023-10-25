package kass.prueba.trupper.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kass.prueba.trupper.api.dto.Producto;
import kass.prueba.trupper.api.service.ServiceProducto;

@RestController
@RequestMapping("/producto")
public class ControllerProducto {
	
	@Autowired
	ServiceProducto service;
	
	@GetMapping
	public ResponseEntity<List<Producto>> getProductos(){
		return new ResponseEntity<>(service.getProductos(),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<HttpStatus> createProducto(@Valid @RequestBody Producto producto){
		service.createProducto(producto);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

}
