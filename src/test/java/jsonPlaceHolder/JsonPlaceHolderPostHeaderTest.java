package jsonPlaceHolder;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.junit.jupiter.api.Test;

import entidades.Documento;
import entidades.Header;
import entidades.JsonPlaceHolder;
import entidades.Login;
import entidadesMap.JsonPlaceHolderMap;
import entidadesMap.LoginMap;
import massas.JsonPlaceHolderMapMassa;
import massas.JsonPlaceHolderMassa;
import utils.RestUtils;

public class JsonPlaceHolderPostHeaderTest {
	
	@Test
	public void postHeaderTokenMapMassaTest() {
		LoginMap login = JsonPlaceHolderMapMassa.login;
		RestUtils.setBaseUri(JsonPlaceHolderMapMassa.url);
		RestUtils.postRequest(JsonPlaceHolderMapMassa.endpoint, login.getLoginMap());
		
		JsonPlaceHolderMapMassa.token = RestUtils.getResponse("token").toString();
		JsonPlaceHolderMapMassa.addDocumentos();
		
		Header header = JsonPlaceHolderMapMassa.header;
		header.setHeader("Authorization", JsonPlaceHolderMapMassa.token);
		
		JsonPlaceHolderMap json = JsonPlaceHolderMapMassa.jsonPlaceHolder;		
		RestUtils.postRequest(JsonPlaceHolderMapMassa.endpoint, header.getHeader(), json.getJsonPlaceHolderMap());
		
		assertEquals("jonatas", RestUtils.getResponse("nome"));	
		assertEquals(201, RestUtils.getStatusCode());
	}
	
	@Test
	public void postHeaderTokenMassaTest() {
		Login login = JsonPlaceHolderMassa.login;
		RestUtils.setBaseUri(JsonPlaceHolderMassa.url);
		RestUtils.postRequest(JsonPlaceHolderMassa.endpoint, login);
		
		JsonPlaceHolderMassa.token = RestUtils.getResponse("token").toString();
		JsonPlaceHolderMassa.addDocumentos();
		
		Header header = JsonPlaceHolderMassa.header;
		header.setHeader("Authorization", JsonPlaceHolderMassa.token);
		
		JsonPlaceHolder json = JsonPlaceHolderMassa.jsonPlaceHolder;		
		RestUtils.postRequest(JsonPlaceHolderMassa.endpoint, header.getHeader(), json);
		
		assertEquals("jonatas", RestUtils.getResponse("nome"));	
		assertEquals(201, RestUtils.getStatusCode());
	}
	
	@Test
	public void postHeaderTokenClassTest() {
		Login login = new Login("jonatas", "123456", "e5jYWl4QAj4B8ezTg");
		
		RestUtils.setBaseUri("https://jsonplaceholder.typicode.com");
		RestUtils.postRequest("/posts", login);
		
		String token = RestUtils.getResponse("token").toString();
		
		Documento documento = new Documento("cpf", "7897845465465");
		List<Documento> documentos = new ArrayList<>();
		documentos.add(documento);
		
		JsonPlaceHolder json = new JsonPlaceHolder("jonatas", 29, documentos);
		
		//LinkedHashMap<String, String> header = new LinkedHashMap<>();
		//header.put("Authorization", token);
		//RestUtils.postRequest("/posts", header, json);
		
		// Com classe
		Header header = new Header(token);
		RestUtils.postRequest("/posts", header.getHeader(), json);
		
		assertEquals("jonatas", RestUtils.getResponse("nome"));		
		assertEquals(201, RestUtils.getStatusCode());
	}
	
	@Test
	public void postHeaderTokenMapTest() {
		LinkedHashMap<String, Object> json = new LinkedHashMap<>();
		json.put("usuario", "jonatas");
		json.put("senha", "123456");
		json.put("token", "e5jYWl4QAj4B8ezTg");
		
		RestUtils.setBaseUri("https://jsonplaceholder.typicode.com");
		RestUtils.postRequest("/posts", json);
		
		String token = "Bearer " + RestUtils.getResponse("token").toString();
		
		json = new LinkedHashMap<>();
		json.put("nome", "jonatas");
		json.put("idade", 29);
		
		LinkedHashMap<String, Object> documento = new LinkedHashMap<>(); 
		documento.put("tipo", "cpf");
		documento.put("valor", "7897845465465");
		
		List<LinkedHashMap<String, Object>> documentos = new ArrayList<>();
		documentos.add(documento);		
		json.put("documentos", documentos);
		
		LinkedHashMap<String, String> header = new LinkedHashMap<>();
		header.put("Authorization", token);
		
		RestUtils.postRequest("/posts", header, json);
		
		assertEquals("jonatas", RestUtils.getResponse("nome"));		
		assertEquals(201, RestUtils.getStatusCode());
	};
	
	
	@Test
	public void postHeaderTokenStringTest() {
		String json = "{" + 
				"	\"usuario\": \"jonatas\"," + 
				"	\"senha\": \"123456\"," + 
				"	\"token\": \"e5jYWl4QAj4B8ezTg\"}";
		
		RestUtils.setBaseUri("https://jsonplaceholder.typicode.com");
		RestUtils.postRequest("/posts", json);
		
		String token = "Bearer " + RestUtils.getResponse("token").toString();
		
		json = "{" + 
				"	\"nome\": \"jonatas\"," + 
				"	\"idade\": 29," + 
				"	\"documentos\": [" + 
				"		{" + 
				"			\"tipo\": \"cpf\"," + 
				"			\"valor\": \"7897845465465\"" + 
				"		}" + 
				"    ]" + 
				"}";
		
		
		LinkedHashMap<String, String> header = new LinkedHashMap<>();
		header.put("Authorization", token);
		
		RestUtils.postRequest("/posts", header, json);
		
		assertEquals("jonatas", RestUtils.getResponse("nome"));		
		assertEquals(201, RestUtils.getStatusCode());
	}

}
