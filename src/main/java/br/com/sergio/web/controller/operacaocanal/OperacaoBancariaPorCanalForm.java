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
		 
		 OperacaoBancariaPorCanalForm form = new OperacaoBancariaPorCanalForm();
		 form.setCanalAtendimentoId(canalAtendimentoId);
		 form.setOperacaoBancariaId(operacaoBancariaId);
		 return form;
	}
	
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

	public String getDescricao(){
		return operacaoBancariaNome + " por " + canalAtendimentoNome;
	}
	
}
