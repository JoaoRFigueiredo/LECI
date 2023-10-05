import java.util.HashMap;
import java.util.Map;

public class Banco {
  private Moeda moedaReferencia;
  private Map<Moeda, Double> taxasCambio;
  private Map<String, Cliente> clientes;

  public Banco(Moeda moedaReferencia) {
    this.moedaReferencia = moedaReferencia;

    this.taxasCambio = new HashMap<>();
    this.taxasCambio.put(moedaReferencia, 1.0);

    this.clientes = new HashMap<>();
  }

  public void setTaxaCambio(Moeda moeda, Double valor) {
    if (moeda != moedaReferencia)
      taxasCambio.put(moeda, valor);
  }

  public boolean aplicarMovimento(Movimento m) {
    if (!clientes.containsKey(m.getDestinoId()))
      return false;

    Cliente origem = clientes.get(m.getOrigemId());
    Cliente destino = clientes.get(m.getDestinoId());
    Double valorRecebido = converteMontante(origem != null ? origem.getMoeda() : destino.getMoeda(), destino.getMoeda(),
        m.getMontante());

    if (!((origem == null || origem.getSaldo() - m.getMontante() > 0) && destino.getSaldo() + valorRecebido > 0))
      return false;

    if (origem != null && !origem.addSaldo(-m.getMontante()))
      return false;

    if (!destino.addSaldo(valorRecebido))
      return false;

    return true;
  }

  public ClienteTerminal registarCliente(String id, Moeda m) {
    if (!clientes.containsKey(id))
      clientes.put(id, new Cliente(m));

    return new ClienteTerminal(new ClienteProxy(this, id));
  }

  public Double consultarSaldo(String id) {
    if (clientes.containsKey(id))
      return clientes.get(id).getSaldo();
    return null;
  }

  private Double converteMontante(Moeda moedaOrigem, Moeda moedaDestino, Double montante) {
    if (!taxasCambio.containsKey(moedaOrigem) || !taxasCambio.containsKey(moedaDestino))
      return null;

    return montante * taxasCambio.get(moedaDestino) / taxasCambio.get(moedaOrigem);
  }

}
