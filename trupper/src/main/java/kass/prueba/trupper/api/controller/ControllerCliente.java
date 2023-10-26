package kass.prueba.trupper.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kass.prueba.trupper.api.dto.Cliente;
import kass.prueba.trupper.api.service.ServiceCliente;

@RestController
@RequestMapping("/cliente")
public class ControllerCliente {
	
	@Autowired
	ServiceCliente service;
	
	@GetMapping
	public ResponseEntity<List<Cliente>> getClientes(){
		return new ResponseEntity<>(service.getClientes(),HttpStatus.OK);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> getCliente(@Param("id") Integer id){
		return new ResponseEntity<>(service.getCliente(id),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<HttpStatus> createCliente(@Valid @RequestBody Cliente c){
		service.createCliente(c);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
