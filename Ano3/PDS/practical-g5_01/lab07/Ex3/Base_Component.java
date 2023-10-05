public abstract class Base_Component implements Component{

    private String name;
    private double weight;


    public Base_Component(String name, double weight){
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public void draw(){
        System.out.println("    "+this.getClass().getSimpleName().toString()+" "+this.name+" - Weight : "+this.weight);
    }

    @Override
    public double getWeight(){
        return weight;
    }

    @Override
    public void add(Component component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(Component component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Component getChild(int index) {
        throw new UnsupportedOperationException();
    }


    @Override
    public String toString() {
        return String.format("%s '%s' - Weight : %.1f", this.getClass().getSimpleName(), name, weight);
    }

    
}
