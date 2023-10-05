import java.util.Scanner;

public class TermFilter extends ReaderDecorator{

    public TermFilter(ReaderInterface readerInterface) {
        super(readerInterface);
    }

    public boolean hasNext(){
        return super.hasNext();
    }

    public String next(){
        return term_next(super.next());
    }

    private String term_next(String s){
        Scanner sl = new Scanner(s);
        return sl.next();
    }
    
}
