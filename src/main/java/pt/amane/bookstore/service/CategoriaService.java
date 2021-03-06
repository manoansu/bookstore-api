package pt.amane.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import pt.amane.bookstore.domain.Categoria;
import pt.amane.bookstore.dtos.CategoriaDTO;
import pt.amane.bookstore.exception.ObjectNotFoundException;
import pt.amane.bookstore.repositories.CategoriaRepository;
import pt.amane.bookstore.resource.exceptions.DataIntegratedViolationException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository cr;

	public Categoria findById(Integer id) {

		Optional<Categoria> obj = cr.findById(id); // pega o id vindo da classe do pacote resource..

		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objecto não encontrado! id: " + id + " Tipo: " + Categoria.class.getName()));
	}

	public List<Categoria> findAll() {
		return cr.findAll();
	}

	public Categoria create(Categoria obj) {
		obj.setId(null); // facilita a não subescrever o id qd vais criar o novo objecto.
		return cr.save(obj);
	}

	public Categoria create(Integer id, CategoriaDTO oblDto) throws ObjectNotFoundException {

		Categoria obj = findById(id); // verifica se a id existe..
		obj.setNome(oblDto.getNome());
		obj.setDescricao(obj.getDescricao());

		return cr.save(obj);
	}

	public void delete(Integer id) throws ObjectNotFoundException {

		findById(id);
		try {
			cr.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegratedViolationException("Categoria não pode ser removido, possui livros associados!");
		}
	}

}
