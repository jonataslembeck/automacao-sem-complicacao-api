package steps;

import java.util.LinkedHashMap;

import entidades.Header;
import entidadesMap.JsonPlaceHolderMap;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import massas.JsonPlaceHolderMapMassa;
import utils.RestUtils;

public class JsonPlaceHolderMapSteps {

	String url = "";
	String endpoint = "";
	String token = "";
	Header header;
	JsonPlaceHolderMap jsonPlaceHolderMap;
	
	@Dado("que seja preenchidos os campos do JsonPlaceHolderMap")
	public void queSejaPreenchidosOsCamposDoJsonPlaceHolderMap() {
		JsonPlaceHolderMapMassa.inicializaJsonPlaceHolderMapMassa();
		
		url = JsonPlaceHolderMapMassa.url;
		endpoint = JsonPlaceHolderMapMassa.endpoint;
		token = "Bearer " + JsonPlaceHolderMapMassa.token;
		header = JsonPlaceHolderMapMassa.header;
		jsonPlaceHolderMap = JsonPlaceHolderMapMassa.jsonPlaceHolder;
		
		RestUtils.setBaseUri(url);
		header.setHeader("Authorization", token);
	}

	@Quando("forem alterados os campos do JsonPlaceHolderMap")
	public void foremAlteradosOsCamposDoJsonPlaceHolderMap(LinkedHashMap<String, Object> map) {
		jsonPlaceHolderMap.setJsonPlaceHolderMap(map);
	}

	@Quando("for realizado uma requisicao do tipo post do JsonPlaceHolderMap")
	public void forRealizadoUmaRequisicaoDoTipoPostDoJsonPlaceHolderMap() {
		 RestUtils.postRequest(endpoint, header.getHeader(), jsonPlaceHolderMap.getJsonPlaceHolderMap());
	}
	
}