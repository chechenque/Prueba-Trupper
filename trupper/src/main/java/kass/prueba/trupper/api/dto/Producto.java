package kass.prueba.trupper.api.dto;

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
@Table(name = "Productos")
//@Entity
public class Producto {
	
	@Id
	@Column(name = "IDPRODUCTO")
	@JsonProperty("id_producto")
	@NotNull
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
