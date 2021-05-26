package pt.amane.bookstore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pt.amane.bookstore.domain.Livro;
import pt.amane.bookstore.repositories.LivroRepository;
import pt.amane.bookstore.service.exceptions.ObjectNotFoundException;

@Service // injectar o livro resource
public class LivroService {

	@Autowired // faz a injecção com base de dados de dominio livro
	private LivroRepository lr;

	public Livro findById(Integer id) {

		Optional<Livro> obj = lr.findById(id); // pega o id de livro
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objecto não encontrado! id: " + id + " Tipo: " + Livro.class.getName()));
	}
}
