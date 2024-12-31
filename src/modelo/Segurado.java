package modelo;

public class Segurado {
	
	private String nome;
	private int idSegurado;
	static int geradorIdSegurado;
	
	//Construtores
	public Segurado(String nome) {
		geradorIdSegurado++;
		this.nome = nome;
		this.idSegurado = geradorIdSegurado;
	}
	
	public Segurado(int idSegurado, String nome) {
		super();
		this.nome = nome;
	}

	public Segurado() {
		
	}

	//Getters e Setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdSegurado() {
		return idSegurado;
	}

	public void setIdSegurado(int idSegurado) {
		this.idSegurado = idSegurado;
	}
	
	
	
}
