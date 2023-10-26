package kass.prueba.trupper.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kass.prueba.trupper.api.dto.Cliente;
import kass.prueba.trupper.api.repository.ClienteRepository;

@Service
public class ServiceClienteImp implements ServiceCliente {
	
	@Autowired
	ClienteRepository repository;

	@Override
	public List<Cliente> getClientes() {
		return repository.findAll();
	}

	@Override
	public Cliente getCliente(Integer id) {
		return repository.getCliente(id);
	}

	@Override
	public void createCliente(Cliente c) {
		repository.save(c);
	}

}
