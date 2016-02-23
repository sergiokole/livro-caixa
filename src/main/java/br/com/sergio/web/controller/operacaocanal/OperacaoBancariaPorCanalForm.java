package br.com.sergio.web.controller.operacaocanal;

import java.util.List;

import br.com.sergio.app.constants.TipoOperacaoBancaria;

public class OperacaoBancariaPorCanalForm {
	
	private Integer id;
	private String nome;
	private TipoOperacaoBancaria tipo;
	private String apelido;
	private List<Integer> canais;
	
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
	 * @return the tipo
	 */
	public TipoOperacaoBancaria getTipo() {
		return tipo;
	}
	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(TipoOperacaoBancaria tipo) {
		this.tipo = tipo;
	}
	/**
	 * @return the apelido
	 */
	public String getApelido() {
		return apelido;
	}
	/**
	 * @param apelido the apelido to set
	 */
	public void setApelido(String apelido) {
		this.apelido = apelido;
	}
	/**
	 * @return the canais
	 */
	public List<Integer> getCanais() {
		return canais;
	}
	/**
	 * @param canais the canais to set
	 */
	public void setCanais(List<Integer> canais) {
		this.canais = canais;
	}
	
}
