package contacts.entity;

import java.util.ArrayList;

public class ContactBook {
    private static final int INITIAL_CAPACITY = 50;
    private ArrayList<Contact> contacts = new ArrayList<>(INITIAL_CAPACITY);


    public final void setContacts(ArrayList<Contact> contacts) {
        this.contacts = new ArrayList<>(contacts);
    }



}
