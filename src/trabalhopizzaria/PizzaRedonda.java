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
}
