package pt.amane.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pt.amane.bookstore.domain.Categoria;
import pt.amane.bookstore.domain.Livro;
import pt.amane.bookstore.repositories.LivroRepository;
import pt.amane.bookstore.service.exceptions.ObjectNotFoundException;

@Service // injectar o livro resource
public class LivroService {

	@Autowired // faz a injecção com base de dados de dominio livro
	private LivroRepository lr;

	@Autowired
	private CategoriaService cs;

	public Livro findById(Integer id) {

		Optional<Livro> obj = lr.findById(id); // pega o id de livro
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objecto não encontrado! id: " + id + " Tipo: " + Livro.class.getName()));
	}

	public List<Livro> findAll(Integer id_cat) {
		cs.findById(id_cat); // verifica se nao ide nao exite retorna o erroda excessão tratado no metodo
								// findById()..
		return lr.findAllByCategoria(id_cat);
	}

	public Livro update(Integer id, Livro obj) {
		Livro newObj = findById(id); // precisamos verificar se esse id existe ou nao, e tb traz nos id desatualizado
										// caso existe
		updateData(newObj,obj);
		return lr.save(newObj); // apenas chama o objeto LivroRepository e salva o objecto atualizado
	}

	/**
	 * esse metodo é privado e só vai ser usado nessa classe..
	 * E é delegado para atualizar os dados de entidade livro para nao ter muitos codigos no mesmo metodo..
	 * @param newObj
	 * @param obj
	 */
	private void updateData(Livro newObj, Livro obj) {
		newObj.setAutor(obj.getAutor());
		newObj.setTitulo(obj.getTitulo());
		newObj.setTesto(obj.getTesto());
		
	}

	public Livro create(Integer id_cat, Livro obj) {
		obj.setId(null); // evita criar o id repitido
		Categoria cat = cs.findById(id_cat); // cerifica se a categoria existe na base de dados, o metodo findById() trata disso.
		obj.setCategoria(cat);
		return lr.save(obj);
	}
}
