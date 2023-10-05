public class Movimento {
  private Double montante;
  private String destinoId;
  private String origemId;
  private TipoMovimento tipoMovimento;

  public Movimento(Double montante, String destinoId, String origemId, TipoMovimento tipoMovimento) {
    this.montante = montante;
    this.destinoId = destinoId;
    this.origemId = origemId;
    this.tipoMovimento = tipoMovimento;
  }

  public Double getMontante() {
    return this.montante;
  }

  public String getDestinoId() {
    return this.destinoId;
  }

  public String getOrigemId() {
    return this.origemId;
  }

  public TipoMovimento getTipoMovimento() {
    return this.tipoMovimento;
  }

}
