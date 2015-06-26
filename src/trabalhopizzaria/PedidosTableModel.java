/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhopizzaria;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Guilherme
 */
public class PedidosTableModel extends AbstractTableModel {

    private String[] colunas = new String[]{"Status","Cliente","Data - Hora","Valor"};
    private List<Pedido> lista = new ArrayList();

    public List<Pedido> getLista() {
        return lista;
    }

    public void setLista(List<Pedido> lista) {
        this.lista = lista;
        this.fireTableDataChanged();
    }

    public PedidosTableModel() throws IOException {
        PedidoDAO dao = new PedidoDAO();
        this.lista = dao.findAllPedidos();
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
        Pedido pedido = lista.get(rowIndex);
        switch (columnIndex) {
            case 0: return pedido.getNomeStatus();
            case 1: return pedido.getCliente().getNome();
            case 2: return new SimpleDateFormat( "dd/MM/YYYY - HH:mm:ss" ).format(pedido.getDataPedido().getTime());
            case 3: return pedido.getValor();
            default : return null;
        }
    }
    
    @Override
    public void setValueAt(Object value, int row, int col) {
        Pedido pedido = lista.get(row);
        switch (col) {
            case 0:
                pedido.setStatus((int) value); //if column 0 (code)
                break;
            case 1:
                pedido.setCliente((Cliente) value);
                break;
            case 2:
                pedido.setDataPedido((Timestamp) value);
                break;
            case 3:
                pedido.setValor((Double) value);
                break;
            default:
        }
        this.fireTableCellUpdated(row, col);
    }
    
    public boolean removePedido(Pedido pedido) {
        int linha = this.lista.indexOf(pedido);
        boolean result = this.lista.remove(pedido);
        this.fireTableRowsDeleted(linha,linha);//update JTable
        return result;
    }
    
    public void atualizarTabela() throws IOException{
       PedidoDAO dao = new PedidoDAO();
        this.lista = dao.findAllPedidos();
        this.fireTableDataChanged();
    }
    
    public void adicionaPedido(Pedido pedido) {
        this.lista.add(pedido);
        //this.fireTableDataChanged();
        this.fireTableRowsInserted(lista.size()-1,lista.size()-1);//update JTable
    }
    
    public Pedido getPedido(int offset){
        return lista.get(offset);
    }
    
}
