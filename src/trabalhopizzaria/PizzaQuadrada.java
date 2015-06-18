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
}
