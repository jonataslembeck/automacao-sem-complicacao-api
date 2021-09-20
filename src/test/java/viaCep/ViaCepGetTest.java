package viaCep;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import utils.RestUtils;

public class ViaCepGetTest {
	
	String url = "http://viacep.com.br/ws/";
	
	@BeforeEach
	public void setUp() {
		RestUtils.setBaseUri(url);
		String cep = "80420120";
		RestUtils.getRequest(cep + "/json");
	}
	
	@Test
	public void validaLogradouro() {
		assertEquals("Rua Doutor Pedrosa", RestUtils.getResponse("logradouro"));
	}
	
	@Test
	public void validaLocalidade() {
		assertEquals("Curitiba", RestUtils.getResponse("localidade"));
	}
	
	@Test
	public void getStatusEndereco() {
		validaStatusCode(200);
	}
	
	private static void validaStatusCode(int status) {
		assertEquals(status, RestUtils.getStatusCode());
	}
	



	

}
