import java.io.File;
import java.io.FileNotFoundException;

public class ex2 {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("test.txt");
        TextReader t = new TextReader(f);
        t.hasNext();
        VowelFilter vf = new VowelFilter(t);
        System.out.println(t.next());
        NormalizationFilter nf = new NormalizationFilter(t);
        System.out.println(nf.next());
        System.out.println(nf.hasNext());
        System.out.println(vf.next());
        CapitalizationFilter cf = new CapitalizationFilter(t);
        System.out.println(cf.next());
        
    }
}
