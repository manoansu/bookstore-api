package pt.amane.bookstore.resources;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
//http://localhost:8080/categorias/1