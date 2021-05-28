package pt.amane.bookstore.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import pt.amane.bookstore.domain.Livro;
import pt.amane.bookstore.dtos.LivroDTO;
import pt.amane.bookstore.service.LivroService;

//que o nosso endpoint /livros de diversas fontes, por Ex: qd fizemos o Front
// end vai rodar na porta 402 do angular.
@CrossOrigin(origins= {"*"}, maxAge = 4800, allowCredentials = "false") 
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

	// http://localhgost:8080/livros?categoria=1 ==> esse é url para listar
	// determinada categoria de um determinado livros
	@GetMapping
	public ResponseEntity<List<LivroDTO>> findAll(
			@RequestParam(value = "categoria", defaultValue = "0") Integer id_cat) {

		List<Livro> list = ls.findAll(id_cat);// retorana lista de livro de uma determinada categoria vindo da interface
												// livroRepository..

		// Converte a lista de livro para lista de livros..
		List<LivroDTO> listDto = list.stream().map(obj -> new LivroDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);

	}

	/**
	 * para atualizar preciso receber o id para fazer a busca na BD e verificar se
	 * object existe ou não. E tambem tenho que ter informação atualizada que vai
	 * vir no corpo de requisição que chamamos de requestBody sendo um objecto json
	 * do tipo livro nesse caso..
	 * 
	 * @param id
	 * @param obj
	 * @return
	 */
	@PutMapping(value = "/{id}") // endpoint id
	public ResponseEntity<Livro> update(@PathVariable Integer id, @Valid @RequestBody Livro obj) {

		Livro newObj = ls.update(id, obj); // o objecto newobj recebe o livro atualizado na classe LivroSewrvice..

		// uma vez que newObj veio atualizado de classe LivroService, é so retornar o
		// newObj.
		return ResponseEntity.ok().body(newObj);

	}

	@PatchMapping(value = "/{id}") // endpoint id
	public ResponseEntity<Livro> updatePatch(@PathVariable Integer id, @Valid @RequestBody Livro obj) {

		Livro newObj = ls.update(id, obj); // o objecto newobj recebe o livro atualizado na classe LivroSewrvice..

		// uma vez que newObj veio atualizado de classe LivroService, é so retornar o
		// newObj.
		return ResponseEntity.ok().body(newObj);
	}

	@PostMapping
	public ResponseEntity<Livro> create(@RequestParam(value = "categoria", defaultValue = "0") Integer id_cat,
			@Valid @RequestBody Livro obj) {

		Livro newobj = ls.create(id_cat, obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/livros/{id}")
				.buildAndExpand(newobj.getId()).toUri();// retorna o URI para user..
		return ResponseEntity.created(uri).build();
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		ls.delete(id);
		return ResponseEntity.noContent().build(); // retorna nehum conteudo..
	}
}
