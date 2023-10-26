package kass.prueba.trupper.api.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kass.prueba.trupper.api.dto.ListaCompraDetalle;
@Repository
public class ListaCompraDetalleRepository {
	@Autowired
	JdbcTemplate jdbc;
	
	public List<ListaCompraDetalle>getListas(){
		List<ListaCompraDetalle> l = new ArrayList<>();
		
		l = jdbc.query("SELECT * FROM LISTACOMPRADETALLE;", new RowMapper<ListaCompraDetalle>() {

			@Override
			public ListaCompraDetalle mapRow(ResultSet rs, int rowNum) throws SQLException {
				ListaCompraDetalle lc = new ListaCompraDetalle();
				
				lc.setIdListaCompra(rs.getInt(1));
				lc.setIdCodigoProducto(rs.getInt(2));
				lc.setCantidad(rs.getInt(3));
				
				return lc;
			}
			
		});
		
		return l;
	}
	
	public ListaCompraDetalle getLista(Integer idLista, Integer codigoP) {
		ListaCompraDetalle l = new ListaCompraDetalle();
		l = jdbc.queryForObject(
				"SELECT * FROM LISTACOMPRADETALLE WHERE"
				+ " idListaCompra = '" + idLista + "' AND idCodigoProducto = '" + codigoP
				+ "';", new RowMapper<ListaCompraDetalle>() {

					@Override
					public ListaCompraDetalle mapRow(ResultSet rs, int rowNum) throws SQLException {
						ListaCompraDetalle lc = new ListaCompraDetalle();
						
						lc.setIdListaCompra(rs.getInt(1));
						lc.setIdCodigoProducto(rs.getInt(2));
						lc.setCantidad(rs.getInt(3));
						
						return lc;
					}
					
				});
		return l;
	}
	
	public void updateCantidad(Integer idLista, Integer codigoP, Integer cantidad) {
		jdbc.update("Update LISTACOMPRADETALLE SET  cantidad = '"+cantidad+"' "
				+ "WHERE iDLista = '" +idLista+"' AND idCodigoProducto = '"+codigoP+"';");
	}
	
	public void save(ListaCompraDetalle l) {
		jdbc.update("INSERT INTO LISTACOMPRADETALLE"
				+" VALUES("
				+ "" + l.getIdListaCompra() + ","
				+ "" + l.getIdCodigoProducto() + ","
				+ "" + l.getCantidad() + ");"
			);
	}
}
