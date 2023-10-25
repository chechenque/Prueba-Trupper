package kass.prueba.trupper.api.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kass.prueba.trupper.api.dto.Producto;

@Repository
public class ProductoRepository {
	@Autowired
	JdbcTemplate jdbc;
	
	public List<Producto> findAll(){
		List<Producto> prod = new ArrayList<>();
		
		
		prod = jdbc.query("SELECT * FROM PRODUCTOS;", new RowMapper<Producto>() {

			@Override
			public Producto mapRow(ResultSet rs, int rowNum) throws SQLException {
				Producto p = new Producto();
				p.setIdProducto(rs.getInt(1));
				p.setClave(rs.getString(2));
				p.setDescripcion(rs.getString(3));
				p.setActivo(rs.getByte(4));
				return p;
			}
			
		});
		
		
		return prod;
	}
	
	public void save(Producto p) {
		jdbc.update("INSERT INTO PRODUCTOS (idProducto,clave,descripcion,activo) VALUES("
					+ "idProducto = '" + p.getIdProducto() + "',"
					+ "clave = '" + p.getClave() + "',"
					+ "descripcion = '" + p.getDescripcion() + "',"
					+ "activo = '" + p.getActivo() + "');"
				);
	}
}
