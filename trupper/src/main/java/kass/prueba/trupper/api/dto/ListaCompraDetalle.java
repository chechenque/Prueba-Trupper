package kass.prueba.trupper.api.dto;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "LISTACOMPRADETALLE")
public class ListaCompraDetalle {
	
	@Id
	@Column(name = "idListaCompra")
	@JsonProperty("id_lista_compra")
	private Integer idListaCompra;
	
	@Id
	@Column(name = "idCodigoProducto")
	@JsonProperty("id_codigo_producto")
	private Integer idCodigoProducto;
	
	@Column(name = "cantidad")
	@JsonProperty("cantidad")
	private Integer cantidad;
}
