import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Ex2 {
    public static void main(String[] args) {
        System.out.println("------------------TXT TEST------------------");
        try {
            File file = new File("contacts.txt");
            file.createNewFile();
            FileWriter myWriter = new FileWriter(file.toString());

            myWriter.write("André\t932224001\n");
            myWriter.write("João\t966457947\n");
            myWriter.write("Beatriz\t93487551\n");
            myWriter.write("Luís\t918111548\n");
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        ContactListTXT contacts = new ContactListTXT("contacts.txt");
        ContactHandler lista = new ContactHandler();

        

        
        lista.openAndLoad(contacts);

        Contact c1 = new Contact("Inês", 933333333);
        lista.add(c1);
        lista.add(new Contact("Leo", 911111111));
        lista.remove(lista.getByName("André"));

        System.out.println("Is João in Contacts? " + lista.exist(lista.getByName("João")));
        System.out.println("Is Inês in Contacts? " + lista.exist(c1));
        lista.remove(c1);
        System.out.println("Is Inês still in Contacts after removing? " + lista.exist(c1));


        lista.saveAndClose();


        System.out.println("------------------BIN TEST------------------");

        try {
            File file2 = new File("contacts2.txt");
            file2.createNewFile();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        ContactListBin contacts2 = new ContactListBin("contacts2.txt");
        lista.saveAndClose(contacts2);

        ContactHandler lista2 = new ContactHandler();
        lista2.openAndLoad(contacts2);

        Contact c2 = new Contact("Inês", 933333333);
        lista2.add(c2);
        lista2.add(new Contact("Leo", 911111111));
        //lista2.remove(lista2.getByName("André"));

        System.out.println("Is João in Contacts? " + lista2.exist(lista2.getByName("João")));
        System.out.println("Is Inês in Contacts? " + lista2.exist(c2));
        lista2.remove(c2);
        System.out.println("Is Inês still in Contacts after removing? " + lista2.exist(c2));

        lista2.saveAndClose();
    }
}