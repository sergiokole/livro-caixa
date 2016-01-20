package br.com.sergio.app.model.vo.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class OperacaoBancariaPorCanalPK implements Serializable {

	private static final long serialVersionUID = -5812675957772872087L;

	@ManyToOne
	@JoinColumn(name="operacao_bancaria_id", nullable=false)
	private OperacaoBancaria operacaoBancaria;
	
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="canal_atendimento_id", nullable=false, insertable=true)
	private CanalAtendimento canalAtendimento;

	/**
	 * @return the operacaoBancaria
	 */
	public OperacaoBancaria getOperacaoBancaria() {
		return operacaoBancaria;
	}

	/**
	 * @param operacaoBancaria the operacaoBancaria to set
	 */
	public void setOperacaoBancaria(OperacaoBancaria operacaoBancaria) {
		this.operacaoBancaria = operacaoBancaria;
	}

	/**
	 * @return the canalAtendimento
	 */
	public CanalAtendimento getCanalAtendimento() {
		return canalAtendimento;
	}

	/**
	 * @param canalAtendimento the canalAtendimento to set
	 */
	public void setCanalAtendimento(CanalAtendimento canalAtendimento) {
		this.canalAtendimento = canalAtendimento;
	}

}
