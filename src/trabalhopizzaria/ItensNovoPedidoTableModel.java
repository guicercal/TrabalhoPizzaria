/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhopizzaria;


import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Guilherme
 */
public class ItensNovoPedidoTableModel extends DefaultTableModel {
    
    

    private String[] colunas = new String[]{"Sabor 1","Sabor 2","Medida","Área","Valor"};
    private List<ItemPedido> lista = new ArrayList();

    public List<ItemPedido> getLista() {
        return lista;
    }
    
    public void reset(){
        
        this.lista.clear();
    }
    
    public void setLista(List<ItemPedido> lista) {
        this.lista = lista;
        this.fireTableDataChanged();
    }

    public ItensNovoPedidoTableModel() throws IOException {
        //SaborPizzaDAO dao = new SaborPizzaDAO();
        //this.lista = dao.findAllSabores();
        //this.fireTableDataChanged();
    } 
     

    @Override
    public int getRowCount() {
        try{
            return this.lista.size();
        }catch(Exception e){
            return 0;
        }
        
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
        
        ItemPedido item = lista.get(rowIndex);
        
        DecimalFormat df = new DecimalFormat("##.##");
        df.setRoundingMode(RoundingMode.UP);
        
        switch (columnIndex) {
            case 0: return item.getSabor1().getNome();
            case 1: return item.getSabor2().getNome();
            case 2: return df.format(item.getMedida());
            case 3: return df.format(item.getArea());
            case 4: return df.format(item.getValor());
            default : return null;
        }
    }
    
    @Override
    public void setValueAt(Object value, int row, int col) {
        ItemPedido item = lista.get(row);
        switch (col) {
            case 0:
                item.setSabor1((SaborPizza) value);
                break;
            case 1:
                item.setSabor2((SaborPizza) value);
                break;
            case 2: item.setMedida((Double) value);break;
            case 3: item.setArea((Double) value);break;
            default: item.setValor((Double) value);
        }
        this.fireTableCellUpdated(row, col);
    }
    
    public boolean removeItem(ItemPedido item) {
        int linha = this.lista.indexOf(item);
        boolean result = this.lista.remove(item);
        this.fireTableRowsDeleted(linha,linha);//update JTable
        return result;
    }
    
    public void atualizarTabela() throws IOException{
        SaborPizzaDAO dao = new SaborPizzaDAO();
        //this.lista = dao.findAllSabores();
        this.fireTableDataChanged();
    }
    
    public void adicionaItem(ItemPedido item) {
        this.lista.add(item);
        //this.fireTableDataChanged();
        this.fireTableRowsInserted(lista.size()-1,lista.size()-1);//update JTable
    }
    
    public ItemPedido getItem(int offset){
        return lista.get(offset);
    }
    
}
