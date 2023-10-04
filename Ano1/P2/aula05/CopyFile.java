import java.io.*;
import java.util.*;




public class CopyFile{
    
    public static void main(String[] args) {
      
      String nome = args[0];
      String nome1 = args[1];
      assert (!nome.equals(nome1)) : "Os ficheiros nao podem ter o mesmo nome, por favor altere-os";
      String resposta;
      File f = new File(nome);
      File f1 = new File(nome1);
      Scanner sc = new Scanner(System.in);
      Scanner tl = new Scanner(System.in);
      int escolhas;
      
      System.out.println("1-->Ver se o ficheiro fonte existe");
      System.out.println("2-->Ler o ficheiro fonte");
      System.out.println("3-->Verificar se o ficheiro alvo existe");
      System.out.println("4-->Copiar ficheiro fonte para o ficheiro alvo");
      System.out.println("5-->Exit");
      System.out.println("O que deseja fazer");
    
    do{
      escolhas = sc.nextInt();
      switch (escolhas) {
          case 1:
          
          if(f.exists()) System.out.println("O ficheiro existe");
          else System.out.println("O ficheiro não existe");
          break;

          case 2:
          if (f.canRead()) System.out.println("O ficheiro foi lido com sucesso");
          else System.out.println("O ficheiro não pode ser lido");
          break;

          case 3:
          if (f1.exists()) System.out.println("O ficheiro alvo existe, deseja possivelmente fazer-lhe alteracoes");
          System.out.println("responda com <sim> ou <nao>");
          System.out.println("Se responder com <nao>, o programa ira terminar, uma vez que nao pretende modificar o ficheiro alvo ");
          

          resposta = tl.nextLine();
          if( resposta.equals("nao")) System.exit(0);
          if (resposta.equals("sim")) System.out.println("Ok"); 
          
          
          
        
          break;

          case 4:
          try{
          FileInputStream source = new FileInputStream(nome);
          FileOutputStream target = new FileOutputStream(nome1);
          
          int bytes;
          while((bytes = source.read()) != -1){
            target.write(bytes);
          }
          source.close();
          target.close();
          System.out.println("o ficheiro "+nome+" foi copiado para o ficheiro "+nome1+" com sucesso");
          }catch(IOException e){
            System.out.println("Ocorreu um erro");
          }
          break;

          case 5:
          System.exit(0);
          break;

          default : 
          System.out.println("\nEsta opcao nao e valida");
          System.out.println("Escolha um opçao entre 1 e 5");


      
      }
    }while(escolhas != 5);

        


  
    }
}