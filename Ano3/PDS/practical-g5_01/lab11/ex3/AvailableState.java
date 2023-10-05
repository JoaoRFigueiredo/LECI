package lab11.ex3;


public class AvailableState implements State{

    @Override
    public void register(Book book) {
        // TODO Auto-generated method stub
        System.out.println("Operação não disponível"); 
    }

    @Override
    public void request(Book book) {
        // TODO Auto-generated method stub
        book.setState(new BorrowedState());
    }

    @Override
    public void returnBook(Book book) {
        // TODO Auto-generated method stub
        System.out.println("Operação não disponível"); 
    }

    @Override
    public void cancelReservation(Book book) {
        // TODO Auto-generated method stub
        System.out.println("Operação não disponível"); 
    }

    @Override
    public void reservation(Book book) {
        // TODO Auto-generated method stub
        book.setState(new ReservationState());
    }

    public  String toString(){
        return "[Disponível]";
    }
    
}
