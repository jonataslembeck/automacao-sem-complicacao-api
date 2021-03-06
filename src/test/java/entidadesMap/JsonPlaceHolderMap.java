package entidadesMap;

import java.util.LinkedHashMap;
import java.util.List;

public class JsonPlaceHolderMap {
	private LinkedHashMap<String, Object> jsonPlaceHolderMap = new LinkedHashMap<>();
	
	public JsonPlaceHolderMap(Object nome, Object idade, List<LinkedHashMap<String, Object>> documentos) {
		jsonPlaceHolderMap.put("nome", nome);
		jsonPlaceHolderMap.put("idade", idade);
		jsonPlaceHolderMap.put("documentos", documentos);
	}
	
	public LinkedHashMap<String, Object> getJsonPlaceHolderMap() {
		return jsonPlaceHolderMap;
	}
	
	public void setJsonPlaceHolderMap(String key, Object value) {
		jsonPlaceHolderMap.put(key, value);
	}
	
	public void setJsonPlaceHolderMap(LinkedHashMap<String, Object> map) {
		jsonPlaceHolderMap.putAll(map);
	}
	
	public void remoKey(String key) {
		jsonPlaceHolderMap.remove(key);
	}

}
