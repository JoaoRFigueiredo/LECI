package v2;
public abstract class FilterDecorator implements Filter {
     
  private Filter base;

  public FilterDecorator(Filter base) {
    this.base = base;
  }

  @Override
  public boolean hasNext() {
    // TODO Auto-generated method stub
    return base.hasNext();
  }

  @Override
  public String next() {
    // TODO Auto-generated method stub
    return base.next();
  }

}
