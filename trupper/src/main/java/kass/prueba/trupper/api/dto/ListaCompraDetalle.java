package kass.prueba.trupper.api.dto;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "Productos")
public class ListaCompraDetalle {
	private Integer idListaCompra;
	private Integer idCodigoProducto;
}
