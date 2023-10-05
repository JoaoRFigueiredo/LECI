
public class Client {
    private String number;
    private String name;


    public Client(String number, String name) {
        this.number = number;
        this.name = name;
    }

    public String number() {
        return number;
    }

    public String name() {
        return name;
    }

    //To string
    @Override
    public String toString() {
        return "Client [number=" + number + ", name=" + name + "]";
    }


}
