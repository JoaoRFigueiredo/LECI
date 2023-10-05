import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class binParser implements ContactsStorageInterface {

     private String fname;

     public binParser(String fname) {
         this.fname = fname;
     }
 
     public List<Contact> loadContact() {
         List<Contact> contact_list = new ArrayList<>();
 
         try {
             Path fpath = Paths.get(this.fname);
             BufferedReader reader = new BufferedReader(new FileReader(fpath.toString()));
 
             String line = reader.readLine();
 
             while (line != null) {
 
                 String[] contact_info = line.split("\t");
                 Contact c = new Contact(contact_info[0], Integer.parseInt(contact_info[1]));
                 contact_list.add(c);
                 line = reader.readLine();
             }
 
             reader.close();
 
         } catch (FileNotFoundException e) {
             System.out.println("An error occurred.");
             e.printStackTrace();
         } catch (IOException e) {
             e.printStackTrace();
         }
         return contact_list;
     }
 
     public boolean saveContacts(List<Contact> list) {
 
         try {
             Path fpath = Paths.get(this.fname);
             BufferedWriter bwriter = new BufferedWriter(new FileWriter(fpath.toString()));
 
             for (Contact c : list) {
               String result = convertStringToBinary(c.toString() + "\n");
               bwriter.write(result);
             }
             bwriter.close();
 
         } catch (IOException e) {
             e.printStackTrace();
             return false;
         }
         return true;
 
     };

     public static String convertStringToBinary(String input) {

          StringBuilder result = new StringBuilder();
          char[] chars = input.toCharArray();
          for (char aChar : chars) {
              result.append(
                      String.format("%8s", Integer.toBinaryString(aChar))   // char -> int, auto-cast
                              .replaceAll(" ", "0")                         // zero pads
              );
          }
          return result.toString();
  
      }

}

