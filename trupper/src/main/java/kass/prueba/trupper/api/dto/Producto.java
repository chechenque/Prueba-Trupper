package kass.prueba.trupper.api.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "Productos")
//@Entity
public class Producto {
	
	@Id
	@Column(name = "idProducto")
	@JsonProperty("id_producto")
	private Integer idProducto;
	
	@Column(name = "clave")
	@JsonProperty("clave")
	private String clave;
	
	@Column(name = "descripcion")
	@JsonProperty("descripcion")
	private String descripcion;
	
	@Column(name = "activo")
	@JsonProperty("activo")
	private Byte activo;
}
