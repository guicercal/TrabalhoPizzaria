package trabalhopizzaria;


import java.util.List;

public class ItemPedido {

    private int id;

    private Pedido pedido;

    private FormaPizza forma;

    private Double valor;

    private Double area;

    private Double medida;
    
    private SaborPizza sabor1;
    
    public SaborPizza getSabor1() {
		return sabor1;
	}

	public void setSabor1(SaborPizza sabor1) {
		this.sabor1 = sabor1;
	}

	public SaborPizza getSabor2() {
		return sabor2;
	}

	public void setSabor2(SaborPizza sabor2) {
		this.sabor2 = sabor2;
	}



	private SaborPizza sabor2;

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
