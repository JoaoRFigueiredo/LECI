import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class ContactListBin implements ContactsStorageInterface {
    private String fileName;

    public ContactListBin(String fileName) {
        this.fileName = fileName;
    }

    public List<Contact> loadContacts(){
        List<Contact> contact_list = new ArrayList<Contact>();

        try {
            Path filePath = Paths.get(this.fileName);
            BufferedReader reader = new BufferedReader(new FileReader(filePath.toString()));

            String line = reader.readLine();

            String[] contact_info = {};
            while (line != null) {
                contact_info = BinToStr(line).split("\t");
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
        String data = "";
        for (Contact contact : list){
            data = data + StrToBin(contact.toString())+ "\n";
        }
        try {
            Path filePath = Paths.get(this.fileName);
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

    public static String StrToBin(String text) {
        String bString="";
        String temp="";
        for(int i=0;i<text.length();i++)
        {
            temp=Integer.toBinaryString(text.charAt(i));
            for(int j=temp.length();j<8;j++)
            {
                temp="0"+temp;
            }
            bString+=temp+" ";
        }

        System.out.println(bString);
        return bString;
    }

    public static String BinToStr(String binaryCode) {
        String[] code = binaryCode.split(" ");
        String word="";
        for(int i=0;i<code.length;i++)
        {
            word+= (char)Integer.parseInt(code[i],2);
        }
        System.out.println(word);
        return word;
    }
}