package lab11.ex3;

public interface State {
    //void pull(Book wrapper);
    void register(Book book);
    void request(Book book);
    void returnBook(Book book);
    void cancelReservation(Book book);
    void reservation(Book book);
    
}
