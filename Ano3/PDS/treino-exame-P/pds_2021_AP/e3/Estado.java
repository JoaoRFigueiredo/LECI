package e3;

public interface Estado {
    public void registaCamper(Camper c);
    public void pedidoCliente(Cliente u, Camper c);
    public void rejeitaPedido(Cliente u, Camper c);
    public void aceitaPedido(Cliente u, Camper c);
    public void devolveCamper(Cliente u, Camper c);
}
