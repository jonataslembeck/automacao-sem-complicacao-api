package steps;

import entidades.Login;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import massas.JsonPlaceHolderMassa;
import utils.RestUtils;

public class TokenSteps {

	String url = "";
	String endpoint = "";
	String token = "";
	Login login;

	@Dado("que sejam preenchidos os campos para autenticacao")
	public void queSejamPreenchidosOsCamposParaAutenticacao() {
		JsonPlaceHolderMassa.inicializaJsonPlaceHolderMassa();
		
		url = JsonPlaceHolderMassa.url;
		endpoint = JsonPlaceHolderMassa.endpoint;
		login = JsonPlaceHolderMassa.login;

		RestUtils.setBaseUri(url);
	}

	@Quando("for realizado uma requisicao do tipo post do token")
	public void forRealizadoUmaRequisicaoDoTipoPostDoToken() {
		RestUtils.postRequest(endpoint, login);
	}

	@Entao("o valor do token e armazenado")
	public void oValorDoTokenEArmazenado() {
		token = RestUtils.getResponse("token").toString();
		JsonPlaceHolderMassa.token = token;
	}

	@Quando("for realizado uma requisicao do tipo post do token e o token e armazenado")
	public void forRealizadoUmaRequisicaoDoTipoPostDoTokenEOTokenEArmazenado() {
	    this.queSejamPreenchidosOsCamposParaAutenticacao();
	    this.forRealizadoUmaRequisicaoDoTipoPostDoToken();
	    this.oValorDoTokenEArmazenado();
	}



}
