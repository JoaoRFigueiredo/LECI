import java.util.List;

public interface ContactsStorageInterface {

     public List<Contact> loadContact();
     public boolean saveContacts(List<Contact> list);
}