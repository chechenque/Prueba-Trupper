package kass.prueba.trupper.api.dto;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "ListaCompra")
public class ListaCompra {
	
	@Id
	@Column(name = "idLista")
	@JsonProperty("id_lista")
	@NotNull
	private Integer idLista;
	
	@NotNull
	@JsonProperty("customer_id")
	@Column(name = "customer_id")
	private Integer customer_id;
	
	@NotNull
	@JsonProperty("nombre")
	@Column(name = "nombre")
	private String nombre;
	
	@JsonProperty("fecha_registro")
	@Column(name = "fechaRegistro")
	private Date fechaRegistro;
	
	@JsonProperty("fecha_ultima_act")
	@Column(name = "fechaUltimaActualizacion")
	private Date fechaUltimaActualizacion;
	
	@JsonProperty("activo")
	@Column(name = "activo")
	private Byte activo;
	
}
