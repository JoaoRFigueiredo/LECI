public class BancoDemo {
  public static void main(String[] args) {
    Banco banco = new Banco(Moeda.EUR);
    banco.setTaxaCambio(Moeda.USD, 1.2225);
    banco.setTaxaCambio(Moeda.JPY, 134.05);
    banco.setTaxaCambio(Moeda.GBP, 0.86285);
    banco.setTaxaCambio(Moeda.CHF, 1.0986);
    banco.setTaxaCambio(Moeda.BRL, 6.3596);

    ClienteTerminal paulo = banco.registarCliente("935129312", Moeda.EUR);
    ClienteTerminal pedro = banco.registarCliente("961293123", Moeda.EUR);
    ClienteTerminal americo = banco.registarCliente("915216791", Moeda.USD);
    ClienteTerminal xingling = banco.registarCliente("251981234", Moeda.JPY);

    pedro.verSaldo();
    pedro.depositar();
    pedro.transferir();

    paulo.verSaldo();
    paulo.transferir();
    paulo.transferir();
    paulo.transferir();

    americo.verSaldo();
    xingling.verSaldo();
  }
}
