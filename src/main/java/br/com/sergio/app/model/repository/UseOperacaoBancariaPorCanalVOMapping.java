package br.com.sergio.app.model.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import br.com.sergio.app.model.vo.OperacaoBancariaPorCanalVO;

@Component
public class UseOperacaoBancariaPorCanalVOMapping {
	
	private final String ALL = "select b.id as operacaoBancariaId,b.nome as operacaoBancariaNome,"
			+ "c.id as canalOperacaoBancariaId,c.nome as canalOperacaoBancariaNome "
			+ "from operacao_bancaria_por_canal a "
			+ "inner join operacao_bancaria b on a.operacao_bancaria_id = b.id "
			+ "inner join canal_operacao_bancaria c on a.canal_operacao_bancaria_id = c.id";
	
	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<OperacaoBancariaPorCanalVO> todos(){
		
		List<OperacaoBancariaPorCanalVO> results = em.createNativeQuery(ALL, "OperacaoBancariaPorCanalVOMapping").getResultList();
		
		return results;
	}

}
