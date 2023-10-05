import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;

public class ContactListTXT implements ContactsStorageInterface{
    private String filename;


    public ContactListTXT(String filename){
        this.filename = filename;
    }

    public List<Contact> loadContacts(){
        List<Contact> contactList = new ArrayList<>();

        try{
            //System.out.println(filename);
            File fin = new File(this.filename);
            Scanner sc = new Scanner(fin);

            while (sc.hasNextLine()){
                String[] contactInfo = sc.nextLine().split("\t");
                Contact con = new Contact(contactInfo[0], Integer.parseInt(contactInfo[1]));
                contactList.add(con);
            
            }
            sc.close();
            
        }catch(FileNotFoundException e){
            System.err.println("An error has ocurred: file doesn't exist.");
            return null;
        }
        
        //System.out.println(contactList.size());
        return contactList;
    }


    public boolean saveContacts(List<Contact> list) {
        String data = "";
        for (Contact contact : list){
            data = data + contact.toString() + "\n";
        }
        try {
            Path filePath = Paths.get(this.filename);
            BufferedWriter bwriter = new BufferedWriter(new FileWriter(filePath.toString()));
            bwriter.write(data);
            bwriter.close();
        } catch (IOException e) {
            System.out.println("An error has occurred: couldn't write to file.");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    
    
}
