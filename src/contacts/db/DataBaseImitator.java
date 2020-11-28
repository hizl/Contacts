package contacts.db;

import contacts.entity.Contact;

import java.util.*;


public class DataBaseImitator {
    private static final List<Contact> CONTACT_LIST = new ArrayList<>();

    public static List<Contact> getContactList() {
        return CONTACT_LIST;
    }

    public static boolean createContact(Contact contact) {
        return CONTACT_LIST.add(contact);
    }

    public static boolean deleteContact(Contact contact) {
        return CONTACT_LIST.remove(contact);
    }

    public static int countDbContact() {
        return CONTACT_LIST.size();
    }
}