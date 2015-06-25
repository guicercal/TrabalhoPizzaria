package trabalhopizzaria;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SaborPizzaDAO {
    
    private final ConnectionFactory conFactory;

    private final String insertStm = "INSERT INTO sabor_pizza(nome,ingredientes,id_tipo) VALUES(?,?,?);";

    private ConnectionFactory con;

    private String findAllSaboresStm = "SELECT * FROM sabor_pizza";

     public SaborPizzaDAO() {
        this.conFactory = new ConnectionFactory();
    }
   
    
    public void insert(SaborPizza sabor) throws SQLException, IOException {
        
        PreparedStatement stm = null;
        Connection con = null;
        try{
           con = conFactory.getConnection();
           stm = con.prepareStatement(insertStm, Statement.RETURN_GENERATED_KEYS);
           stm.setString(1, sabor.getNome());
           stm.setString(2, sabor.getIngredientes());
           stm.setInt(3, sabor.getTipo());
           stm.execute();
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

    
    
    public List<SaborPizza> findAllSabores() throws IOException {
        PreparedStatement stm = null;
        Connection con = null;
        
        ResultSet rs = null;
        try{
           con = conFactory.getConnection();
           stm = con.prepareStatement(findAllSaboresStm);
           rs = stm.executeQuery();
           
           List<SaborPizza> lista = new ArrayList();
           
           while(rs.next()){
               SaborPizza cli = new SaborPizza();
               cli.setId(rs.getInt("id_sabor_pizza"));
               cli.setNome(rs.getString("nome"));
               cli.setIngredientes(rs.getString("ingredientes"));
               cli.setTipo(rs.getInt("id_tipo"));
               lista.add(cli);
           }
           
           return lista;
           
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
