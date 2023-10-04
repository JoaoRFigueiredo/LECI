import static java.lang.System.*;

public class DatasPassadas {

  public static void main(String[] args) {
    Data natal = new Data(25, 12, 2019);
    Data atual = new Data();
    while ((natal.ano() != atual.ano()) || (natal.mes() != atual.mes())  || (natal.dia() != atual.dia())){
      natal.seguinte();
      System.out.println(natal);
    }

      
    
  }
  }
   
      
    
    
    

  
    
    //...
  



