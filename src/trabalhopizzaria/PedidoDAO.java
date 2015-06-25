package trabalhopizzaria;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PedidoDAO {

    private ConnectionFactory conFactory;

    private String insertStm;

    private String updateStm;

    private String deleteStm;

    private String findPedidoByIdStm;

    private String findPedidosByClienteStm;

    private String findItensPedidoStm = "Select * from item_pedido where id_pedido=?";

    private String insertItensPedidoStm;

    private String updateItensPedido;

    public Pedido insert(Pedido pedido) {
    	Connection con = null;
    		//Monta sql
    		String sql = "insert into pedido (status, data, valor) values (?,?,?)";
    		//constroe o PreparedStatement com sql
    		try {
    			PreparedStatement preparador = con.prepareStatement(sql);
    			preparador.setInt(1, pedido.getStatus());
    			preparador.setDate(2, pedido.getDataPedido());
    			preparador.setDouble(3, pedido.getValor());
    			preparador.execute();
    			preparador.close();
    			
    			System.out.println("Cadastrado com sucesso");
    			
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    	}
    

    public Pedido update(Pedido pedido) {
    	Connection con = null;
    		//Monta sql
    		String sql = "update Pedido set status=?, data=?, valor=? where id_pedido=?";
    		//constroe o PreparedStatement com sql
    		try {
    			PreparedStatement preparador = con.prepareStatement(sql);
    			preparador.setInt(1, pedido.getStatus());
    			preparador.setDate(2, pedido.getDataPedido());
    			preparador.setDouble(3, pedido.getValor());
    			preparador.setInt(4, pedido.getId());
    			preparador.execute();
    			preparador.close();
    			
    			System.out.println("Alterado com sucesso");
    			
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    	}
    

    public void delete(Pedido pedido) {
    	Connection con = null;
    	//Monta sql
    	String sql = "delete from Cliente where id_pedido=?";
    	//constroe o PreparedStatement com sql
    	try {
    		PreparedStatement preparador = con.prepareStatement(sql);
    		preparador.setInt(1, pedido.getId());
    		preparador.execute();
    		preparador.close();
    		
    		System.out.println("Excluido com sucesso");
    		
    	} catch (SQLException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    }
    

    public Pedido findPedidoById(int id) {
    	Connection con = null;
    		//Objeto de retorno do método
    		Pedido pedRetorno = null;
    		PreparedStatement preparador = null;
    		String sql = "select * from pedido where id_pedido=?";
    		try {
    		 preparador = con.prepareStatement(sql);
    		preparador.setInt(1,id);
    		//Retorno da consulta em Resultset
    		ResultSet resultado = preparador.executeQuery();
    		//Se tem registro
    		if(resultado.next()){
    		//instancia o objeto Usuario
    		pedRetorno = new Pedido();
    		pedRetorno.setId(resultado.getInt("id_pedido"));
    		pedRetorno.setStatus(resultado.getInt("status"));
    		pedRetorno.setDataPedido(resultado.getDate("data"));
    		pedRetorno.setValor(resultado.getDouble("valor"));
    
    		}
    		return pedRetorno;
    		
    		} catch (SQLException e) {
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

    	

    public Cliente findPedidosByCliente(Cliente cliente) {
    	Connection con = null;
    	//Objeto de retorno do método
		Pedido pedRetorno = null;

		String sql = "select * from usuario where id_cliente=?";
		try {
		PreparedStatement preparador = con.prepareStatement(sql);
		preparador.setInt(1,cliente.getId());
		//Retorno da consulta em Resultset
		ResultSet resultado = preparador.executeQuery();
		//Se tem registro
		if(resultado.next()){
		//instancia o objeto Usuario
		pedRetorno = new Pedido();
		pedRetorno.setId(resultado.getInt("id_cliente"));
		pedRetorno.setStatus(resultado.getInt("status"));
		pedRetorno.setDataPedido(resultado.getDate("data"));
		pedRetorno.setValor(resultado.getDouble("valor"));
		}
		System.out.println("Encontrado com sucesso!");
		} catch (SQLException e) {
		System.out.println("Erro de SQL:"+ e.getMessage());
		}
		return pedRetorno;
		}
    

    

    public void insertItemPedido(ItemPedido itemPedido) {
    	Connection con = null;
		//Monta sql
		String sql = "insert into item_pedido (forma, area, medida, valor, id_pedido, id_cliente) values (?,?,?,?)";
		//constroe o PreparedStatement com sql
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, itemPedido.getForma().getFormaId());
			preparador.setDouble(2, itemPedido.getArea());
			preparador.setDouble(3, itemPedido.getMedida());
			preparador.setDouble(4, itemPedido.getValor());
			preparador.setInt(5, itemPedido.getPedido().getId());
			preparador.setInt(6, itemPedido.getPedido().getCliente().getId());
			preparador.execute();
			preparador.close();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    
    public Pedido deleteItensPedido(Pedido pedido) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<Pedido> findAllPedidos() throws IOException {
    	Connection con = null;
    		//Monta sql
    		String sql = "select * from pedido";
    		
    		List<Pedido> lista = new ArrayList<Pedido>();
    		
    		//constroe o PreparedStatement com sql
    		try {
    			PreparedStatement preparador = con.prepareStatement(sql);
    			
    			ResultSet resultado = preparador.executeQuery();
    			
    			
    			while(resultado.next()){ //pega o valor de cada um por linha
    				//List<ItemPedido> itens = new ArrayList<ItemPedido>();
    				Pedido pedido = new Pedido();
    				ClienteDAO CliDao = new ClienteDAO();
    				//vai pegando um objeto com as informaçoes de cada linha(registro) e jogando na lista
    				pedido.setId(resultado.getInt("id_pedido"));
    				pedido.setStatus(resultado.getInt("status"));
    				pedido.setDataPedido(resultado.getDate("data"));
    				pedido.setValor(resultado.getDouble("valor"));
    				pedido.setCliente(CliDao.findClienteById(resultado.getInt("id_cliente")));
    				//pedido.setItens(itens.findItensByIdPedido(resultado.getInt("id_pedido")));
    				lista.add(pedido);
    			}
    			
    			
    			preparador.close();
    			resultado.close();
    			
    			
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    	return lista;
    	}
    
    
    
    

    
    

    public void updateStatusPedido(Pedido pedido) {
    	Connection con = null;
    	//Monta sql
		String sql = "update pedido set status=? where id_pedido=?";
		//constroe o PreparedStatement com sql
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, pedido.getStatus());
			preparador.setInt(2, pedido.getId());
			preparador.execute();
			preparador.close();
			
			System.out.println("Alterado com sucesso");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public List<ItemPedido> findItensByIdPedido(int id) throws IOException{
    	
    	Connection con = null;
    	PreparedStatement stm = null;
    	List<ItemPedido> lista= new ArrayList();
    	
    	try{
    		con = conFactory.getConnection();
    		stm = con.prepareStatement(findItensPedidoStm);
    		stm.setInt(1, id);
    		
    		ResultSet rs = stm.executeQuery();
    		Pedido pedido = this.findPedidoById(rs.getInt("id_pedido"));
    		while(rs.next()){
    			FormaPizza forma = null;
    			ItemPedido itemPedido = new ItemPedido();
    			itemPedido.setId(rs.getInt("id_item_pedido"));
    			itemPedido.setPedido(pedido);
    			switch(rs.getInt("forma")){
    				case 1: forma = new PizzaQuadrada();break;
    				case 2: forma = new PizzaRedonda();break;
    				default: forma = new PizzaTriangular();break;
    			}
    			itemPedido.setForma(forma);
    			itemPedido.setValor(rs.getDouble("valor"));
    			itemPedido.setArea(rs.getDouble("area"));
    			itemPedido.setMedida(rs.getDouble("medida"));
    			lista.add(itemPedido);
    		}
    		
    			return lista;
    		} catch (SQLException e) {
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


