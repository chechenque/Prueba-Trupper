package kass.prueba.trupper.api.service;

import java.util.List;

import kass.prueba.trupper.api.dto.ListaCompra;

public interface ServiceListaCompra {
	public List<ListaCompra> getListas();
	
	public ListaCompra getLista(Integer id);
	
	public void createLista(ListaCompra l);
	
	public void delete(Integer idLista);
}
