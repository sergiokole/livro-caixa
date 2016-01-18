package br.com.sergio.app.service.crud.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sergio.app.model.repository.crud.OperacaoBancariaPorCanalRepository;
import br.com.sergio.app.model.vo.entity.OperacaoBancariaPorCanal;
import br.com.sergio.app.service.crud.OperacaoBancariaPorCanalService;

@Service
public class OperacaoBancariaPorCanalServiceImpl implements OperacaoBancariaPorCanalService {
	
	@Autowired
	private OperacaoBancariaPorCanalRepository repository;

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
//		read().forEach(obc -> {
//			map.put(obc.getPk().getOperacaoBancaria().getId(), obc.getPk().getOperacaoBancaria().getNome());
//		});
		
		return map;
	}

	@Override
	public Map<Integer, String> listaCanalAtendimento() {
		Map<Integer,String> map = new HashMap<>();
//		read().forEach(obc -> {
//			map.put(obc.getPk().getCanalAtendimento().getId(), obc.getPk().getCanalAtendimento().getNome());
//		});
		
		return map;
	}
	
}
