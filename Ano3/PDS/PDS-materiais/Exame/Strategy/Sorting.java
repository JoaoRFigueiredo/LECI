import java.util.List;

// Strategy Pattern
public interface Sorting {
  public List<Mobile> sort(List<Mobile> c, SpecType specType);
}