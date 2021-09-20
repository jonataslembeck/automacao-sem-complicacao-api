package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import utils.RestUtils;

public class CepsSteps {
	
	String url = "http://viacep.com.br/ws/";
	String endpoint;
	
	@Dado("que seja recebido um cep valido com o valor {string}")
	public void queSejaRecebidoUmCepValidoComOValor(String cep) {
	    RestUtils.setBaseUri(url);
	    endpoint = cep + "/json";
	}

	@Quando("seja realizado uma requisicao do tipo get do cep")
	public void sejaRealizadoUmaRequisicaoDoTipoGetDoCep() {
	    RestUtils.getRequest(endpoint);
	}

}