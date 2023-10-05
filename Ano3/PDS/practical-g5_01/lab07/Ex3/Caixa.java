import java.util.ArrayList;

public class Caixa extends Base_Component{
    private ArrayList<Component> components ;
    

    public Caixa(String name, double weight){
        super(name, weight);
        components = new ArrayList<>();
    }



    
    public double getTotalWeight(){
        double total = 0;
        for (Component c : components){
            total += c.getWeight();
        }
        return this.getWeight()+total;
    }

   

    public void draw() {
        draw(0);
    }

    private void draw(int depth) {
        System.out.println(this);
        for (Component c : components) {
            System.out.print("   ".repeat(depth + 1));
            if (c instanceof Caixa caixa) {
                caixa.draw(depth + 1);
            } else {
                System.out.println(c);
            }
        }
    }
    

    @Override
    public void add(Component c){
        components.add(c);
    }

    @Override
    public void remove(Component c){
        components.remove(c);
    }

    @Override
    public Component getChild(int index){
        return components.get(index);
    }

    @Override
public String toString() {
    return String.format("* %s '%s' [ Weight : %.1f ; Total: %.1f]",
            this.getClass().getSimpleName(), super.getName(),
            (float) super.getWeight(), (float) getTotalWeight());
}



    
}
