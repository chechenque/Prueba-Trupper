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
@Table(name = "Clientes")
public class Cliente {
	
	@Id
	@Column(name = "idCliente")
	@JsonProperty("id_cliente")
	@NotNull
	private Integer idCliente;
	
	@Column(name = "nombre")
	@JsonProperty("nombre")
	@NotNull
	private String nombre;
	
	@Column(name = "activo")
	@JsonProperty("activo")
	private Byte activo;
}
