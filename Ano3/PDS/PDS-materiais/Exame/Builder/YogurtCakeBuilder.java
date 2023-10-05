package lab5.v2;

public class YogurtCakeBuilder extends BaseCakeBuilder {

  @Override
  public void addCakeLayer() {
    // TODO Auto-generated method stub
    this.getCake().setCakeLayer("Yogurt");
  }

  @Override
  public void addCreamLayer() {
    // TODO Auto-generated method stub
    this.getCake().setMidLayerCream(Cream.Vanilla);
  }

  @Override
  public void addTopLayer() {
    // TODO Auto-generated method stub
    this.getCake().setTopLayerCream(Cream.Red_Berries);
  }

  @Override
  public void addTopping() {
    // TODO Auto-generated method stub
    this.getCake().setTopping(Topping.Chocolate);
  }

}
