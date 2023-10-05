package v2;
public class CapitalizationFilter implements FilterDecorator {

  @Override
  public String next() {
    // TODO Auto-generated method stub
    String completeText = this.next().toLowerCase();
    return completeText.substring(0, 1).toUpperCase() + completeText.substring(1, completeText.length() - 1)
        + completeText.substring(completeText.length() - 1, completeText.length()).toUpperCase();
  }

}
