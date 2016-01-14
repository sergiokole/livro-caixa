package br.com.sergio.app.model.vo.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="operacao_bancaria_por_canal")
public class OperacaoBancariaPorCanal {

	@ManyToOne(targetEntity=OperacaoBancaria.class, cascade={CascadeType.ALL})
	private OperacaoBancaria operacaoBancaria;
	
	@ManyToOne(targetEntity=CanalAtendimento.class, cascade={CascadeType.ALL})
	private CanalAtendimento canalAtendimento;

	@Column
	private Date data;

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

	/**
	 * @return the data
	 */
	public Date getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(Date data) {
		this.data = data;
	}

}
