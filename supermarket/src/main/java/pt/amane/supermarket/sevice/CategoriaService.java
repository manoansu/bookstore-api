package pt.amane.supermarket.sevice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pt.amane.supermarket.domain.Categoria;
import pt.amane.supermarket.exception.RecursoNaoEncontradoException;
import pt.amane.supermarket.repository.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository cr;
	
	public Categoria buscarPorCodigo(Short codigo) {
		
		Optional<Categoria> resultado = cr.findById(codigo); // ele nao retorna objecto mas sim coloca o Optional..
		
		if(resultado.isEmpty()) { // apenas retorna a informação e do Id para o objeto.
			throw new RecursoNaoEncontradoException();
		}
		Categoria categoria = resultado.get(); // apenas retorna a informação e do Id para o objeto.
		return categoria;
	}
	
	public List<Categoria> listar(){
		
		List<Categoria> resultado = cr.findAll();
		return resultado;
	}
}
