package v3.v3c;

public class Conserva extends Item{
     private String name;
     private float weight;

     public Conserva(String name, float weight){
          this.name=name;
          this.weight=weight;
     }
     public String print(){
          return " Conserva " +name+ "- Weight " + weight;
     }
     public float getweight(){
          return weight;
     }
}
