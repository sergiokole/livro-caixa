package br.com.sergio.web.controller.operacaocanal;

public class OperacaoBancariaPorCanalForm {
	
	private Integer operacaoBancariaPorCanalId;
	private Integer operacaoBancariaId;
	private String operacaoBancariaNome;
	private Integer canalAtendimentoId;
	private String canalAtendimentoNome;
	
	public OperacaoBancariaPorCanalForm() {}

	public static OperacaoBancariaPorCanalForm lista(
			Integer operacaoBancariaPorCanalId,
			String operacaoBancariaNome,
			String canalAtendimentoNome){
		
		OperacaoBancariaPorCanalForm form = new OperacaoBancariaPorCanalForm();
		form.setOperacaoBancariaPorCanalId(operacaoBancariaPorCanalId);
		form.setOperacaoBancariaNome(operacaoBancariaNome);
		form.setCanalAtendimentoNome(canalAtendimentoNome);
		return form;
	}
	
	public static OperacaoBancariaPorCanalForm edita(
			Integer operacaoBancariaPorCanalId,
			Integer operacaoBancariaId,
			Integer canalAtendimentoId){
		
		OperacaoBancariaPorCanalForm form = new OperacaoBancariaPorCanalForm();
		form.setOperacaoBancariaPorCanalId(operacaoBancariaPorCanalId);
		form.setOperacaoBancariaId(operacaoBancariaId);
		form.setCanalAtendimentoId(canalAtendimentoId);
		return form;
	}
	
	/**
	 * @return the operacaoBancariaPorCanalId
	 */
	public Integer getOperacaoBancariaPorCanalId() {
		return operacaoBancariaPorCanalId;
	}

	/**
	 * @param operacaoBancariaPorCanalId the operacaoBancariaPorCanalId to set
	 */
	public void setOperacaoBancariaPorCanalId(Integer operacaoBancariaPorCanalId) {
		this.operacaoBancariaPorCanalId = operacaoBancariaPorCanalId;
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
