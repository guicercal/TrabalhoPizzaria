package trabalhopizzaria;


import java.util.List;

public class ItemPedido {

    private int id;

    private Pedido pedido;

    private FormaPizza forma;

    private List<SaborPizza> sabores;

    private Double valor;

    private Double area;

    private Double medida;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public FormaPizza getForma() {
        return forma;
    }

    public void setForma(FormaPizza forma) {
        this.forma = forma;
    }

    public List<SaborPizza> getSabores() {
        return sabores;
    }

    public void setSabores(List<SaborPizza> sabores) {
        this.sabores = sabores;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Double getMedida() {
        return medida;
    }

    public void setMedida(Double medida) {
        this.medida = medida;
    }
    
    
    
    public Double calcularValor() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
