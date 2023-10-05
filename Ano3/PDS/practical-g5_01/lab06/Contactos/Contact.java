
public class Contact {
    private String name;
    private int num;


    public Contact(String name, int num){
        this.name = name;
        this.num = num;
    }


    public int getNum(){
        return num;
    }

    public String getName(){
        return name;
    }

    public void setName(String newName){
        this.name = newName;
    }

    public void setNum(int newNum){
        this.num = newNum;
    }

    public String toString(){
        return name+"\t"+num;
    }
}
