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
 * @author Guilherme, Bruno, Gustavo
 */
public class ClienteTableModel extends AbstractTableModel {
    
    private String[] colunas = new String[]{"Nome","Telefone"};
    private List<Cliente> lista = new ArrayList();

    public List<Cliente> getLista() {
        return lista;
    }

    public void setLista(List<Cliente> lista) {
        this.lista = lista;
        this.fireTableDataChanged();
    }

    public ClienteTableModel() throws IOException {
        ClienteDAO dao = new ClienteDAO();
        this.lista = dao.findAllClientes();
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
        Cliente cliente = lista.get(rowIndex);
        switch (columnIndex) {
            case 0: return cliente.getNome();
            case 1: return cliente.getTelefone();

            default : return null;
        }
    }
    
    @Override
    public void setValueAt(Object value, int row, int col) {
        Cliente cliente = lista.get(row);
        switch (col) {
            case 0:
                cliente.setNome((String) value); //if column 0 (code)
                break;
            case 1:
                cliente.setId((int) value);
                break;
            default:
        }
        this.fireTableCellUpdated(row, col);
    }
    
    public boolean removeCliente(Cliente cliente) {
        int linha = this.lista.indexOf(cliente);
        boolean result = this.lista.remove(cliente);
        this.fireTableRowsDeleted(linha,linha);//update JTable
        return result;
    }
    
    public void atualizarTabela() throws IOException{
        ClienteDAO dao = new ClienteDAO();
        this.lista = dao.findAllClientes();
        this.fireTableDataChanged();
    }
    
    public void adicionaCliente(Cliente cliente) {
        this.lista.add(cliente);
        //this.fireTableDataChanged();
        this.fireTableRowsInserted(lista.size()-1,lista.size()-1);//update JTable
    }
    
    public Cliente getCliente(int offset){
        return lista.get(offset);
    }
}
