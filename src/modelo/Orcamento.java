package modelo;

public class Orcamento {

	private String descricao;
	private double valor;
	private int idOrcamento;
	static int geradorIdOrcamento;
	
	//Construtores
	public Orcamento(int idOrcamento, String descricao, double valor) {
		super();
		this.descricao = descricao;
		this.valor = valor;
	}
	
	public Orcamento(String descricao, double valor) {
		super();
		geradorIdOrcamento++;
		this.descricao = descricao;
		this.valor = valor;
		this.idOrcamento = geradorIdOrcamento;
	}

	public Orcamento() {
		super();
	}

	//Getters e Setters

	public int getIdOrcamento() {
		return idOrcamento;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	
	
}
