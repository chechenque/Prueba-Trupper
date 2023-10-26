package kass.prueba.trupper.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kass.prueba.trupper.api.dto.ListaCompraDetalle;
import kass.prueba.trupper.api.repository.ListaCompraDetalleRepository;

@Service
public class ServiceListaCompraDetalleImp implements ServiceListaCompraDetalle {
	@Autowired
	ListaCompraDetalleRepository repository;

	@Override
	public List<ListaCompraDetalle> getListas() {
		return repository.getListas();
	}

	@Override
	public ListaCompraDetalle getLista(Integer idLista, Integer codigoP) {
		return repository.getLista(idLista,codigoP);
	}

	@Override
	public void updateCantidad(Integer idLista, Integer codigoP, Integer cantidad) {
		repository.updateCantidad(idLista,codigoP,cantidad);

	}

	@Override
	public void createList(ListaCompraDetalle l) {
		repository.save(l);

	}

}
