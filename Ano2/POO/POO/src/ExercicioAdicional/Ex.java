package ExercicioAdicional;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Ex {

    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(new FileReader("Alunos.txt"));
        ArrayList<Aluno> lst = new ArrayList<>();
        String alu ="";
        while(input.hasNext()){
            alu = input.nextLine();
            String[] arr = alu.split(",");
            Aluno al = new Aluno(arr[0], Integer.parseInt(arr[1]), Integer.parseInt(arr[2]), new DateYMD(arr[3]), new DateYMD(arr[4]));
            lst.add(al);
            
        }

        System.out.println(lst);
        lst.sort((a1, a2) -> a1.compareTo(a2));
        System.out.println(lst); 

        File f1 = new File("AlunosOrdenados.txt");
        if(f1.createNewFile()){System.out.println("Ficheiro criado");}

        FileWriter fw = new FileWriter(f1);
        for (int i = 0; i<lst.size(); i++){
            Aluno b = lst.get(i);
            fw.write(b.toString()+"\n");

        }

        fw.close();
        input.close();

        

    }
    
}
