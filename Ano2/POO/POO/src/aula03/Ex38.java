package aula03;


public class Ex38 {
    public static void main(String[] args){
    double[][] notas = new double[16][2];
    double nf, nt, np;
    //criar notas aleatoriamente(1º coluna --> nota teorica; 2ª coluna nota prática)
    for(int i = 0; i<16; i++){
        for(int j = 0; j<2; j++){
        notas[i][j] =Math.round( (Math.random()*20)*10)/10.0;
        }
    }
    //processar as notas 
    System.out.println("Nota T\tNota P\tNota F");
    for (int i = 0; i<16; i++){
        nt = notas[i][0];
        np = notas[i][1];
        if(nt < 7.0 || np < 7.0){
            nf = 66.0;
        }
        else{
        nf = 0.4*nt + 0.6*np;
        }
        nf = Math.round(nf);
       
        System.out.printf("\n %.1f\t%.1f\t%d", nt, np, (int)nf);



    }
}
}
