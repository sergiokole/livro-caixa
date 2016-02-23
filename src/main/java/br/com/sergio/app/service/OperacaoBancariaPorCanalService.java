package br.com.sergio.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import br.com.sergio.app.constants.TipoOperacaoBancaria;
import br.com.sergio.app.model.jpa.CanalOperacaoBancaria;
import br.com.sergio.app.model.jpa.OperacaoBancaria;
import br.com.sergio.app.model.repository.jpa.CanalOperacaoBancariaRepository;
import br.com.sergio.app.model.repository.jpa.OperacaoBancariaRepository;

@Service
public class OperacaoBancariaPorCanalService {
	
	@Autowired
	private OperacaoBancariaRepository repository;
	
	@Autowired
	private CanalOperacaoBancariaRepository canalRepository;
	
	public List<CanalOperacaoBancaria> listarCanais(){
		return canalRepository.findAll();
	}
	
	public List<OperacaoBancaria> listar(){
		return repository.findAll();
	}
	
	public void salvar(
			Integer id,
			String nome,
			TipoOperacaoBancaria tipo,
			String apelido,
			List<Integer> canais
			){
		
		OperacaoBancaria operacaoBancaria = new OperacaoBancaria();
		operacaoBancaria.setId(id);
		operacaoBancaria.setNome(nome);
		operacaoBancaria.setTipo(tipo);
		operacaoBancaria.setApelido(apelido);
		operacaoBancaria.setCanais(carregaListaCanalOperacaoBancaria(canais));
	
		repository.save(operacaoBancaria);
	}
	
	private List<CanalOperacaoBancaria> carregaListaCanalOperacaoBancaria(List<Integer> ids){
		List<CanalOperacaoBancaria> listCanalOperacaoBancaria = new ArrayList<>();
		if(!CollectionUtils.isEmpty(ids)){
			ids.forEach(id -> listCanalOperacaoBancaria.add(canalRepository.findOne(id)));
		}
		return listCanalOperacaoBancaria;
	}
}
