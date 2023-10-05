import java.util.ArrayList;
import java.util.List;
public class ContactInterImplementation implements ContactsInterface{
     protected List<Contact> contacts;
     protected ContactsStorageInterface storage;

     public ContactInterImplementation(){
          this.contacts=new ArrayList<Contact>();
          
     }

     @Override
     public void openAndLoad(ContactsStorageInterface store) {
          // TODO Auto-generated method stub
          this.storage = store;
          this.contacts.addAll(storage.loadContact());

          System.out.println("Loaded Contacts:");

          for (Contact contact : contacts) {
                System.out.println(contact);
            }
     }

     @Override
     public void saveAndClose() {
          // TODO Auto-generated method stub
          boolean stored = this.storage.saveContacts(this.contacts);

          if (stored == true) {
               System.out.println("|||Stored|||");
          } else {
               System.out.println("|||Not Stored|||");
          }
     }

     @Override
     public void saveAndClose(ContactsStorageInterface store) {
          // TODO Auto-generated method stub
          boolean stored = store.saveContacts(this.contacts);

          if (stored == true) {
               System.out.println("|||Stored|||");
          } else {
               System.out.println("|||Not Stored|||");
          }
     }

     @Override
     public boolean exist(Contact contact) {
          // TODO Auto-generated method stub
          for (Contact c : this.contacts) {

               if (c.toString().equals(contact.toString())) {
                   return true;
               }

           }
           return false;
     }

     @Override
     public Contact getByName(String name) {
          // TODO Auto-generated method stub
          for (Contact c : this.contacts) {

               if (c.getName().equals(name)) {
                   return c;
               }
           }
           System.out.println("Contact not found!");
           return null;
     }

     @Override
     public boolean add(Contact contact) {
          // TODO Auto-generated method stub
          return this.contacts.add(contact);
     }

     @Override
     public boolean remove(Contact contact) {
          // TODO Auto-generated method stub
          return this.contacts.remove(contact);
     }
     
     
     
}