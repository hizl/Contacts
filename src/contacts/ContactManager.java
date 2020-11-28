package contacts;


import contacts.constants.StringEnum;
import contacts.db.DataBaseImitator;
import contacts.entity.Contact;

import static contacts.utils.ConsoleUtils.printMessageln;
import static contacts.utils.ConsoleUtils.readLine;

public class ContactManager {
    public void runApplication() {
        createUserScenario();
    }

    private void createUserScenario() {
        printMessageln(StringEnum.ENTER_NAME_PERSON.getValue());
        String name = readLine();
        printMessageln(StringEnum.ENTER_SURNAME_PERSON.getValue());
        String surName = readLine();
        printMessageln(StringEnum.ENTER_THE_NUMBER.getValue());
        String phoneNumber = readLine();

        if (DataBaseImitator.createContact(new Contact(name, surName, phoneNumber))) {
            printMessageln(StringEnum.RECORD_CREATED.getValue());
        }
        if (DataBaseImitator.countDbContact() == 1) {
            printMessageln(StringEnum.PB_WITH_SINGLE_REC_CREATED.getValue(), "single");
        }
    }
}