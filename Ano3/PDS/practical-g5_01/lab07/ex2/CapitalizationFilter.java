public class CapitalizationFilter extends ReaderDecorator{

    public CapitalizationFilter(ReaderInterface readerInterface) {
        super(readerInterface);
    }
    
    public boolean hasNext(){
        return super.hasNext();
    }

    public String next(){
        return capitalization_next(super.next());
    }

    private String capitalization_next(String s){
        String f = s.substring(0, 1).toUpperCase();
        String l = s.substring(s.length()-1, s.length()).toUpperCase();
        String m = s.substring(1, s.length()-1);
        return f+m+l;
    }
    
}
