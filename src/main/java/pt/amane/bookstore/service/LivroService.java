package pt.amane.bookstore.service;

import java.util.List;
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
	
	@Autowired
	private CategoriaService cr;

	public Livro findById(Integer id) {

		Optional<Livro> obj = lr.findById(id); // pega o id de livro
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objecto não encontrado! id: " + id + " Tipo: " + Livro.class.getName()));
	}

	public List<Livro> findAll(Integer id_cat) {
		cr.findById(id_cat); //verifica se nao ide nao exite retorna o erroda excessão tratado no metodo findById().. 
		return lr.findAllByCategoria(id_cat); 
	}
}
