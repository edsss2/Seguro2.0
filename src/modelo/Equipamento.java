package modelo;

public class Equipamento {

	private String nomeEquipamento;
	private String marca;
	private String modelo;
	private String numeroSerie;
	private String pecasDanificadas;
	private String motivoDano;
	private String possibilidadeReparo;
	private String motivoPt;
	private int idEquipamento;
	static int geradorIdEquipamento;
	
	//Construtores
	public Equipamento(String nomeEquipamento, String marca, String modelo, String numeroSerie, String pecasDanificadas,
			String motivoDano, String possibilidadeReparo, String motivoPt) {
		super();
		geradorIdEquipamento++;
		this.nomeEquipamento = nomeEquipamento;
		this.marca = marca;
		this.modelo = modelo;
		this.numeroSerie = numeroSerie;
		this.pecasDanificadas = pecasDanificadas;
		this.motivoDano = motivoDano;
		this.possibilidadeReparo = possibilidadeReparo;
		this.motivoPt = motivoPt;
		this.idEquipamento = geradorIdEquipamento;
	}
	
	public Equipamento(int idEquipamento, String nomeEquipamento, String marca, String modelo, String numeroSerie, String pecasDanificadas,
			String motivoDano, String possibilidadeReparo, String motivoPt) {
		super();
		this.nomeEquipamento = nomeEquipamento;
		this.marca = marca;
		this.modelo = modelo;
		this.numeroSerie = numeroSerie;
		this.pecasDanificadas = pecasDanificadas;
		this.motivoDano = motivoDano;
		this.possibilidadeReparo = possibilidadeReparo;
		this.motivoPt = motivoPt;
	}

	public Equipamento() {
		super();
	}

	//Getters e Setters
	public String getMarca() {
		return marca;
	}	
	public String getNomeEquipamento() {
		return nomeEquipamento;
	}

	public void setNomeEquipamento(String nomeEquipamento) {
		this.nomeEquipamento = nomeEquipamento;
	}

	public String getPecasDanificadas() {
		return pecasDanificadas;
	}
	public void setPecasDanificadas(String pecasDanificadas) {
		this.pecasDanificadas = pecasDanificadas;
	}
	public String getMotivoDano() {
		return motivoDano;
	}
	public void setMotivoDano(String motivoDano) {
		this.motivoDano = motivoDano;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getNumeroSerie() {
		return numeroSerie;
	}
	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}
	public String getPossibilidadeReparo() {
		return possibilidadeReparo;
	}
	public void setPossibilidadeReparo(String possibilidadeReparo) {
		this.possibilidadeReparo = possibilidadeReparo;
	}
	public String getMotivoPt() {
		return motivoPt;
	}
	public void setMotivoPt(String motivoPt) {
		this.motivoPt = motivoPt;
	}
	public int getIdEquipamento() {
		return idEquipamento;
	}
	public void setIdEquipamento(int idEquipamento) {
		this.idEquipamento = idEquipamento;
	}
	
	
}
