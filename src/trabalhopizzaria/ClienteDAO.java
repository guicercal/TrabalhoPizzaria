package trabalhopizzaria;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    private final ConnectionFactory conFactory;

    private final String insertStm = "INSERT INTO cliente(nome,telefone,rua,numero,complemento,bairro,cidade) VALUES(?,?,?,?,?,?,?);";

    private final String updateStm = "UPDATE cliente SET nome = ?, telefone = ?, rua = ?, numero = ?, complemento = ?, bairro = ?, cidade = ? WHERE id_cliente = ? ";

    private String deleteStm = "DELETE FROM cliente WHERE id_cliente = ?";

    private String findClienteByIdStm;

    private String findAllClientesStm = "SELECT * FROM cliente";
    
    private String findClientesByFilterStm = "select * from cliente where upper(nome) like ? OR telefone like ?";

    public ClienteDAO() {
        this.conFactory = new ConnectionFactory();
    }
    
    /**
     *
     * @param cliente
     * @throws SQLException
     * @throws IOException
     */
    public void insert(Cliente cliente) throws SQLException, IOException {
        
        PreparedStatement stm = null;
        Connection con = null;
        try{
           con = conFactory.getConnection();
           stm = con.prepareStatement(insertStm, Statement.RETURN_GENERATED_KEYS);
           stm.setString(1, cliente.getNome());
           stm.setString(2, cliente.getTelefone());
           stm.setString(3, cliente.getRua());
           stm.setInt(4, cliente.getNumero());
           stm.setString(5, cliente.getComplemento());
           stm.setString(6, cliente.getBairro());
           stm.setString(7, cliente.getCidade());
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

    public void update(Cliente cliente) throws IOException {
        PreparedStatement stm = null;
        Connection con = null;
        
        try{
           con = conFactory.getConnection();
           stm = con.prepareStatement(updateStm);
           stm.setString(1, cliente.getNome());
           stm.setString(2, cliente.getTelefone());
           stm.setString(3, cliente.getRua());
           stm.setInt(4, cliente.getNumero());
           stm.setString(5, cliente.getComplemento());
           stm.setString(6, cliente.getBairro());
           stm.setString(7, cliente.getCidade());
           stm.setInt(8, cliente.getId());
           
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

    public void delete(Cliente cliente) throws IOException {
        PreparedStatement stm = null;
        Connection con = null;
        System.out.println(cliente.getId());
        try{
           con = conFactory.getConnection();
           stm = con.prepareStatement(deleteStm);
           stm.setInt(1, cliente.getId());
           
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

    public Cliente findClienteById(int id) throws IOException {
    	//Objeto de retorno do método
		Cliente CliRetorno = null;
        Connection con = null;
        PreparedStatement preparador = null;
        
		String sql = "select * from cliente where id_cliente=?";
		
		try {
			
			con = conFactory.getConnection();
			preparador = con.prepareStatement(sql);
			
			preparador.setInt(1,id);
			//Retorno da consulta em Resultset
			ResultSet resultado = preparador.executeQuery();
			//Se tem registro
			CliRetorno = new Cliente();
			if(resultado.next()){
				resultado.beforeFirst();
				//instancia o objeto Usuario
				
				CliRetorno.setId(resultado.getInt("id_cliente"));
				CliRetorno.setNome(resultado.getString("nome"));
				CliRetorno.setTelefone(resultado.getString("telefone"));
				CliRetorno.setRua(resultado.getString("rua"));
				CliRetorno.setNumero(resultado.getInt("numero"));
				CliRetorno.setCidade(resultado.getString("cidade"));
				CliRetorno.setBairro(resultado.getString("bairro"));
				CliRetorno.setComplemento(resultado.getString("complemento"));
				
			}
			
			return CliRetorno;
			
		} 
		catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } finally{
            try{preparador.close();}catch(Exception ex){
               throw new RuntimeException(ex);
            }
            try{con.close();}catch(Exception ex){
                throw new RuntimeException(ex);
            }
        }
		
		
	}
    

   

    public List<Cliente> findAllClientes() throws IOException {
        PreparedStatement stm = null;
        Connection con = null;
        
        ResultSet rs = null;
        try{
           con = conFactory.getConnection();
           stm = con.prepareStatement(findAllClientesStm);
           
           rs = stm.executeQuery();
           
           List<Cliente> lista = new ArrayList();
           
           while(rs.next()){
               Cliente cli = new Cliente();
               cli.setId(rs.getInt("id_cliente"));
               cli.setNome(rs.getString("nome"));
               cli.setTelefone(rs.getString("telefone"));
               cli.setRua(rs.getString("rua"));
               cli.setComplemento(rs.getString("complemento"));
               cli.setBairro(rs.getString("bairro"));
               cli.setCidade(rs.getString("cidade"));
               cli.setNumero(rs.getInt("numero"));
               
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
    
    public List<Cliente> findClientesByFilter(String filtro) throws IOException, SQLException {
        PreparedStatement stm = null;
        Connection con = null;
        
        ResultSet rs = null;
        try{
           con = conFactory.getConnection();
           stm = con.prepareStatement(findClientesByFilterStm);
           stm.setString(1,"%"+filtro.toUpperCase()+"%");
           stm.setString(2,"%"+filtro.toUpperCase()+"%");
           rs = stm.executeQuery();
           
           List<Cliente> lista = new ArrayList();
           
           while(rs.next()){
               Cliente cli = new Cliente();
               cli.setId(rs.getInt("id_cliente"));
               cli.setNome(rs.getString("nome"));
               cli.setTelefone(rs.getString("telefone"));
               cli.setRua(rs.getString("rua"));
               cli.setComplemento(rs.getString("complemento"));
               cli.setBairro(rs.getString("bairro"));
               cli.setCidade(rs.getString("cidade"));
               cli.setNumero(rs.getInt("numero"));
               
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
