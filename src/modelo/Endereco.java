package modelo;

public class Endereco {

	private String rua;
	private int numero;
	private String bairro;
	private String cidade;
	private String estado;
	private long cep;
	private int idEndereco;
	static int geradorIdEndereco = 0;

	
	//Construtores
	public Endereco(String rua, int numero, String bairro, String cidade, String estado, long cep) {
		super();
		geradorIdEndereco++;
		this.rua = rua;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
		this.setIdEndereco(geradorIdEndereco);
	}
	
	public Endereco(int idEndereco, String rua, int numero, String bairro, String cidade, String estado, long cep) {
		this.rua = rua;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
	}
	

	public Endereco() {
		super();
		geradorIdEndereco++;
		this.idEndereco = geradorIdEndereco;
	}


	//Getters e Setters
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public long getCep() {
		return cep;
	}
	public void setCep(long cep) {
		this.cep = cep;
	}

	public int getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(int idEndereco) {
		this.idEndereco = idEndereco;
	}
}
