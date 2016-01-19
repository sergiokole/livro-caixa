package br.com.sergio.web.controller.operacaocanal;

public class OperacaoBancariaPorCanalForm {
	
	private Integer operacaoBancariaId;
	private String operacaoBancariaNome;
	private Integer canalAtendimentoId;
	private String canalAtendimentoNome;
	
	public OperacaoBancariaPorCanalForm() { }
	
	public OperacaoBancariaPorCanalForm(
			Integer operacaoBancariaId, String operacaoBancariaNome,
			Integer canalAtendimentoId, String canalAtendimentoNome) {
		this.operacaoBancariaId = operacaoBancariaId;
		this.operacaoBancariaNome = operacaoBancariaNome;
		this.canalAtendimentoId = canalAtendimentoId;
		this.canalAtendimentoNome = canalAtendimentoNome;
	}
	
	public static OperacaoBancariaPorCanalForm edita(
			Integer operacaoBancariaId, 
			Integer canalAtendimentoId){
		 
		 return new OperacaoBancariaPorCanalForm(operacaoBancariaId, null, canalAtendimentoId, null);
	}

	public Integer getOperacaoBancariaId() {
		return operacaoBancariaId;
	}

	public String getOperacaoBancariaNome() {
		return operacaoBancariaNome;
	}

	public Integer getCanalAtendimentoId() {
		return canalAtendimentoId;
	}

	public String getCanalAtendimentoNome() {
		return canalAtendimentoNome;
	}
	
	public String getDescricao(){
		return operacaoBancariaNome + " por " + canalAtendimentoNome;
	}
	
}
