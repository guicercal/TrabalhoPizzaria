package trabalhopizzaria;

/**
 * @author  Guilherme Cercal, Gustavo Benjamin & Bruno Pereira
 * Classe abstrata que representa uma forma geométrica de pizza
 */
public abstract class FormaPizza {

    protected Double area;

    protected Double medida;
    
    private String nome;

    /**
     *
     * @param medida - Medida do lado ou raio da forma.
     * @return Double
     */
    public abstract Double calcularArea(Double medida);
    
    /**
     *
     * @param area - Area da forma.
     * @return Double
     */
    public abstract Double calcularMedida(Double area);

    /**
     *
     * @return Double 
     */
    public Double getArea() {
        return area;
    }

    /**
     * Este método pode ser utilizado no momento da inserção de 
     * um novo item de pedido, quando o cliente 
     * desejar especificar diretamente a area em cm² de 
     * sua pizza. Neste caso, a medida do lado ou raio (conforme a forma escolhida)
     * é calculada e parametrizada automaticamente.
     * @param area - Area em cm² da forma. 
     */
    public void setArea(Double area) {
        
        if(area >= 100.00 && area <= 1670.00){
            this.area = area;
        }
        else if(area < 100.00){
            this.area = 100.00;
        }
        else{
            this.area = 1670.00;
        }
            
        this.medida = calcularMedida(this.area);
    }

    /**
     *
     * @return Double
     */
    public Double getMedida() {
        return medida;
    }

    /**
     * Este método pode ser utilizado no momento da inserção de 
     * um novo item de pedido, quando o cliente 
     * desejar especificar diretamente o tamanho em cm do lado ou raio de 
     * sua pizza. Neste caso, a área da pizza (conforme a forma escolhida)
     * é calculada e parametrizada automaticamente.
     * @param medida - Medida do lado ou raio da forma.
     */
    public abstract void setMedida(Double medida);
    
    public String getNome() {
        return nome;
    }
    public abstract int getFormaId();
}
