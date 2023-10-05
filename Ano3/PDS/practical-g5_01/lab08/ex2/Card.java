public class Card {
    private static int employeeID = 0;
    private int cardID;
    private String name;

    public Card(String name){
        this.name = name;
        this.cardID = ++employeeID;
    }

    public String getCard(){
        return "Name: "+name +"\nCardID: "+cardID;
    }

    
    
}
