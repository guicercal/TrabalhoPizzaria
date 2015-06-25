package trabalhopizzaria;

public class SaborPizza {

    private int id;

    private String nome;

    private String ingredientes;
    
    private int tipo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    
    public String getNomeTipo(){
    
        switch(this.tipo){
            case 1: return "Simples"; 
            case 2: return "Especial";
            case 3: return "Premium";
            default: return "Simples";
        }
    }

    

   
}
