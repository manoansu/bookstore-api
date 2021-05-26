package pt.amane.bookstore.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pt.amane.bookstore.domain.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer>{

	//gera um sql q seleciona todos os objeto do tipo livro salvo na BD e ordena por titulo..
	@Query("SELECT obj from Livro obj WHERE obj.categoria.id = :id_cat ORDER BY titulo")
	List<Livro> findAllByCategoria(@Param(value = "id_cat") Integer id_cat);

}
