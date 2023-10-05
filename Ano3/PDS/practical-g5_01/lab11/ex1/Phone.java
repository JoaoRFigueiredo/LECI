package lab11.ex1;

public class Phone {
    private String cpu;
    private double price;
    private int memory;
    private String camera;

    public Phone(String cpu, double price, int memory, String camera){
        this.cpu = cpu;
        this.price = price;
        this.memory = memory;
        this.camera = camera;
    }

    public String getCpu(){
        return cpu;
    }

    public double getPrice(){
        return price;
    }

    public int getMemory(){
        return memory;
    }

    public String getCamera(){
        return camera;
    }



    
    
    
}
