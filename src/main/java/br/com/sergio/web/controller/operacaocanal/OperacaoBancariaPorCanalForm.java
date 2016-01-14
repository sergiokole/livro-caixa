package br.com.sergio.web.controller.operacaocanal;

public class OperacaoBancariaPorCanalForm {
	
	private Integer operacaoBancariaId;
	private String operacaoBancariaNome;
	private Integer canalAtendimentoId;
	private String canalAtendimentoNome;
	
	/**
	 * @return the operacaoBancariaId
	 */
	public Integer getOperacaoBancariaId() {
		return operacaoBancariaId;
	}
	/**
	 * @param operacaoBancariaId the operacaoBancariaId to set
	 */
	public void setOperacaoBancariaId(Integer operacaoBancariaId) {
		this.operacaoBancariaId = operacaoBancariaId;
	}
	/**
	 * @return the operacaoBancariaNome
	 */
	public String getOperacaoBancariaNome() {
		return operacaoBancariaNome;
	}
	/**
	 * @param operacaoBancariaNome the operacaoBancariaNome to set
	 */
	public void setOperacaoBancariaNome(String operacaoBancariaNome) {
		this.operacaoBancariaNome = operacaoBancariaNome;
	}
	/**
	 * @return the canalAtendimentoId
	 */
	public Integer getCanalAtendimentoId() {
		return canalAtendimentoId;
	}
	/**
	 * @param canalAtendimentoId the canalAtendimentoId to set
	 */
	public void setCanalAtendimentoId(Integer canalAtendimentoId) {
		this.canalAtendimentoId = canalAtendimentoId;
	}
	/**
	 * @return the canalAtendimentoNome
	 */
	public String getCanalAtendimentoNome() {
		return canalAtendimentoNome;
	}
	/**
	 * @param canalAtendimentoNome the canalAtendimentoNome to set
	 */
	public void setCanalAtendimentoNome(String canalAtendimentoNome) {
		this.canalAtendimentoNome = canalAtendimentoNome;
	}

}
