package lab5.v2;

public class CakeMaster {

  private CakeBuilder builder;

  public void setCakeBuilder(CakeBuilder builder) {
    this.builder = builder;
  }

  public void createCake(String m) {
    builder.addMessage(m);
    builder.createCake();
  }

  public void createCake(int numCakeLayers, String m) {
    builder.getCake().setNumCakeLayers(numCakeLayers);
    this.createCake(m);
  }

  public void createCake(Shape shape, int numCakeLayers, String m) {
    builder.setCakeShape(shape);
    this.createCake(numCakeLayers, m);
  }

  public Cake getCake() {
    return builder.getCake();
  }

}
