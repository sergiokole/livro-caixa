package br.com.sergio.app.model.dao;

import java.util.List;

import br.com.sergio.app.model.vo.GrupoDespesasVO;

public interface GrupoDespesasDao {

	GrupoDespesasVO adiciona(String nome);
	
	void edita(Integer id, String nome);
	
	void remove(Integer id);
	
	GrupoDespesasVO buscaUm(Integer id);
	
	List<GrupoDespesasVO> lista();

	
}
