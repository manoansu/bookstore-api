package pt.amane.bookstore.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.amane.bookstore.domain.Livro;
import pt.amane.bookstore.service.LivroService;

@RestController // informa o spring que é um controlador rest..
@RequestMapping(value = "/livros")
public class LivroResource {

	@Autowired
	private LivroService ls;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Livro> findById(@PathVariable Integer id) {

		Livro obj = ls.findById(id); // chama o metodo de serviço da classe LivroService findById(id)
		return ResponseEntity.ok().body(obj); // apenas retorna o objecto livro que vem con o tratamento de excessão
												// null ou retorna o id
	}
}
