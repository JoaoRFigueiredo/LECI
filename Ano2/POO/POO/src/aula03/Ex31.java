package aula03;

import java.util.Scanner;


public class Ex31 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
       
        double np, nt;
        while(true){
        System.out.println("Insira a nota prática: ");
        np = sc.nextDouble();
        System.out.println("Insira a nota teórica: ");
        nt = sc.nextDouble();
        if ((np >=0.0 && np <= 20.0) && (nt >=0.0 && nt<= 20.0)){
            break;
        }
        System.out.println("Dados inválidos, por favor insira-os outra vez!");
        }
        
        nt = Math.round(nt*10)/10.0;
        np = Math.round(np*10)/10.0;
        //System.out.println(nt+" "+np);
        double nf;

        if(nt < 7.0 || np < 7.0){
            nf = 66.0;
        }
        else{
        nf = 0.4*nt + 0.6*np;
        nf = Math.round(nf);
        }

        System.out.printf("\nNota Final: %d", (int)nf);
        sc.close();

    }
    
}
