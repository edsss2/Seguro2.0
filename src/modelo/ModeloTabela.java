package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ModeloTabela extends AbstractTableModel{

	List<Orcamento> orcamentos;
	private final String[] colunas = {"Descrição", "Valor R$"};
	
	public ModeloTabela(ArrayList<Orcamento> orcamentos) {
		this.orcamentos = orcamentos;
	}
	
	@Override
	public String getColumnName(int column) {
		return colunas[column];
	}
	
	@Override
    public boolean isCellEditable(int row, int column) {
        return true;
	}
        
	@Override
	public int getRowCount() {
		return orcamentos.size();
	}

	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Orcamento orcamento = orcamentos.get(rowIndex);
		if (columnIndex == 0) {
			return orcamento.getDescricao();
		} else 
			if (columnIndex == 1) {
				return orcamento.getValor();
		} else {
			return null;
		}
	}
	
	 @Override
	    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
	        Orcamento orcamento = orcamentos.get(rowIndex);
	        if (columnIndex == 0) {
	            orcamento.setDescricao(aValue.toString());
	        } else if (columnIndex == 1) {
	            orcamento.setValor(Double.parseDouble(aValue.toString()));
	        }
	        fireTableCellUpdated(rowIndex, columnIndex);
	    }

	public void addRow(Orcamento orcamento) {
		orcamentos.add(orcamento);	
		fireTableRowsInserted(orcamentos.size() - 1, orcamentos.size() - 1);
	}

	public void removeRow(int linhaSelecionada) {
		orcamentos.remove(linhaSelecionada);
		fireTableRowsDeleted(linhaSelecionada, linhaSelecionada);
		
	}

}
