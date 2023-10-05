public class VowelFilter extends ReaderDecorator{

    public VowelFilter(ReaderInterface readerInterface) {
        super(readerInterface);
    }

    public boolean hasNext(){
        return super.hasNext();
    }

    public String next(){
        return vowel_next(super.next());
    }

    private String vowel_next(String s){
        return s.replaceAll("[aeiouAEIOU]", "");
    }
    
}
