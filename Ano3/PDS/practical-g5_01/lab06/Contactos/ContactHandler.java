import java.util.ArrayList;

public class ContactHandler implements ContactsInterface {
    ArrayList<Contact> contacts = new ArrayList<Contact>();
    ContactsStorageInterface store;

    public void openAndLoad(ContactsStorageInterface store) {
        this.store = store;
        for (Contact c : store.loadContacts()) {
            System.out.println(c);
            this.contacts.add(c);
        }
    }

    public void saveAndClose() {
        if (!this.store.saveContacts(this.contacts)) {
            System.out.println("An error has occurred: couldn't save the file.");
        } else {
            System.out.println("Saved.");
        }
    }

    public void saveAndClose(ContactsStorageInterface store) {
        if (!store.saveContacts(this.contacts)) {
            System.out.println("An error has occurred: couldn't save the file.");
        } else {
            System.out.println("Saved.");
        }
    }

    public boolean exist(Contact contact) {
        return this.contacts.contains(contact);
    }

    public Contact getByName(String name) {
        for (Contact c : this.contacts) {
            if (c.getName().equals(name)) {
                return c;
            }
        }
        System.out.println("An error has occurred: the given name isn't present in any contact.");
        return null;
    }

    public boolean add(Contact contact) {
        return this.contacts.add(contact);
    }

    public boolean remove(Contact contact) {
        return this.contacts.remove(contact);
    }
}