package contacts;


import contacts.constants.StringEnum;
import contacts.db.DataBaseImitator;
import contacts.entity.Contact;
import contacts.entity.ContactBook;
import contacts.utils.ConsoleUtils;

import static contacts.utils.ConsoleUtils.printMessageln;
import static contacts.utils.ConsoleUtils.readLine;

//TODO adding menu bar

public class ContactManager {

    private static final ContactBook CONTACT_BOOK = new ContactBook();


    public void runApplication() {
        createUserScenario();
    }


    private void createUserScenario() {
        boolean doNotExit = true;
        do {
            printMessageln(StringEnum.MENU_BAR.getValue());

            switch (ConsoleUtils.readLine().toUpperCase()) {
                case "ADD": {
                    openAddMenu();


                }
                case "REMOVE": {
                }

                case "EDIT": {
                }

                case "COUNT": {
                    if (DataBaseImitator.countDbContact() == 1) {
                        printMessageln(StringEnum.PB_WITH_SINGLE_REC_CREATED.getValue(), "single");
                    } else {
                        printMessageln(StringEnum.PHONE_BOOK_IS_EMPTY.getValue());
                    }
                }

                case "list": {
                }
            }
        } while (doNotExit);
    }

    private void openAddMenu() {
        //boolean doNotStop = false;

        printMessageln(StringEnum.ENTER_NAME_PERSON.getValue());
        String name = readLine();


        printMessageln(StringEnum.ENTER_SURNAME_PERSON.getValue());
        String surName = readLine();


        printMessageln(StringEnum.ENTER_THE_NUMBER.getValue());
        String phoneNumber = readLine();


        if (DataBaseImitator.createContact(new Contact(name, surName, phoneNumber))) {
            printMessageln(StringEnum.RECORD_CREATED.getValue());
        }
        // do {
        // }while (doNotStop);

    }


    private void commandAddPerson() {


    }


}