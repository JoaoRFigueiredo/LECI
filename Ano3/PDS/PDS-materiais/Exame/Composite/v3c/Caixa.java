package v3.v3c;

import java.util.ArrayList;

import org.w3c.dom.NamedNodeMap;


public class Caixa extends Item {
     private ArrayList<Item> children= new ArrayList<Item>();
     private String name;
     private float weight;
     private float totalweight;
     public Caixa(String name, float weight){
          this.name=name;
          this.weight=weight;
     }
     public void add(Item newitem){
          children.add(newitem);
     }
     public void draw(){
          System.out.println(indent.toString() + print());
		indent.append("  ");
          for(Item it:children){
               totalweight+= 1.0;
               
               if(it instanceof Caixa){
                    ((Caixa) it).draw();

               }else{
                    System.out.println(indent.toString() + it.print());
               }
          }
          indent.setLength(indent.length() - 2);

     }
     public String print() {
          return "* Caixa "+ name+ " [ Weight: "+weight + " ; Total : " + getweight()     + "]";
     }
     public float getweight(){
          int totalweight = 0;
          for(Item it:children)
               totalweight+= it.getweight();
          return weight + totalweight;
     }


}

	
	