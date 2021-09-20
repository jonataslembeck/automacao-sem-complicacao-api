package massas;

import java.util.ArrayList;
import java.util.List;

import entidades.Documento;
import entidades.Header;
import entidades.JsonPlaceHolder;
import entidades.Login;

public class JsonPlaceHolderMassa {
	
	public static String url = "https://jsonplaceholder.typicode.com";
	public static String endpoint = "/posts";
	public static String token = "";
	public static Login login;
	public static Documento documento;
	public static List<Documento> documentos;
	public static JsonPlaceHolder jsonPlaceHolder;
	public static Header header;
	
	public static void inicializaJsonPlaceHolderMassa() {
		login = new Login("jonatas", "123456", "e5jYWl4QAj4B8ezTg");
		documento = new Documento("cpf", "7897845465465");
		documentos = new ArrayList<>();
		jsonPlaceHolder = new JsonPlaceHolder("jonatas", 29, null);
		header = new Header(token);
		addDocumentos();
	}
	
	public static void addDocumentos() {
		documentos.add(documento);
		jsonPlaceHolder.setDocumentos(documentos);
	}
	

}
