package br.com.sergio.app.service.crud.impl;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
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
import br.com.sergio.app.model.vo.entity.OperacaoBancariaPorCanalPK;
import br.com.sergio.app.service.crud.OperacaoBancariaPorCanalService;

@Service
public class OperacaoBancariaPorCanalServiceImpl implements OperacaoBancariaPorCanalService {
	
	@Autowired
	private OperacaoBancariaPorCanalRepository repository;
	
	@Autowired
	private OperacaoBancariaRepository operacaoBancariaRepository;
	
	@Autowired
	private CanalAtendimentoRepository canalAtendimentoRepository;

	@Override
	public OperacaoBancariaPorCanal create(OperacaoBancariaPorCanal create) {
		return repository.save(create);
	}

	@Override
	public Collection<OperacaoBancariaPorCanal> read() {
		return repository.findAll();
	}

	@Override
	public OperacaoBancariaPorCanal read(Integer id) {
		return repository.findOne(id);
	}

	@Override
	public OperacaoBancariaPorCanal update(OperacaoBancariaPorCanal update) {
		return repository.save(update);
	}

	@Override
	public void delete(Integer id) {
		repository.delete(id);
	}

	@Override
	public Map<Integer, String> listaOperacaoBancaria() {
		Map<Integer,String> map = new HashMap<>();
		operacaoBancariaRepository.findAll().forEach(entidade -> {
			map.put(entidade.getId(), entidade.getNome());
		});
		return map;
	}

	@Override
	public Map<Integer, String> listaCanalAtendimento() {
		Map<Integer,String> map = new HashMap<>();
		canalAtendimentoRepository.findAll().forEach(entidade -> {
			map.put(entidade.getId(), entidade.getNome());
		});
		return map;
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public void salvar(
			Integer operacaoBancariaId, 
			String operacaoBancariaNome, 
			Integer canalAtendimentoId,
			String canalAtendimentoNome) {
		
		CanalAtendimento canalAtendimento = new CanalAtendimento();
		canalAtendimento.setId(canalAtendimentoId);
		canalAtendimento.setNome(canalAtendimentoNome);
		
		OperacaoBancaria operacaoBancaria = new OperacaoBancaria();
		operacaoBancaria.setId(operacaoBancariaId);
		operacaoBancaria.setNome(operacaoBancariaNome);
		
		OperacaoBancariaPorCanalPK id = new OperacaoBancariaPorCanalPK();
		id.setOperacaoBancaria(operacaoBancaria);
		id.setCanalAtendimento(canalAtendimento);
		
		OperacaoBancariaPorCanal operacaoBancariaPorCanal = new OperacaoBancariaPorCanal();
		operacaoBancariaPorCanal.setId(id);
		operacaoBancariaPorCanal.setData(new Date());
		
		repository.save(operacaoBancariaPorCanal);
	}
	
}
