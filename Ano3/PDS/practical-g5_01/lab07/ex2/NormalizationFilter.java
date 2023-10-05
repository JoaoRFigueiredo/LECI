import java.text.Normalizer;

public class NormalizationFilter extends ReaderDecorator{

    public NormalizationFilter(ReaderInterface readerInterface) {
        super(readerInterface);
    }

    public boolean hasNext(){
        return super.hasNext();
    }

    public String next(){
        return normalization_next(super.next());
    }

    private String normalization_next(String s){
        s = Normalizer.normalize(s, Normalizer.Form.NFD);
        s = s.replaceAll("[^a-zA-Z ]", "");
        return s;
    }
    
}
