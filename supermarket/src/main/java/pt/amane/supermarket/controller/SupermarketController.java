package pt.amane.supermarket.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * É anotaçção que diz q essa classe que gera o serviço para esta aplicação..
 * @author ansumane.mane
 * link: http://localhost:8080/supermarket/hello
 */
@RestController 
@RequestMapping("/supermarket") // /supermarket, informa na url que o esta usar a clase de serviço..
public class SupermarketController {
	
	@RequestMapping("/hello") // informa o nome que vai ser passado na URL..
	public String displayMensagem(){
		return "Hello worl";
	}
}
