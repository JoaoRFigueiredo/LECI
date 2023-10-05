package lab5.v2;

public class ChocolateCakeBuilder extends BaseCakeBuilder {

  @Override
  public void addCakeLayer() {
    // TODO Auto-generated method stub
    this.getCake().setCakeLayer("Soft chocolate");
  }

  @Override
  public void addCreamLayer() {
    // TODO Auto-generated method stub
    this.getCake().setMidLayerCream(null);
  }

  @Override
  public void addTopLayer() {
    // TODO Auto-generated method stub
    this.getCake().setTopLayerCream(Cream.Whipped_Cream);
  }

  @Override
  public void addTopping() {
    // TODO Auto-generated method stub
    this.getCake().setTopping(Topping.Fruit);
  }

}
