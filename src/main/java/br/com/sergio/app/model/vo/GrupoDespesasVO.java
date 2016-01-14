package br.com.sergio.app.model.vo;

public class GrupoDespesasVO {
	
	private Integer id;
	
	private String nome;
	
	/**
	 * @param id
	 * @param nome
	 */
	public GrupoDespesasVO(
			Integer id, 
			String nome) {
		this.id = id;
		this.nome = nome;
	}

	/**
	 * @param nome
	 */
	public GrupoDespesasVO(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GrupoDespesasVO other = (GrupoDespesasVO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "GrupoDespesasVO [id=" + id + ", nome=" + nome + "]";
	}

	/**
	 * @return {@link GrupoDespesasVO} no formato JSON
	 */
	public String toJson() {
		return "{ id=" + id + ", nome=" + nome + "}";
	}
}
