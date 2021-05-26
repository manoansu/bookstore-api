package pt.amane.bookstore.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pt.amane.bookstore.domain.Livro;
import pt.amane.bookstore.dtos.LivroDTO;
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
	
	//http://localhgost:8080/livros?categoria=1 ==> esse é url para listar determinada categoria de um determinado livros
	@GetMapping 
	public ResponseEntity<List<LivroDTO>> findAll(@RequestParam(value = "categoria", defaultValue="0") Integer id_cat){
		
		List<Livro> list = ls.findAll(id_cat);// retorana lista de livro de uma determinada categoria vindo da interface livroRepository..
		
		//Converte a lista de livro  para lista de livros..
		List<LivroDTO> listDto = list.stream().map(obj ->new LivroDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
		
	}
}
