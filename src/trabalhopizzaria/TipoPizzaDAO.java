package trabalhopizzaria;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TipoPizzaDAO {
    private final ConnectionFactory conFactory;
    private final String updateStm = "UPDATE tipo_pizza SET valor_cm = ? WHERE id_tipo = ?";
    private final String findValorByTipoStm = "SELECT valor_cm FROM tipo_pizza WHERE id_tipo = ?";

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
    
    public double findValorByTipo(int tipo) throws IOException{
        
        PreparedStatement stm = null;
        Connection con = null;
        ResultSet rs = null;
        try{
           con = conFactory.getConnection();
           stm = con.prepareStatement(findValorByTipoStm);
           stm.setInt(1, tipo);           

           rs = stm.executeQuery();
           rs.next();
           return rs.getDouble("valor_cm");
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
}
