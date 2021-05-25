package pt.amane.bookstore.dtos;

import java.io.Serializable;

import pt.amane.bookstore.domain.Categoria;

public class CategoriaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	private String descricao;

	public CategoriaDTO() {

	}

	public CategoriaDTO(Categoria cat) {
		super();
		this.id = cat.getId();
		this.nome = cat.getNome();
		this.descricao = cat.getDescricao();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
