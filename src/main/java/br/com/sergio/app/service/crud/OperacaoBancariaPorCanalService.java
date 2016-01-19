package br.com.sergio.app.service.crud;

import java.util.List;
import java.util.Map;

import br.com.sergio.app.model.vo.entity.OperacaoBancariaPorCanal;
import br.com.sergio.web.controller.operacaocanal.OperacaoBancariaPorCanalForm;

public interface OperacaoBancariaPorCanalService extends BaseService<OperacaoBancariaPorCanal, Integer> {
	
	public Map<Integer, String> listaOperacaoBancaria();
	
	public Map<Integer, String> listaCanalAtendimento();
	
	public void salvar(Integer operacaoBancariaId,
			String operacaoBancariaNome,
			Integer canalAtendimentoId,
			String canalAtendimentoNome);
	
	List<OperacaoBancariaPorCanalForm> lista();

}
