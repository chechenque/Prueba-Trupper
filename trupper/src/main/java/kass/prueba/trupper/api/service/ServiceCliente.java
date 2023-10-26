package kass.prueba.trupper.api.service;

import java.util.List;

import kass.prueba.trupper.api.dto.Cliente;

public interface ServiceCliente {
	public List<Cliente> getClientes();
	
	public Cliente getCliente(Integer id);
	
	public void createCliente(Cliente c);
}
