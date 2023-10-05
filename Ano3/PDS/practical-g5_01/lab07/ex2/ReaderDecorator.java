public class ReaderDecorator implements ReaderInterface{

    protected ReaderInterface readerInterface;

    public ReaderDecorator(ReaderInterface readerInterface){
        this.readerInterface = readerInterface;
    }

    @Override
    public boolean hasNext() {
        return readerInterface.hasNext();
    }

    @Override
    public String next() {
        return readerInterface.next();
    }
    
}
