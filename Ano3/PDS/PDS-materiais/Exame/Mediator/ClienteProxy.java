public class ClienteProxy {
  private Banco banco;
  private String id;

  public ClienteProxy(Banco b, String id) {
    this.banco = b;
    this.id = id;
  }

  public void transferir(String destinoId, Double montante) {
    banco.aplicarMovimento(new Movimento(montante, destinoId, this.id, TipoMovimento.TRANSFERENCIA));
  }

  public void depositar(Double montante) {
    banco.aplicarMovimento(new Movimento(montante, this.id, null, TipoMovimento.DEPOSITO));
  }

  public Double consultarSaldo() {
    return banco.consultarSaldo(id);
  }

}
