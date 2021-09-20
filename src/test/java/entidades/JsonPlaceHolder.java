package entidades;

import java.util.List;

public class JsonPlaceHolder {

	private Object nome;
	private Object idade;
	private List<Documento> documentos;

	public JsonPlaceHolder(Object nome, Object idade, List<Documento> documentos) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.documentos = documentos;
	}

	public Object getNome() {
		return nome;
	}

	public void setNome(Object nome) {
		this.nome = nome;
	}

	public Object getIdade() {
		return idade;
	}

	public void setIdade(Object idade) {
		this.idade = idade;
	}

	public List<Documento> getDocumentos() {
		return documentos;
	}

	public void setDocumentos(List<Documento> documentos) {
		this.documentos = documentos;
	}

}
