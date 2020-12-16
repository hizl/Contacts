package contacts;


import contacts.constants.StringEnum;
import contacts.db.DataBaseImitator;
import contacts.entity.Contact;
import contacts.utils.ConsoleUtils;


import java.util.ArrayList;
import java.util.List;

import static contacts.utils.ConsoleUtils.*;

class ContactManager {

    Contact contact = new Contact();
    boolean doNotExit = true;

    public void runApplication() {
        createUserScenario();
    }


    private static void createUserScenario() {
        DataBaseImitator dataBaseImitator;
        String command;
        boolean doNotExit = true;
        do {
            printMessageln(StringEnum.MENU_BAR.getValue());
            command = readLine();
            switch (command) {
                case "add": {

                    Contact contact = new Contact
                            .Builder().setName(ConsoleUtils.simplePrint(StringEnum.ENTER_NAME_PERSON.getValue()), ConsoleUtils.readLine())
                            .setSurName(ConsoleUtils.simplePrint(StringEnum.ENTER_SURNAME_PERSON.getValue()), ConsoleUtils.readLine())
                            .setPhoneNumber(ConsoleUtils.simplePrint(StringEnum.ENTER_THE_NUMBER.getValue()), ConsoleUtils.readLine())
                            .build();

                    DataBaseImitator.createContact(contact);

                    if (DataBaseImitator.countDbContact() != 0) {
                        printMessageln(StringEnum.PB_WITH_SINGLE_REC_CREATED.getValue(), "single");
                    }
                }

                case "edit": {
                    if (DataBaseImitator.countDbContact() == 0) {
                        printMessageln(StringEnum.NO_RECORDS_TO_EDIT.getValue());
                        break;
                    }

                }

                case "remove": {
                    if (DataBaseImitator.countDbContact() == 0) {
                        printMessageln(StringEnum.NO_RECORDS_TO_REMOVE.getValue());
                        break;
                    }

                }

                //TODO write and realize this method
                case "count": {
                    if (DataBaseImitator.countDbContact() == 0) {
                        printMessageln(StringEnum.PHONE_BOOK_IS_EMPTY.getValue());
                    } else {
                        for (int i = 1; i < DataBaseImitator.countDbContact(); i++) {
                            System.out.println(i);

                        }
                    }
                }


                case "list": {


                }
            }

        } while (!command.equals("exit"));
    }
}
