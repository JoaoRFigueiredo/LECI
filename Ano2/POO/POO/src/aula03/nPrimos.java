package aula03;

public class nPrimos {
    public static void main(String[] args){
        //Imprimmir números primos de forma crescente
        int primo = 1, count, num;
        while(true){
            count = 0;
            num = primo;
            do{
                if(primo % num == 0){
                    count++;
                }
                num--;

            }while(num > 0);
            if(count == 2){
                System.out.println(primo);
            }
            primo++;
            
             }

    }
    
}
