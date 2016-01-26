package br.com.sergio.app.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sergio.app.model.repository.crud.CanalAtendimentoRepository;
import br.com.sergio.app.model.repository.crud.OperacaoBancariaPorCanalRepository;
import br.com.sergio.app.model.repository.crud.OperacaoBancariaRepository;
import br.com.sergio.app.model.vo.entity.CanalAtendimento;
import br.com.sergio.app.model.vo.entity.OperacaoBancaria;
import br.com.sergio.app.model.vo.entity.OperacaoBancariaPorCanal;
import br.com.sergio.web.controller.operacaocanal.OperacaoBancariaPorCanalForm;

@Service
public class OperacaoBancariaPorCanalService {
	
	@Autowired
	private OperacaoBancariaPorCanalRepository repository;
	
	@Autowired
	private OperacaoBancariaRepository operacaoBancariaRepository;
	
	@Autowired
	private CanalAtendimentoRepository canalAtendimentoRepository;


	public void delete(Integer id) {
		repository.delete(id);
	}

	public Map<Integer, String> listaOperacaoBancaria() {
		Map<Integer,String> map = new HashMap<>();
		operacaoBancariaRepository.findAll().forEach(entidade -> {
			map.put(entidade.getId(), entidade.getNome());
		});
		return map;
	}

	public Map<Integer, String> listaCanalAtendimento() {
		Map<Integer,String> map = new HashMap<>();
		canalAtendimentoRepository.findAll().forEach(entidade -> {
			map.put(entidade.getId(), entidade.getNome());
		});
		return map;
	}

	@Transactional(rollbackFor=Exception.class)
	public void salvar(
			Integer operacaoBancariaPorCanalId,
			Integer operacaoBancariaId, 
			String operacaoBancariaNome, 
			Integer canalAtendimentoId,
			String canalAtendimentoNome) {
		
		OperacaoBancariaPorCanal operacaoBancariaPorCanal = new OperacaoBancariaPorCanal();
		operacaoBancariaPorCanal.setId(operacaoBancariaPorCanalId);
		operacaoBancariaPorCanal.setOperacaoBancaria(salvarOperacaoBancaria(operacaoBancariaId, operacaoBancariaNome));
		operacaoBancariaPorCanal.setCanalAtendimento(salvarCanalAtendimento(canalAtendimentoId, canalAtendimentoNome));
		
		repository.save(operacaoBancariaPorCanal);
	}

	private OperacaoBancaria salvarOperacaoBancaria(Integer id, String nome) {
		OperacaoBancaria operacaoBancaria = new OperacaoBancaria();
		operacaoBancaria.setId(id);
		operacaoBancaria.setNome(nome);
		if(id == null){
			operacaoBancaria = operacaoBancariaRepository.save(operacaoBancaria);
		}
		return operacaoBancaria;
	}

	private CanalAtendimento salvarCanalAtendimento(Integer id, String nome) {
		CanalAtendimento canalAtendimento = new CanalAtendimento();
		canalAtendimento.setId(id);
		canalAtendimento.setNome(nome);
		if(id == null){
			canalAtendimento = canalAtendimentoRepository.save(canalAtendimento);
		}
		return canalAtendimento;
	}

	public List<OperacaoBancariaPorCanalForm> lista() {
		
		List<OperacaoBancariaPorCanalForm> dadosForm = new ArrayList<>();
		
		repository.findAll().forEach(action -> {
			dadosForm.add(
					OperacaoBancariaPorCanalForm.lista(
							action.getId(), 
							action.getOperacaoBancaria().getNome(), 
							action.getCanalAtendimento().getNome()));
		});
		
		return dadosForm;
	}
	
	public OperacaoBancariaPorCanalForm edita(Integer id) {
		
		OperacaoBancariaPorCanal operacaoBancariaPorCanal = repository.findOne(id);
		
		return OperacaoBancariaPorCanalForm.edita(
				operacaoBancariaPorCanal.getId(),
				operacaoBancariaPorCanal.getOperacaoBancaria().getId(), 
				operacaoBancariaPorCanal.getCanalAtendimento().getId());
	}
	
}
