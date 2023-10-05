package e3;

public class Disponivel implements Estado {
    public String toString() {
        return "Disponivel";
    }

    @Override
    public void registaCamper(Camper c) {
        c.setEstado(new Disponivel());   
        
    }

    @Override
    public void pedidoCliente(Cliente u, Camper c) {
        c.setEstado(new Pendente());
        
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
        System.out.println("Método devolveCamper não disponivel");
        
    }
    
}
