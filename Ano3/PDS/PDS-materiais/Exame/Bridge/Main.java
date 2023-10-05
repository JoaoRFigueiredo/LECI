import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main{

    public static void main(String[] args) {

        try {
            File file = new File("contacts.txt");
            file.createNewFile();
            FileWriter myWriter = new FileWriter(file.toString());
            myWriter.write("Pedron\t912332444\n");
            myWriter.write("Pablito\t911311311\n");
            myWriter.write("Broges\t999999999\n");
            myWriter.write("Nunao\t111111111\n");
            myWriter.close();
          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }

          TxtParser contacts = new TxtParser("contacts.txt");

          ContactInterImplementation lista = new ContactInterImplementation();
  
          lista.openAndLoad(contacts);
  
          Contact c1 = new Contact("Tadolas", 929292929);
          lista.add(c1);
          lista.add(new Contact("Artur", 955955955));


          lista.remove(c1);
          lista.remove(lista.getByName("Broges"));

          System.out.println("Is Pablito in Contacts?   "+lista.exist(lista.getByName("Pablito")));
          System.out.println("Is Artur in Contacts?   "+lista.exist(c1));

          lista.saveAndClose();

          try {
            File file2 = new File("contacts2.txt");
            file2.createNewFile();
          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }

          binParser contacts2 = new binParser("contacts2.txt");

          lista.saveAndClose(contacts2);

          ContactInterImplementation contactApi2 = new ContactInterImplementation();

          contactApi2.openAndLoad(contacts2);

    }
}