package modelo;

public class Assistencia {

	private String nomeAssistencia;
	private String cnpj;
	private long telefone;
	private String nomeTecnicoCompleto;
	private String email;
	private int idAssistencia;
	static int geradorIdAssistencia;
	
	//Construtores
	public Assistencia(int idAssistencia, String nomeAssistencia, String cnpj, long telefone, String nomeTecnicoCompleto, String email) {
		super();
		this.nomeAssistencia = nomeAssistencia;
		this.cnpj = cnpj;
		this.telefone = telefone;
		this.nomeTecnicoCompleto = nomeTecnicoCompleto;
		this.email = email;
	}
	
	public Assistencia() {
		super();
	}

	public Assistencia(String nomeAssistencia, String cnpj, long telefone, String nomeTecnicoCompleto, String email) {
		super();
		geradorIdAssistencia++;
		this.nomeAssistencia = nomeAssistencia;
		this.cnpj = cnpj;
		this.telefone = telefone;
		this.nomeTecnicoCompleto = nomeTecnicoCompleto;
		this.email = email;
		this.idAssistencia = geradorIdAssistencia;
	}

	//Getters e Setters
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNomeAssistencia() {
		return nomeAssistencia;
	}
	public void setNomeAssitencia(String nomeAssistencia) {
		this.nomeAssistencia = nomeAssistencia;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public long getTelefone() {
		return telefone;
	}
	public void setTelefone(long telefone) {
		this.telefone = telefone;
	}
	public String getNomeTecnicoCompleto() {
		return nomeTecnicoCompleto;
	}
	public void setNomeTecnicoCompleto(String nomeTecnicoCompleto) {
		this.nomeTecnicoCompleto = nomeTecnicoCompleto;
	}

	public int getIdAssistencia() {
		return idAssistencia;
	}

	public void setIdAssistencia(int idAssistencia) {
		this.idAssistencia = idAssistencia;
	}
	
	
}
