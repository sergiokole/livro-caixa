package br.com.sergio.app.model.vo.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="canal_atendimento")
public class CanalAtendimento {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column
	private String nome;
	
	@OneToMany
	private List<OperacaoBancariaPorCanal> operacoesBancariasPorCanal;

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
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the operacoesBancariasPorCanal
	 */
	public List<OperacaoBancariaPorCanal> getOperacoesBancariasPorCanal() {
		return operacoesBancariasPorCanal;
	}

	/**
	 * @param operacoesBancariasPorCanal the operacoesBancariasPorCanal to set
	 */
	public void setOperacoesBancariasPorCanal(List<OperacaoBancariaPorCanal> operacoesBancariasPorCanal) {
		this.operacoesBancariasPorCanal = operacoesBancariasPorCanal;
	} 

}
