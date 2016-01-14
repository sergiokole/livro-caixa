package br.com.sergio.app.model.dao.jdbc;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import br.com.sergio.app.model.dao.GrupoContaDao;

@Repository
public class JdbcGrupoContaDao implements GrupoContaDao {
	
	private static final String TABLE_NAME = "grupo_conta";
	
	private SimpleJdbcInsert insert;
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Qualifier("mysqlDataSource")
	@Autowired
	public void setDataSource(DataSource dataSource) {
		insert = new SimpleJdbcInsert(dataSource).withTableName(TABLE_NAME).usingGeneratedKeyColumns("id");
		jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public Long adiciona(String nome) {
		
		return insert.executeAndReturnKey(
				new MapSqlParameterSource()
					.addValue("nome", nome)
					.getValues()).longValue();
	}

	@Override
	public void edita(Long id, String nome) {
		jdbcTemplate.update(
				"UPDATE grupo_conta SET nome = :nome WHERE id = :id", 
				new MapSqlParameterSource()
					.addValue("nome", nome)
					.addValue("id", id));
	}

	@Override
	public void remove(Long id) {
		jdbcTemplate.update(
				"DELETE FROM grupo_conta WHERE id = :id", 
				new MapSqlParameterSource()
					.addValue("id", id));
	}

	@Override
	public String buscaNome(Long id) {
		
		String nome = jdbcTemplate.query("SELECT id, nome FROM grupo_conta WHERE id = :id", 
				new MapSqlParameterSource().addValue("id", id).getValues(),
				new ResultSetExtractor<String>() {

					@Override
					public String extractData(ResultSet rs) throws SQLException, DataAccessException {
						rs.next();
						return rs.getString("nome");
					}
				});

		return nome;
	}

	@Override
	public List<Map<Long, String>> lista() {
		
		return jdbcTemplate.query(
				"SELECT id, nome FROM grupo_conta order by nome",
				new RowMapper<Map<Long,String>>() {
					@Override
					public Map<Long,String> mapRow(ResultSet rs, int rowNumber) throws SQLException {
						Map<Long, String> map = new HashMap<>();
						Long key = rs.getLong("id");
						String value = rs.getString("nome");
						map.put(key , value);
						return map;
					}
			});
		
	}

}
