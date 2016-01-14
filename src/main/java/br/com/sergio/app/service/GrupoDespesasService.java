package br.com.sergio.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sergio.app.model.dao.GrupoDespesasDao;
import br.com.sergio.app.model.vo.GrupoDespesasVO;

@Service
public class GrupoDespesasService {

	@Autowired
	private GrupoDespesasDao dao;
	
	public void salvar(Integer id, String nome){
		if(id != null && id.longValue() > 0){
			dao.edita(id, nome);
		}
		else {
			dao.adiciona(nome);
		}
	}
	
	public boolean remove(Integer id){
		try {
			dao.remove(id);
			return true;
		} catch (Exception e){
			return false;
		}
	}
	
	public GrupoDespesasVO buscaUm(Integer id){
		return dao.buscaUm(id);
	}
	
	public List<GrupoDespesasVO> lista(){
		return dao.lista();
	}
}
