package pt.amane.bookstore.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.amane.bookstore.domain.Categoria;
import pt.amane.bookstore.service.CategoriaService;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResources {
	
	@Autowired
	private CategoriaService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable Integer id){
		
		Categoria obj = service.findById(id); // pega id vindo da tela..
		return ResponseEntity.ok().body(obj);
	}

}
//http://localhost:8080/categorias/1