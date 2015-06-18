package trabalhopizzaria;


import java.util.List;

public class TipoPizza {

    private int id;

    private List<SaborPizza> sabores;

    private Double valorCm;

    private String nome;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<SaborPizza> getSabores() {
        return sabores;
    }

    public void setSabores(List<SaborPizza> sabores) {
        this.sabores = sabores;
    }

    public Double getValorCm() {
        return valorCm;
    }

    public void setValorCm(Double valorCm) {
        this.valorCm = valorCm;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
}
