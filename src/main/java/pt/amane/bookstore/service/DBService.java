package pt.amane.bookstore.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pt.amane.bookstore.domain.Categoria;
import pt.amane.bookstore.domain.Livro;
import pt.amane.bookstore.repositories.CategoriaRepository;
import pt.amane.bookstore.repositories.LivroRepository;

@Service
public class DBService {
	
	@Autowired
	private CategoriaRepository cr;
	
	@Autowired
	private LivroRepository lr;
	
	public void instanciaBaseDados() {
		
		Categoria cat1 = new Categoria(null, "Informatica", "Livro de TI");
		Categoria cat2 = new Categoria(null, "ficção cientifica", "ficção cientifica");
		Categoria cat3 = new Categoria(null, "Biografias", "Livro de Biografia");
		
		Livro l1 = new Livro(null, "Clean code", "Robert Marting", "Lorem Ipson", cat1);
		Livro l2 = new Livro(null, "Engenharia de software", "Lewis V. Costner", "Lorem Ipson", cat1);
		Livro l3 = new Livro(null, "The time Machine", "M.C.Wells", "Lorem Ipson", cat2);
		Livro l4 = new Livro(null, "The war of worlds", "M:C:Wells", "Lorem Ipson", cat2);
		Livro l5 = new Livro(null, "1,Robot", "Issack Asimov", "Lorem Ipson", cat2);
		
		cat1.getLivros().addAll(Arrays.asList(l1,l2));
		cat2.getLivros().addAll(Arrays.asList(l3,l4,l5));
		
				
		this.cr.saveAll(Arrays.asList(cat1,cat2,cat3));// consegue salvar varias categorias ao mesmo tempo separado por virgula
		this.lr.saveAll(Arrays.asList(l1,l2,l3,l4,l5));// consegue salvar varias categorias ao mesmo tempo separado por virgula
		
	}

}
