package pt.amane.bookstore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import pt.amane.bookstore.service.DBService;

@Configuration
@Profile("test") //informa no applicatio.proprieties que esse vai ser visto como teste..
public class TesteConfig {
	
	@Autowired
	private DBService deDbService;
	
	@Bean // identifica q esse metodo suba sempre..
	public void instanciaBaseDados() {
		this.deDbService.instanciaBaseDados();
	}

}
