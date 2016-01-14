package br.com.sergio.app.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sergio.app.model.dao.GrupoContaDao;

@Service
public class GrupoContaService {

	@Autowired
	private GrupoContaDao dao;
	
	public Long salvar(Long id, String nome){
		if(id != null && id.longValue() > 0){
			dao.edita(id, nome);
			return id;
		}
		else {
			return dao.adiciona(nome);
		}
	}
	
	public boolean remove(Long id){
		try {
			dao.remove(id);
			return true;
		} catch (Exception e){
			return false;
		}
		
	}
	
	public String buscaNome(Long id){
		return dao.buscaNome(id);
	}
	
	public Map<Long, String> lista(){
		Map<Long, String> linkedHashMap = new LinkedHashMap<>();
		List<Map<Long,String>> lista = dao.lista();
		for(Map<Long,String> map : lista){
			Entry<Long, String> entry = map.entrySet().iterator().next();
			Long key = entry.getKey();
			String value = entry.getValue();
			linkedHashMap.put(key, value);
		}
		return linkedHashMap;
		
	}
	
}
