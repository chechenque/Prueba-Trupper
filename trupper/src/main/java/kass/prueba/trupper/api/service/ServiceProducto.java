package kass.prueba.trupper.api.service;

import java.util.List;

import kass.prueba.trupper.api.dto.Producto;

public interface ServiceProducto {
	
	public List<Producto> getProductos();
	
	public void createProducto(Producto producto);
}
