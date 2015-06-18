package trabalhopizzaria;


import java.util.Date;
import java.util.List;

public class Pedido {

    private int id;

    private Cliente cliente;

    private int status;

    private Date dataPedido;

    private List<ItemPedido> itens;

    private Double valor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
    
    
    
    public Double calcularValor() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
