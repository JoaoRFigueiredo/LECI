package lab11.ex3;

public class Book {
    private State currentState;
    private String isbn;
    private String title;
    private String firstAuthor;
    private int year;

    public Book(String title, String isbn, int year, String firstAuthor){
        this.title = title;
        this.isbn = isbn;
        this.year = year;
        this.firstAuthor = firstAuthor;
        currentState = new InventoryState();
    }

    public String getFirstAuthor(){
        return firstAuthor;
    }

    public String getTitle(){
        return title;
    }

    public int getYear(){
        return year;
    }

    public String getIsbn(){
        return isbn;
    }

    public State getState(){
        return currentState;
    }

    public void setState(State s){
        currentState = s;
    }

    
    public void register(){
        currentState.register(this);
    }

    public void request(){
        currentState.request(this);
    }

    public void returnBook(){
        currentState.returnBook(this);
    }

    public void cancelReservation(){
        currentState.cancelReservation(this);
    }

    public void reservation(){
        currentState.returnBook(this);
    }

    public String toString() {
        String format = "%-30s %-15s %s";
        return String.format(format, getTitle(), getFirstAuthor(), getState().toString());
    }




}
