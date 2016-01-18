package br.com.sergio.app.model.vo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="operacao_bancaria_por_canal")
public class OperacaoBancariaPorCanal {

	@EmbeddedId
	private OperacaoBancariaPorCanalPK id;

	@Column
	private Date data;

	/**
	 * @return the id
	 */
	public OperacaoBancariaPorCanalPK getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(OperacaoBancariaPorCanalPK id) {
		this.id = id;
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