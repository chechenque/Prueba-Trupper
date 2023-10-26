package kass.prueba.trupper.api.service;

import java.util.List;

import kass.prueba.trupper.api.dto.ListaCompraDetalle;

public interface ServiceListaCompraDetalle {
	
	public List<ListaCompraDetalle> getListas();
	
	public ListaCompraDetalle getLista(Integer idLista, Integer codigoP);
	
	public void updateCantidad(Integer idLista, Integer codigoP, Integer cantidad);
	
	public void createList(ListaCompraDetalle l);
	
}
