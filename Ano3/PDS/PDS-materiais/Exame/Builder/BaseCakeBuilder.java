package lab5.v2;

public abstract class BaseCakeBuilder implements CakeBuilder {

  private Cake cake = new Cake();

  @Override
  public void setCakeShape(Shape shape) {
    // TODO Auto-generated method stub
    this.cake.setShape(shape);
  }

  @Override
  public void addMessage(String m) {
    // TODO Auto-generated method stub
    this.cake.setMessage(m);
  }

  @Override
  public void createCake() {
    // TODO Auto-generated method stub
    this.addCakeLayer();
    this.addCreamLayer();
    this.addTopLayer();
    this.addTopping();
  }

  @Override
  public Cake getCake() {
    // TODO Auto-generated method stub
    return this.cake;
  }
}
