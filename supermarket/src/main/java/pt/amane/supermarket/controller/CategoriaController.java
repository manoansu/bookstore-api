package pt.amane.supermarket.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.OptBoolean;

import pt.amane.supermarket.domain.Categoria;
import pt.amane.supermarket.exception.RecursoNaoEncontradoException;
import pt.amane.supermarket.repository.CategoriaRepository;
import pt.amane.supermarket.sevice.CategoriaService;

@RestController
@RequestMapping("/categorias") // link http://localhost:8080/categorias/listar
public class CategoriaController {
	
	@Autowired
	private CategoriaService cs;
	
	@Autowired
	private CategoriaRepository cr;
	
	//@GetMapping("listar") // GetMapping é um tipo de requisiçaõ utilizado para consulta.. e posse ser sem o param ("listar")
	@RequestMapping
	public List<Categoria> listar(){
		
		List<Categoria> list = cs.listar();
		return list;
	}
	
	@PostMapping //é o requestMaping com metodo de envio (inserir) RequestBody envia o objecto para o tipo json..
	public Categoria inserir(@RequestBody Categoria categoria) {
		
		Categoria catgoriaSalva = cr.save(categoria);
		return catgoriaSalva;
	}
	
	@DeleteMapping("{codigo}") // é o metodo de requestMapping que usa o metodo é deletar informação
	public Categoria excluir(@PathVariable Short codigo) {
		
		Optional<Categoria> categoria =  cr.findById(codigo);
		cr.delete(categoria.get());
		return categoria.get();
	}
	
	@PutMapping // é o metodo de requestMapping que usa o metodo é put informação
	public Categoria editar(@RequestBody Categoria categoria) {
		
	  Categoria categoriaEditar = cr.save(categoria);
	  return categoriaEditar;
		
	}
	
	@GetMapping("/{codigo}")
	public Categoria buscarPorCodigo(@PathVariable Short codigo) {
		
		//Optional<Categoria> resultado = cs.buscarPorCodigo(codigo); // ele nao retorna objecto mas sim coloca o Optional..
		//Categoria categoria = resultado.get(); // apenas retorna a informação e do Id para o objeto.
		try {
			return cs.buscarPorCodigo(codigo);
		} catch (RecursoNaoEncontradoException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria não encontrado", e);
		}
		
	}
}
