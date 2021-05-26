package pt.amane.bookstore.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	/**
	 * para atualizar preciso receber o id para fazer a busca na BD e verificar se object existe ou não.
	 * E tambem tenho que ter informação atualizada que vai vir no corpo de requisição que 
	 * chamamos de requestBody sendo um objecto json do tipo livro nesse caso.. 
	 * @param id
	 * @param obj
	 * @return
	 */
	@PutMapping(value = "/{id}")  // endpoint id
	public ResponseEntity<Livro> update(@PathVariable Integer id, @RequestBody Livro obj){
		
		Livro newObj = ls.update(id,obj); // o objecto newobj recebe o livro atualizado na classe LivroSewrvice..
		
		// uma vez que newObj veio atualizado de classe LivroService, é so retornar o newObj.
		return ResponseEntity.ok().body(newObj);
		
	}
	
	@PatchMapping(value = "/{id}")  // endpoint id
	public ResponseEntity<Livro> updatePatch(@PathVariable Integer id, @RequestBody Livro obj){
		
		Livro newObj = ls.update(id,obj); // o objecto newobj recebe o livro atualizado na classe LivroSewrvice..
		
		// uma vez que newObj veio atualizado de classe LivroService, é so retornar o newObj.
		return ResponseEntity.ok().body(newObj);
		
	}
}
