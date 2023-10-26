package kass.prueba.trupper.api.dto;

import java.sql.Date;

import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "ListaCompra")
public class ListaCompra {
	private Integer idLista;
	private Integer customer_id;
	private String nombre;
	private Date fechaRegistro;
	private Date fechaUltimaActualizacion;
	private Byte activo;
	
}
