package kass.prueba.trupper.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.origin.SystemEnvironmentOrigin;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kass.prueba.trupper.api.dto.ListaCompraDetalle;
import kass.prueba.trupper.api.service.ServiceListaCompraDetalle;
@RestController
@RequestMapping("/detalle")
public class ControllerListaCompraDetalle {
	@Autowired
	ServiceListaCompraDetalle service;
	
	@GetMapping
	public ResponseEntity<List<ListaCompraDetalle>> getListas(){
		return new ResponseEntity<>(service.getListas(), HttpStatus.OK);
	}
	
	@GetMapping("/{idLista}/{codigo}")
	public ResponseEntity<ListaCompraDetalle> getLista(
			@Param("idLista") Integer idLista, @Param("codigo") Integer codigo) {
		return new ResponseEntity<>(service.getLista(idLista, codigo),HttpStatus.OK);
	}
	
	@PutMapping("/{idLista}/{codigo}")
	public ResponseEntity<HttpStatus> updateCantidad(
			@Param("idLista") Integer idLista, @Param("codigo") Integer codigo, @RequestBody Integer cantidad){
		service.updateCantidad(idLista, idLista, cantidad);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PostMapping
	public ResponseEntity<HttpStatus> createLista(ListaCompraDetalle l){
		System.out.println("HOLAAAAAA"+l.getIdListaCompra());
		service.createList(l);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}

	