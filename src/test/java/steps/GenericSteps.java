package steps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.cucumber.java.pt.Entao;
import utils.RestUtils;

public class GenericSteps {

	@Entao("o sistema devolve o campo {string} com o valor {string}")
	public void oSistemaDevolveOCampoComOValor(String key, String value) {
	    assertEquals(value, RestUtils.getResponse(key));
	}
	
	@Entao("o sistema devolve o satus {int}")
	public void oSistemaDevolveOSatus(Integer statusCode) {
		assertEquals(statusCode, RestUtils.getStatusCode());
	}
	
	@Entao("o campo {string} devera retornar com {int} caracteres")
	public void oCampoDeveraRetornarComCaracteres(String key, Integer qtd) {
	    int tamanho = RestUtils.getResponse(key).toString().length();
	    assertEquals( qtd, tamanho, "Quantidade incorreta: ");
	}
}
