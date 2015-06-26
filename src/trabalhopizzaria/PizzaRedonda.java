package trabalhopizzaria;

public class PizzaRedonda extends FormaPizza {

    private final String nome = "Redonda";

    @Override
    public Double calcularArea(Double medida) {
        return Math.PI * medida * medida;
    }

    @Override
    public Double calcularMedida(Double area) {
        return Math.sqrt(area/Math.PI);
    }
    @Override
    public int getFormaId(){
    	return 2;
    }
    
    @Override
    public void setMedida(Double medida){
        
        if(medida >= 7.00 && medida <= 23.00){
            this.medida = medida;
        }else if(medida < 7.00){
            this.medida  = 7.00;
        }
        else{
            this.medida = 23.00;
        }
        
        this.area = calcularArea(medida);
    }
    
    
}
