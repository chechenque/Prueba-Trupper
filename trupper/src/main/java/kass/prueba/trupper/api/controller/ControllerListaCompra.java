package kass.prueba.trupper.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kass.prueba.trupper.api.dto.ListaCompra;
import kass.prueba.trupper.api.service.ServiceListaCompra;


@RestController
@RequestMapping("/compra")
public class ControllerListaCompra {
	@Autowired
	ServiceListaCompra service;
	
	@GetMapping
	public ResponseEntity<List<ListaCompra>> getListas(){
		return new ResponseEntity<>(service.getListas(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ListaCompra> getLista(@PathVariable("id") Integer id){
		return new ResponseEntity<>(service.getLista(id),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<HttpStatus> createLista(@Valid @RequestBody ListaCompra lista){
		service.createLista(lista);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteMapping(@PathVariable("id") Integer id){
		service.delete(id);
		return new ResponseEntity<>(HttpStatus.OK); 
	}
}
