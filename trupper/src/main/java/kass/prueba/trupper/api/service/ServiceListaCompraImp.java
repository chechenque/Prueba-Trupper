package kass.prueba.trupper.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kass.prueba.trupper.api.dto.ListaCompra;
import kass.prueba.trupper.api.repository.ListaCompraRepository;

@Service
public class ServiceListaCompraImp implements ServiceListaCompra {
	@Autowired
	ListaCompraRepository repository;

	@Override
	public List<ListaCompra> getListas() {
		return repository.getListas();
	}

	@Override
	public void createLista(ListaCompra l) {
		repository.createLista(l);

	}

	@Override
	public void delete(Integer idLista) {
		repository.deleteLista(idLista);
	}

	@Override
	public ListaCompra getLista(Integer id) {
		return repository.getLista(id);
	}

}
