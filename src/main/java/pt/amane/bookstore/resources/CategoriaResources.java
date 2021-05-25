package pt.amane.bookstore.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javassist.tools.rmi.ObjectNotFoundException;
import pt.amane.bookstore.domain.Categoria;
import pt.amane.bookstore.dtos.CategoriaDTO;
import pt.amane.bookstore.service.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResources {

	@Autowired
	private CategoriaService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable Integer id) throws ObjectNotFoundException {

		Categoria obj = service.findById(id); // pega id vindo da tela..
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping
	public ResponseEntity<java.util.List<CategoriaDTO>> findAll() {

		List<Categoria> list = service.findAll(); // pega todos os elementos de categoria..

		// converte a lista de categoria para tipo de lista DTO..
		List<CategoriaDTO> liDtos = list.stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());

		return ResponseEntity.ok().body(liDtos); // apenas retorna a lista de DTO..
	}

	@PostMapping
	public ResponseEntity<Categoria> create(@RequestBody Categoria obj) {

		obj = service.create(obj);

		// cria o URI de acesso para o novo objeto criado(ele gera diretamente o path
		// daquele obj)
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

		return ResponseEntity.created(uri).body(obj);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<CategoriaDTO> update(@PathVariable Integer id, @RequestBody CategoriaDTO oblDto)
			throws ObjectNotFoundException {

		Categoria newobj = service.create(id, oblDto);

		return ResponseEntity.ok().body(new CategoriaDTO(newobj));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) throws ObjectNotFoundException{
		service.delete(id);
		
		return ResponseEntity.noContent().build();
	}

}
//http://localhost:8080/categorias/1