package steps;

import java.util.Map;

import entidades.Header;
import entidades.JsonPlaceHolder;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import massas.JsonPlaceHolderMassa;
import utils.RestUtils;

public class JsonPlaceHolderSteps {

	String url = "";
	String endpoint = "";
	String token = "";
	Header header;
	JsonPlaceHolder jsonPlaceHolder;
	
	@Dado("que seja preenchidos os campos do JsonPlaceHolder")
	public void queSejaPreenchidosOsCamposDoJsonPlaceHolder() {
		JsonPlaceHolderMassa.inicializaJsonPlaceHolderMassa();
		
		url = JsonPlaceHolderMassa.url;
		endpoint = JsonPlaceHolderMassa.endpoint;
		token = "Bearer " + JsonPlaceHolderMassa.token;
		header = JsonPlaceHolderMassa.header;
		jsonPlaceHolder = JsonPlaceHolderMassa.jsonPlaceHolder;
		
		header.setHeader("Authorization", token);
	}
	
	@Quando("forem alterados os campos do JsonPlaceHolder")
	public void foremAlteradosOsCamposDoJsonPlaceHolder(Map<String, Object> map) {
		jsonPlaceHolder.setNome(map.get("nome"));
		jsonPlaceHolder.setIdade(map.get("idade"));
	}

	@Quando("for realizado uma requisicao do tipo post do JsonPlaceHolder")
	public void forRealizadoUmaRequisicaoDoTipoPostDoJsonPlaceHolder() {
	    RestUtils.postRequest(endpoint, header.getHeader(), jsonPlaceHolder);
	}






}
