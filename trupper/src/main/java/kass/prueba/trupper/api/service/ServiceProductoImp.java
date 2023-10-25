package kass.prueba.trupper.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import kass.prueba.trupper.api.dto.Producto;
import kass.prueba.trupper.api.repository.ProductoRepository;

@Service
public class ServiceProductoImp implements ServiceProducto {
	@Autowired
	ProductoRepository repository;
	
	@Autowired
	RestTemplate restTemplate;

	@Override
	public List<Producto> getProductos() {
		return repository.findAll();
	}

	@Override
	public void createProducto(Producto producto) {
		repository.save(producto);
	}

}
