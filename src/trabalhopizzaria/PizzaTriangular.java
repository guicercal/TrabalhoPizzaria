package trabalhopizzaria;

public class PizzaTriangular extends FormaPizza {

    private final String nome = "Triangular";

    @Override
    public Double calcularArea(Double medida) {
        return ((medida*medida) * Math.sqrt(3))/4 ;
    }

    @Override
    public Double calcularMedida(Double area) {
        return Math.sqrt((4*area)/Math.sqrt(3));
    }    
    @Override
    public int getFormaId(){
    	return 3;
    }
}
