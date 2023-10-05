public class Cliente {
  private Moeda moeda;
  private Double saldo;

  public Cliente(Moeda moeda) {
    this.moeda = moeda;
    this.saldo = 0.0;
  }

  public Double getSaldo() {
    return saldo;
  }

  public Moeda getMoeda() {
    return moeda;
  }

  public boolean addSaldo(Double montante) {
    if (saldo + montante < 0)
      return false;

    saldo += montante;
    return true;
  }
}
