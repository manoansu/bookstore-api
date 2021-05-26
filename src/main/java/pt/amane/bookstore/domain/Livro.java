package pt.amane.bookstore.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

//@AllArgsConstructor
//@NoArgsConstructor
@Entity
public class Livro implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty(message = "O campo TITULO é necessario")
	@Length(min = 3, max = 50, message = "O campo TITULO deve conter entre 3 e 50 caracteres")
	private String titulo;
	
	@NotEmpty(message = "O campo NOME DO AUTOR é necessario")
	@Length(min = 3, max = 50, message = "O campo NOME DO AUTOR deve conter entre 3 e 50 caracteres")
	private String autor;
	
	@NotEmpty(message = "O campo TESTO é necessario")
	@Length(min = 10, max = 2000000, message = "O campo TESTO deve conter entre 10 e 2.000.000 caracteres")
	private String testo;
	
	@JsonIgnore // isso nos ajuda a evitar trazer os dados serializble..
	@ManyToOne
	@JoinColumn(name = "categoria_id", nullable = false)
	private Categoria categoria;
	
	public Livro() {}
	
	public Livro(Integer id, String titulo, String autor, String testo, Categoria categoria) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.testo = testo;
		this.categoria = categoria;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getTesto() {
		return testo;
	}

	public void setTesto(String testo) {
		this.testo = testo;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}	
}
