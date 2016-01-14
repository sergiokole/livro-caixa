package br.com.sergio.app.model.dao;

import java.util.List;
import java.util.Map;

public interface GrupoContaDao {

	Long adiciona(String nome);
	
	void edita(Long id, String nome);
	
	void remove(Long id);
	
	String buscaNome(Long id);
	
	List<Map<Long, String>> lista();
	
}
