package br.com.sergio.app.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sergio.app.model.repository.CanalOperacaoBancariaRepository;
import br.com.sergio.app.model.repository.OperacaoBancariaRepository;
import br.com.sergio.app.model.repository.UseOperacaoBancariaPorCanalVOMapping;
import br.com.sergio.app.model.vo.OperacaoBancariaPorCanalVO;
import br.com.sergio.app.model.vo.entity.CanalOperacaoBancaria;
import br.com.sergio.app.model.vo.entity.OperacaoBancaria;
import br.com.sergio.web.controller.operacaocanal.OperacaoBancariaPorCanalForm;

@Service
public class OperacaoBancariaPorCanalService {
	
	@Autowired
	private OperacaoBancariaRepository repository;
	
	@Autowired
	private CanalOperacaoBancariaRepository canalRepository;
	
	@Autowired
	private UseOperacaoBancariaPorCanalVOMapping operacaoBancariaPorCanal;
	
	public void delete(Integer id) {
		repository.delete(id);
	}

	public Map<Integer, String> listaOperacaoBancaria() {
		Map<Integer,String> map = new HashMap<>();
		repository.findAll().forEach(entidade -> {
			map.put(entidade.getId(), entidade.getNome());
		});
		return map;
	}

	public Map<Integer, String> listaCanalAtendimento() {
		Map<Integer,String> map = new HashMap<>();
		canalRepository.findAll().forEach(entidade -> {
			map.put(entidade.getId(), entidade.getNome());
		});
		return map;
	}

	@Transactional(rollbackFor=Exception.class)
	public void salvar(
			Integer operacaoBancariaId, 
			String operacaoBancariaNome, 
			Integer canalOperacaoBancariaId,
			String canalOperacaoBancariaNome) {
		
//		OperacaoBancariaPorCanal operacaoBancariaPorCanal = new OperacaoBancariaPorCanal();
//		operacaoBancariaPorCanal.setId(operacaoBancariaPorCanalId);
//		operacaoBancariaPorCanal.setOperacaoBancaria(salvarOperacaoBancaria(operacaoBancariaId, operacaoBancariaNome));
//		operacaoBancariaPorCanal.setCanalAtendimento(salvarCanalAtendimento(canalAtendimentoId, canalAtendimentoNome));
//		
//		repository.save(operacaoBancariaPorCanal);
	}

	private OperacaoBancaria salvarOperacaoBancaria(Integer id, String nome) {
		OperacaoBancaria operacaoBancaria = new OperacaoBancaria();
		operacaoBancaria.setId(id);
		operacaoBancaria.setNome(nome);
//		if(id == null){
//			operacaoBancaria = operacaoBancariaRepository.save(operacaoBancaria);
//		}
		return operacaoBancaria;
	}

	private CanalOperacaoBancaria salvarCanalAtendimento(Integer id, String nome) {
		CanalOperacaoBancaria canalAtendimento = new CanalOperacaoBancaria();
		canalAtendimento.setId(id);
		canalAtendimento.setNome(nome);
//		if(id == null){
//			canalAtendimento = canalAtendimentoRepository.save(canalAtendimento);
//		}
		return canalAtendimento;
	}

	public List<OperacaoBancariaPorCanalForm> lista() {
		
		List<OperacaoBancariaPorCanalForm> dadosForm = new ArrayList<>();
		
//		repository.findAll().forEach(action -> {
//			dadosForm.add(
//					OperacaoBancariaPorCanalForm.lista(
//							action.getId(), 
//							action.getOperacaoBancaria().getNome(), 
//							action.getCanalAtendimento().getNome()));
//		});
		
		return dadosForm;
	}
	
	public OperacaoBancariaPorCanalForm edita(Integer id) {
		return null;
		
//		OperacaoBancariaPorCanal operacaoBancariaPorCanal = repository.findOne(id);
//		
//		return OperacaoBancariaPorCanalForm.edita(
//				operacaoBancariaPorCanal.getId(),
//				operacaoBancariaPorCanal.getOperacaoBancaria().getId(), 
//				operacaoBancariaPorCanal.getCanalAtendimento().getId());
	}
	
	public List<OperacaoBancariaPorCanalVO> todas(){
		List<OperacaoBancariaPorCanalVO> todas = new ArrayList<>();
		todas.addAll(operacaoBancariaPorCanal.todos());
		return todas;
	}
}
