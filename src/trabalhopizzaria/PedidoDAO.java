package trabalhopizzaria;


import java.util.List;

public class PedidoDAO {

    private ConnectionFactory con;

    private String insertStm;

    private String updateStm;

    private String deleteStm;

    private String findPedidoByIdStm;

    private String findPedidosByClienteStm;

    private String findItensPedidoStm;

    private String insertItensPedidoStm;

    private String updateItensPedido;

    public Pedido insert(Pedido pedido) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Pedido update(Pedido pedido) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Pedido delete(Pedido pedido) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int findPedidoById(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Cliente findPedidosByCliente(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Pedido findItensPedido(Pedido pedido) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Pedido insertItensPedido(Pedido pedido) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Pedido updateItensPedido(Pedido pedido) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Pedido deleteItensPedido(Pedido pedido) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<Pedido> findAllPedidos() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int findPedidosByStatus(int status) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int updateStatusPedido(int status) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
