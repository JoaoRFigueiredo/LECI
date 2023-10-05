import java.util.Scanner;

public class ClienteTerminal {
  private ClienteProxy proxy;
  private Scanner sc;

  public ClienteTerminal(ClienteProxy proxy) {
    this.proxy = proxy;
    sc = new Scanner(System.in);
  }

  public void transferir() {
    System.out.print("Número do Destino: ");
    String destinoId = sc.next();

    System.out.print("Montante: ");
    Double montante = sc.nextDouble();

    proxy.transferir(destinoId, montante);

    verSaldo();
  }

  public void depositar() {
    System.out.print("Montante: ");
    Double montante = sc.nextDouble();

    proxy.depositar(montante);

    verSaldo();
  }

  public void verSaldo() {
    System.out.println("Saldo: " + proxy.consultarSaldo());
  }

}
