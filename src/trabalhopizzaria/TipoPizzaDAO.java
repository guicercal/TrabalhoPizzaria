package trabalhopizzaria;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class TipoPizzaDAO {
    private final ConnectionFactory conFactory;
    private String updateStm;
    private final String findAllStm = "SELECT * FORM tipo_pizza";

    public TipoPizzaDAO() throws SQLException, IOException {
        this.conFactory = new ConnectionFactory();
    }

    public void update(TipoPizza tipo) throws IOException {
        PreparedStatement stm = null;
        Connection con = null;
        
        try{
           con = conFactory.getConnection();
           stm = con.prepareStatement(updateStm);
           stm.setDouble(1, tipo.getValorCm());
           stm.setInt(2, tipo.getId());           
           stm.executeUpdate();
        }
        catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } finally{
            try{stm.close();}catch(Exception ex){
               throw new RuntimeException(ex);
            }
            try{con.close();}catch(Exception ex){
                throw new RuntimeException(ex);
            }
        }
    }
    
    public List<TipoPizza> findAllTipos(){
        
        
        
        return null;
        
    }
}
