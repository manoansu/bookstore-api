package pt.amane.supermarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pt.amane.supermarket.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

}
