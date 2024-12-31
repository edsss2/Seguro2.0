package modelo.composto;

import modelo.Endereco;
import modelo.Segurado;

public class SeguradoCompleto {
	
	Segurado segurado = new Segurado();
	Endereco endereco = new Endereco();

	//Construtor
	public SeguradoCompleto(Segurado segurado, Endereco endereco) {
		this.segurado = segurado;
		this.endereco = endereco;
	}

	//Getters e Setters
	public Segurado getSegurado() {
		return segurado;
	}

	public void setSegurado(Segurado segurado) {
		this.segurado = segurado;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
}
