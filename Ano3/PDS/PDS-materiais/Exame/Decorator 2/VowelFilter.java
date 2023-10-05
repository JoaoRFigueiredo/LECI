package v2;
public class VowelFilter implements FilterDecorator {

  @Override
  public String next() {
    // TODO Auto-generated method stub
    return this.next().replaceAll("[aeiouAEIOU]", "");
  }

}
