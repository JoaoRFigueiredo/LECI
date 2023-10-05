import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TextReader implements ReaderInterface{

    protected File f;
    Scanner sf;
    
    public TextReader(File f) throws FileNotFoundException{
        this.f = f;
        sf = new Scanner(f);
    }

    @Override
    public boolean hasNext() {
        return sf.hasNext();
    }

    @Override
    public String next() {
        return sf.nextLine();
    }
    
}
