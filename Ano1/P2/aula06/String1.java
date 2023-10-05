import java.lang.*;

public class String1 {


  public static String reverse(String s) {
    
      int n = s.length();
      if (n<=1) return s;
      else return reverse(s.substring(1, n)) + s.substring(0, 1); 
    }
    
    public static void main(String[] args) {
      // These tests should pass!
      assert reverse("hello").equals("olleh");
      assert reverse("follow").equals("wollof");
      assert reverse("x").equals("x");
      assert reverse("").equals("");
      String f = args[0];
      System.out.print(reverse(f));
    }
  }