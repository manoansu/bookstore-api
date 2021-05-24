package pt.amane.bookstore;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import pt.amane.bookstore.domain.Categoria;
import pt.amane.bookstore.domain.Livro;
import pt.amane.bookstore.repositories.CategoriaRepository;
import pt.amane.bookstore.repositories.LivroRepository;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository cr;
	
	@Autowired
	private LivroRepository lr;

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat = new Categoria(null, "Informatica", "Livro de TI");
		
		Livro livro = new Livro(null, "Clean code", "Robert Marting", "Lorem Ipson", cat);
		
		cat.getLivros().addAll(Arrays.asList(livro));
		
		System.out.println("Categoria: " + cat + "\n Livros: " + livro);
		
		this.cr.saveAll(Arrays.asList(cat));// consegue salvar varias categorias ao mesmo tempo separado por virgula
		this.lr.saveAll(Arrays.asList(livro));// consegue salvar varias categorias ao mesmo tempo separado por virgula
		
	}

}
