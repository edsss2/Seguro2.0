package modelo.composto;

import modelo.Assistencia;
import modelo.Endereco;

public class AssistenciaCompleta {

	Assistencia assistencia = new Assistencia();
	Endereco endereco = new Endereco();
	
	//Construtor
	public AssistenciaCompleta(Assistencia assistencia, Endereco endereco) {
		this.assistencia = assistencia;
		this.endereco = endereco;
	}

	//Getters e Setters
	public Assistencia getAssistencia() {
		return assistencia;
	}

	public void setAssistencia(Assistencia assistencia) {
		this.assistencia = assistencia;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
}
