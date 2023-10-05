package v2;

import java.text.Normalizer;
import java.text.Normalizer.Form;

public class NormalizationFilter extends FilterDecorator {  

  @Override
  public String next() {
    // TODO Auto-generated method stub
    return Normalizer.normalize(this.next(), Form.NFD).replaceAll("[^\\p{ASCII}]", "");
  }

}
