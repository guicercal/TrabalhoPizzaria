package trabalhopizzaria;

public class PizzaQuadrada extends FormaPizza {

    private final String nome = "Quadrada";

    @Override
    public Double calcularArea(Double medida) {
        return medida*medida;
    }

    @Override
    public Double calcularMedida(Double area) {
        return Math.sqrt(area);
    }
    
    @Override
    public int getFormaId(){
    	return 1;
    }
    
    @Override
    public void setMedida(Double medida){
        
        if(medida >= 10.00 && medida <= 40.00){
            this.medida = medida;
        }else if(medida < 10.00){
            this.medida  = 10.00;
        }
        else{
            this.medida = 40.00;
        }
        
        this.area = calcularArea(this.medida);
    }
}
