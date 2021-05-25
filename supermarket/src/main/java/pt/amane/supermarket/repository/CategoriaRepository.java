package pt.amane.supermarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pt.amane.supermarket.domain.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Short>{

}
