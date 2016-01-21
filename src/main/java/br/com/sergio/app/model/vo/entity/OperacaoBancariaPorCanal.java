package br.com.sergio.app.model.vo.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="operacao_bancaria_por_canal")
public class OperacaoBancariaPorCanal implements Serializable {

	private static final long serialVersionUID = -5812675957772872087L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name="operacao_bancaria_id")
	private OperacaoBancaria operacaoBancaria;
	
	@ManyToOne
	@JoinColumn(name="canal_atendimento_id")
	private CanalAtendimento canalAtendimento;
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

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
