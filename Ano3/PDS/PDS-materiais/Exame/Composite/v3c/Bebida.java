package v3.v3c;

public class Bebida extends Item{
     private String name;
     private float weight;

     public Bebida(String name, float weight){
          this.name=name;
          this.weight=weight;
     }
     public String print(){
          return " Bebida " +name+ "- Weight " + weight;
     }
     public float getweight(){
          return weight;
     }
}

