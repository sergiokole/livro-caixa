package br.com.sergio.app.model.jpa;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.sergio.app.constants.TipoOperacaoBancaria;

@Entity
@Table(name="operacao_bancaria")
public class OperacaoBancaria implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5353863692844134723L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String nome;
	
	@Column
	@Enumerated(EnumType.ORDINAL)
	private TipoOperacaoBancaria tipo;
	
	@Column
	private String apelido;

	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="operacao_bancaria_por_canal", 
			joinColumns={@JoinColumn(name="operacao_bancaria_id", referencedColumnName="id")},
			inverseJoinColumns={@JoinColumn(name="canal_operacao_bancaria_id", referencedColumnName="id")})
	private List<CanalOperacaoBancaria> canais;

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
	public List<CanalOperacaoBancaria> getCanais() {
		return canais;
	}

	/**
	 * @param canais the canais to set
	 */
	public void setCanais(List<CanalOperacaoBancaria> canais) {
		this.canais = canais;
	}
}
