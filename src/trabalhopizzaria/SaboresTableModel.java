/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhopizzaria;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Guilherme
 */
public class SaboresTableModel extends AbstractTableModel {

    private String[] colunas = new String[]{"Nome","Tipo"};
    private List<SaborPizza> lista = new ArrayList();

    public List<SaborPizza> getLista() {
        return lista;
    }

    public void setLista(List<SaborPizza> lista) {
        this.lista = lista;
        this.fireTableDataChanged();
    }

    public SaboresTableModel() throws IOException {
        SaborPizzaDAO dao = new SaborPizzaDAO();
        this.lista = dao.findAllSabores();
        this.fireTableDataChanged();
    }
     

    @Override
    public int getRowCount() {
        return this.lista.size();
    }

    @Override
    public int getColumnCount() {
        return this.colunas.length;
    }
    
    @Override
    public String getColumnName(int index) {
        return this.colunas[index];
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        SaborPizza sabor = lista.get(rowIndex);
        switch (columnIndex) {
            case 0: return sabor.getNome();
            case 1: return sabor.getNomeTipo();

            default : return null;
        }
    }
    
    @Override
    public void setValueAt(Object value, int row, int col) {
        SaborPizza sabor = lista.get(row);
        switch (col) {
            case 0:
                sabor.setNome((String) value); //if column 0 (code)
                break;
            case 1:
                sabor.setTipo((int) value);
                break;
            default:
        }
        this.fireTableCellUpdated(row, col);
    }
    
    public boolean removeSabor(SaborPizza sabor) {
        int linha = this.lista.indexOf(sabor);
        boolean result = this.lista.remove(sabor);
        this.fireTableRowsDeleted(linha,linha);//update JTable
        return result;
    }
    
    public void atualizarTabela() throws IOException{
        SaborPizzaDAO dao = new SaborPizzaDAO();
        this.lista = dao.findAllSabores();
        this.fireTableDataChanged();
    }
    
    public void adicionaSabor(SaborPizza sabor) {
        this.lista.add(sabor);
        //this.fireTableDataChanged();
        this.fireTableRowsInserted(lista.size()-1,lista.size()-1);//update JTable
    }
    
    public SaborPizza getSabor(int offset){
        return lista.get(offset);
    }
    
}
