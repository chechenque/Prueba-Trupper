package kass.prueba.trupper.api.repository;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kass.prueba.trupper.api.dto.ListaCompra;
@Repository
public class ListaCompraRepository {
	
	@Autowired
	JdbcTemplate jdbc;
	
	public List<ListaCompra> getListas(){
		List<ListaCompra> l = new ArrayList<>();
		l = jdbc.query("SELECT * FROM LISTACOMPRA;", new RowMapper<ListaCompra>() {

			@Override
			public ListaCompra mapRow(ResultSet rs, int rowNum) throws SQLException {
				ListaCompra lc = new ListaCompra();
				lc.setIdLista(rs.getInt(1));
				lc.setCustomer_id(rs.getInt(2));
				lc.setNombre(rs.getString(3));
				lc.setFechaRegistro(rs.getDate(4));
				lc.setFechaUltimaActualizacion(rs.getDate(5));
				lc.setActivo(rs.getByte(6));
				return lc;
			}
			
		});
			
		return l;
	}
	
	public ListaCompra getLista(Integer id) {
		ListaCompra l = new ListaCompra();
		
		l = jdbc.queryForObject("SELECT * FROM LISTACOMPRA WHERE iDLista = '"+id+"';", new RowMapper<ListaCompra>() {

			@Override
			public ListaCompra mapRow(ResultSet rs, int rowNum) throws SQLException {
				ListaCompra lc = new ListaCompra();
				lc.setIdLista(rs.getInt(1));
				lc.setCustomer_id(rs.getInt(2));
				lc.setNombre(rs.getString(3));
				lc.setFechaRegistro(rs.getDate(4));
				lc.setFechaUltimaActualizacion(rs.getDate(5));
				lc.setActivo(rs.getByte(6));
				return lc;
			}
			
		});
		
		return l;
		
	}
	
	public void createLista(ListaCompra l) { 
		Date sqlDate = Date.valueOf(LocalDate.now());
		jdbc.update("INSERT INTO LISTACOMPRA "
				+ " VALUES("
				+ "" + l.getIdLista() + ","
				+ "" + l.getCustomer_id() + ","
				+ "'" + l.getNombre() + "',"
				+ "'" + sqlDate +"',"
				+ "'" + sqlDate + "',"
				+ "" + l.getActivo() + ");"
			);
	}
	
	public void deleteLista(Integer id) {
		Date sqlDate = Date.valueOf(LocalDate.now());
		jdbc.update("Update LISTACOMPRA SET  activo = 0, fechaUltimaActualizacion = '"+ sqlDate + "' WHERE iDLista = " +id+";");
	}
}
