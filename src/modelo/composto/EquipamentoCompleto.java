package modelo.composto;

import java.util.ArrayList;
import java.util.List;

import modelo.Equipamento;
import modelo.Orcamento;

public class EquipamentoCompleto {

	ArrayList <Orcamento> orcamentos = new ArrayList<>();
	Equipamento equipamento = new Equipamento();
	
	//Construtor
	public EquipamentoCompleto(ArrayList <Orcamento> orcamentos, Equipamento equipamento) {
		this.orcamentos = orcamentos;
		this.equipamento = equipamento;
	}

	//Getters e Setters

	public Equipamento getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}

	public List<Orcamento> getOrcamentos() {
		return orcamentos;
	}

	public void setOrcamentos(ArrayList<Orcamento> orcamentos) {
		this.orcamentos = orcamentos;
	}

	
}
