package jsonPlaceHolder;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedHashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import utils.RestUtils;

public class JsonPlaceHolderTest {
	
	@BeforeEach
	public void tearDown() {
		
	}
	
	@Test
	public void executaPost() {
		String json = "{\"nome\":\"jonatas\"}";
		RestUtils.setBaseUri("https://jsonplaceholder.typicode.com");
		RestUtils.postRequest("/posts", json);
		
		assertEquals("jonatas", RestUtils.getResponse("nome"));
	}
	
	@Test
	public void mapTest() {
		String tempo = "";
		String resultado = "";
		
		if(tempo.equals("muito quente")) {
			resultado = "teste";
		}else if(tempo.equals("quente")) {
			resultado = "ar";
		}else if(tempo.equals("normal")) {
			resultado = "ventilador";			
		}else if(tempo.equals("frio")) {
			resultado = "coberta";
		}
		
		LinkedHashMap<String, String> map = new LinkedHashMap<>();
			map.put("muito quente", "teste");
			map.put("quente", "bom");
			
			System.out.println(map.get("quente"));
		
	}

}
