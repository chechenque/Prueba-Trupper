package kass.prueba.trupper.api.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kass.prueba.trupper.api.dto.Cliente;
@Repository
public class ClienteRepository {
	@Autowired
	JdbcTemplate jdbc;
	
	public List<Cliente> findAll(){
		List<Cliente> clientes = new ArrayList<>();
		
		clientes = jdbc.query("SELECT * FROM CLIENTES;", new RowMapper<Cliente>() {

			@Override
			public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
				Cliente c = new Cliente();
				c.setIdCliente(rs.getInt(1));
				c.setNombre(rs.getString(2));
				c.setActivo(rs.getByte(3));
				return c;
			}
			
		});
		
		return clientes;	
	}
	
	public Cliente getCliente(Integer id) {
		Cliente c = new Cliente();
		
		c = jdbc.queryForObject("SELECT * FROM CLIENTES WHERE idCliente = '"+id+"';", new RowMapper<Cliente>() {

			@Override
			public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
				Cliente cl = new Cliente();
				cl.setIdCliente(rs.getInt(1));
				cl.setNombre(rs.getString(2));
				cl.setActivo(rs.getByte(3));
				return cl;
			}
			
		});
		
		return c;
	}
	
	public void save(Cliente c) {
		jdbc.update("INSERT INTO CLIENTES (idCliente,nombre,activo) VALUES("
				+ "idCliente = '" + c.getIdCliente() + "',"
				+ "nombre = '" + c.getNombre() + "',"
				+ "activo = '" + c.getActivo() + "');"
			);
	}

}
