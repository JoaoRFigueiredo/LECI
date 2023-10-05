package e3;

public class Pendente implements Estado {
    public String toString() {
        return "Pendente";
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
        c.setEstado(new Disponivel());
        
    }

    @Override
    public void aceitaPedido(Cliente u, Camper c) {
        c.setEstado(new Reservado());
        
        
    }

    @Override
    public void devolveCamper(Cliente u, Camper c) {
        System.out.println("Método devolveCamper não disponivel");
        
    }

    
    
}
