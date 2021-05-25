package pt.amane.bookstore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pt.amane.bookstore.domain.Categoria;
import pt.amane.bookstore.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository cr;
	
	public Categoria findById(Integer id) {
		Optional<Categoria> obj = cr.findById(id);
		return obj.orElse(null);
		
	}

}
