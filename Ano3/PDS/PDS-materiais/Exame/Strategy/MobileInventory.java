import java.util.ArrayList;
import java.util.List;

public class MobileInventory {
  private List<Mobile> mobileList;

  public MobileInventory() {
    mobileList = new ArrayList<>();
  }

  public void addMobile(Mobile m) {
    mobileList.add(m);
  }

  public List<Mobile> getMobiles() {
    return getMobiles(new QuickSorting());
  }

  public List<Mobile> getMobiles(Sorting s) {
    return getMobiles(s, SpecType.PRECO);
  }

  public List<Mobile> getMobiles(Sorting s, SpecType spec) {
    return s.sort(mobileList, spec);
  }
}
