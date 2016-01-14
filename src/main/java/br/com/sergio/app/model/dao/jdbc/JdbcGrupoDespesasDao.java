package br.com.sergio.app.model.dao.jdbc;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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

import br.com.sergio.app.model.dao.GrupoDespesasDao;
import br.com.sergio.app.model.vo.GrupoDespesasVO;

@Repository
public class JdbcGrupoDespesasDao implements GrupoDespesasDao {
	
	private static final String TABLE_NAME = "grupo_despesas";
	
	private SimpleJdbcInsert insert;
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Qualifier("mysqlDataSource")
	@Autowired
	public void setDataSource(DataSource dataSource) {
		insert = new SimpleJdbcInsert(dataSource).withTableName(TABLE_NAME).usingGeneratedKeyColumns("id");
		jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public GrupoDespesasVO adiciona(String nome) {
		
		Integer id = insert.executeAndReturnKey(
				new MapSqlParameterSource()
					.addValue("nome", nome)
					.getValues()).intValue();
		
		return new GrupoDespesasVO(id, nome);
	}

	@Override
	public void edita(Integer id, String nome) {
		jdbcTemplate.update(
				"UPDATE grupo_despesas SET nome = :nome WHERE id = :id", 
				new MapSqlParameterSource()
					.addValue("nome", nome)
					.addValue("id", id));
	}

	@Override
	public void remove(Integer id) {
		jdbcTemplate.update(
				"DELETE FROM grupo_despesas WHERE id = :id", 
				new MapSqlParameterSource()
					.addValue("id", id));
	}

	@Override
	public GrupoDespesasVO buscaUm(Integer id) {
		
		String nome = jdbcTemplate.query("SELECT nome FROM grupo_despesas WHERE id = :id", 
				new MapSqlParameterSource().addValue("id", id).getValues(),
				new ResultSetExtractor<String>() {

					@Override
					public String extractData(ResultSet rs) throws SQLException, DataAccessException {
						rs.next();
						return rs.getString("nome");
					}
				});

		return new GrupoDespesasVO(id, nome);
	}

	@Override
	public List<GrupoDespesasVO> lista() {
		
		return jdbcTemplate.query(
				"SELECT id, nome FROM grupo_despesas order by nome",
				new RowMapper<GrupoDespesasVO>() {
					@Override
					public GrupoDespesasVO mapRow(ResultSet rs, int rowNumber) throws SQLException {
						Integer id = rs.getInt("id");
						String nome = rs.getString("nome");
						return new GrupoDespesasVO(id, nome);
					}
			});
	}

}
