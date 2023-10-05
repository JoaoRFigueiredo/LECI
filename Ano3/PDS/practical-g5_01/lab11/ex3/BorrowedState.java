package lab11.ex3;

public class BorrowedState implements State{

    @Override
    public void register(Book book) {
        // TODO Auto-generated method stub
        System.out.println("Operação não disponível"); 
    }

    @Override
    public void request(Book book) {
        // TODO Auto-generated method stub
        System.out.println("Operação não disponível"); 
    }

    @Override
    public void returnBook(Book book) {
        // TODO Auto-generated method stub
        book.setState(new AvailableState());
    }

    @Override
    public void cancelReservation(Book book) {
        // TODO Auto-generated method stub
        System.out.println("Operação não disponível"); 
    }

    @Override
    public void reservation(Book book) {
        // TODO Auto-generated method stub
        System.out.println("Operação não disponível"); 
    }

    public  String toString(){
        return "[Emprestado]";
    }
    
}
