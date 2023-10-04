import java.util.*;
import java.io.*;

public class problema1 {
    static Scanner kb = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int numElem = 0;
        int[] tempValues = new int[31];
        int[] humiValues = new int[31];
        dados[] valores = new dados[31];
        int temp, humi;

        File fin;

       // int[] histH = new int[101];
        

        int opcao;
        System.out.printf("Estacao metereologica\n\n");
			System.out.printf("1 - Ler Ficheiros de dados\n");
			System.out.printf("2 - Acrescentar medida\n");
			System.out.printf("3 - Listar valores de temperatura e humidade\n");
			System.out.printf("4 - Listar medidas ordenadas por valor de temperatura\n");
			System.out.printf("5 - Listar medidas ordenadas por valor de humidade\n");
			System.out.printf("6 - Calcular valores medios de temperatura e humidade\n");
			System.out.printf("7 - Calcular valores maximos e minimos de temperatura e humidade\n");
			System.out.printf("8 - Calcular histograma das temperaturas e humidade\n");
			System.out.printf("9 - Terminar o programa\n");
			System.out.println();
			System.out.println("-------------------------------------------");
            System.out.println();
            

            do{	
                System.out.println();
                System.out.printf("Opcao -> ");
                opcao = kb.nextInt(); //le a opcao escolhida
                
                switch(opcao){
                    case 1:



                    System.out.println("Insira o nome do ficheiro do qual dexseja retirar os valores.");
                    String nome = kb.next(); 
                    fin = new File(nome);
                    Scanner fich = new Scanner(fin);
                    String line;
                    String[] arr;
                    int i = 0;


                    while (fich.hasNextLine()){

                        line = fich.nextLine();
                        arr = line.split(" ");
                        valores[i] = new dados();
                        tempValues[i] = Integer.parseInt(arr[0]);
                        humiValues[i] = Integer.parseInt(arr[1]);
                        valores[i].temp = tempValues[i];
                        valores[i].humi = humiValues[i];
                        i++;
                        numElem++;

                    }

                    fich.close();
                    break;

                    case 2: // adicionar medidas
                    if (numElem < 32){;
                        boolean isValid;
                        do{
                            isValid = false;
                        System.out.println("Valor da temperatura: ");
                        temp = kb.nextInt();

                        System.out.println("Valor da humi: ");
                        humi = kb.nextInt();

                        isValid = isValid(temp, humi);
                        if (isValid){
                            valores[numElem] = new dados();
                            valores[numElem].temp = temp;
                            valores[numElem].humi = humi;
                            tempValues[numElem] = temp;
                            humiValues[numElem] = humi;
                            numElem++;
                        }
                        else{
                            System.out.println("Valores invalidos");
                        }
                        
                        

                        
                        
                    }while(!isValid);

                        

                    }
                    else{
                        System.out.println("Ja nao e possivel adicionar mais elementos.");
                    }
                    

                    break;

                    case 3:

                    System.out.print("Valores de temperatura registados: ");
                    System.out.print(tempValues[0]);
                    for ( int j = 1; j<numElem; j++){
                        System.out.print(", "+tempValues[j]);
                    }

                    System.out.println();

                    System.out.print("Valores de humidade registados:    ");
                    System.out.print(humiValues[0]);
                    for ( int f = 1; f<numElem; f++){
                        System.out.print(", "+humiValues[f]);
                    }


                    

                    break;

                    case 4:

                    break;

                    case 5:

                    break;

                    case 6:// medias 

                    double totalt = 0, totalh = 0;
                    for ( int l = 0; l<numElem; l++){
                        totalt += tempValues[l];
                        totalh += humiValues[l];


                    }
                    double mediat, mediah;
                    mediat = totalt / numElem;
                    mediah = totalh / numElem;
                    System.out.println("Valor medio da temperatura: "+ mediat);
                    System.out.println("Valor medio da humidade   : "+ mediah);


                    


                    break;

                    case 7:// max e min

                    int maxt = tempValues[0], maxh = humiValues[0], mint = tempValues[0], minh = humiValues[0];
                    for (int h = 1; h<numElem; h++){
                        if (tempValues[h] > maxt){
                            maxt = tempValues[h];
                        }

                        if (tempValues[h] < mint){
                            mint = tempValues[h];
                        }

                        if (humiValues[h] > maxh){
                            maxh = humiValues[h];
                        }

                        if (humiValues[h] < minh){
                            minh = humiValues[h];
                        }
                    }

                        System.out.println("Valor temp max --> "+ maxt);

                        System.out.println("Valor temp min --> "+ mint);
                        System.out.println("Valor humi max --> "+ maxh);
                        System.out.println("Valor humi min --> "+ minh);


                        


                    


                    break;

                    case 8:
                    System.out.println("Histograma da humidade:");
                    System.out.println("----------------------------");
                    for(int j=0;j<=100;j++){
						System.out.printf("%02d |",j);
						for(int k=0;k<=numElem;k++){
							if(humiValues[k]==j) System.out.print("*");
						}
						System.out.println();
                    }
						System.out.println();

                    
                    System.out.println("Histograma da temperatura:");
                    System.out.println("----------------------------");
                    for(int j=-10;j<=40;j++){
						System.out.printf("%02d |",j);
						for(int k=0;k<=numElem;k++){
							if(tempValues[k]==j) System.out.print("*");
						}
						System.out.println();
					}

                    break;

                    case 9:
                    System.exit(1);

                    break;


        
    }
    
}while(opcao!=9);
}

public static  boolean isValid(int temp, int humi){
    boolean valid = false;
    if ((temp> -11 && temp < 41) && (humi > -1 && humi < 101)){
         valid = true;
    }

    return valid;

}
}

class dados{
    int temp;
    int humi;
}