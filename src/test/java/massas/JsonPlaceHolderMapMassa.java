package massas;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import entidades.Header;
import entidadesMap.DocumentoMap;
import entidadesMap.JsonPlaceHolderMap;
import entidadesMap.LoginMap;

public class JsonPlaceHolderMapMassa {

	public static String url = "https://jsonplaceholder.typicode.com";
	public static String endpoint = "/posts";
	public static String token = "";
	public static LoginMap login;
	public static DocumentoMap documento;
	public static List<LinkedHashMap<String, Object>> documentos;
	public static JsonPlaceHolderMap jsonPlaceHolder;
	public static Header header;
	
	public static void inicializaJsonPlaceHolderMapMassa() {
		login = new LoginMap("jonatas", "123456", "e5jYWl4QAj4B8ezTg");
		documento = new DocumentoMap("cpf", "7897845465465");
		documentos = new ArrayList<>();
		jsonPlaceHolder = new JsonPlaceHolderMap("jonatas", 29, null);
		header = new Header(token);
		addDocumentos();
	}

	public static void addDocumentos() {
		documentos.add(documento.getDocumentoMap());
		jsonPlaceHolder.setJsonPlaceHolderMap("documentos", documento);
	}
}
