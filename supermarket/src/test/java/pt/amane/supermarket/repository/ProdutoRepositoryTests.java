package pt.amane.supermarket.repository;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import pt.amane.supermarket.domain.Produto;

@SpringBootTest
public class ProdutoRepositoryTests {
	
	@Autowired
	private ProdutoRepository pr;
	
	@Test
	public void inserir() {
		
		Produto p = new Produto(null,
				"coca cola",
				Byte.valueOf("15"),
				BigDecimal.valueOf(10.50),
				LocalDate.of(2021, 5, 20));
		
		Produto p1 = new Produto(null,
				"Heineken",
				Byte.valueOf("15"),
				BigDecimal.valueOf(8.00),
				LocalDate.of(2021, 5, 30));
		
		pr.save(p);
		pr.save(p1);
		
		System.out.println(p);
		System.out.println(p1);
	}

}
