package e3;

public class Reservado implements Estado {
    public String toString() {
        return "Reservado";
    }

    @Override
    public void registaCamper(Camper c) {
        System.out.println("Método registaCamper não disponivel");
        
        
    }

    @Override
    public void pedidoCliente(Cliente u, Camper c) {
        System.out.println("Método pedidoCliente não disponivel");
    }

    @Override
    public void rejeitaPedido(Cliente u, Camper c) {
        System.out.println("Método rejeitaPedido não disponivel");
    }

    @Override
    public void aceitaPedido(Cliente u, Camper c) {
        System.out.println("Método aceitaPedido não disponivel");
        
    }

    @Override
    public void devolveCamper(Cliente u, Camper c) {
        c.setEstado(new Disponivel());
        
    }

    
    
}
