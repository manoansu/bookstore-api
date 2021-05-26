package pt.amane.bookstore.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import pt.amane.bookstore.domain.Categoria;

public class CategoriaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	@NotEmpty(message = "O campo NOME é necessario")
	@Length(min = 3, max = 50, message = "O campo NOME deve conter entre 3 e 50 caracteres")
	private String nome;

	@NotEmpty(message = "O campo DESCRIÇÂO é necessario")
	@Length(min = 3, max = 50, message = "O campo DESCRIÇÂO deve conter entre 3 e 100 caracteres")
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
