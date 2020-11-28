package contacts;


import contacts.constants.StringEnum;
import contacts.db.DataBaseImitator;
import contacts.entity.Contact;

import static contacts.utils.ConsoleUtils.printMessageln;
import static contacts.utils.ConsoleUtils.readLine;

public class ContactManager {
    private boolean isRunning = true;


    public void runApplication() {
        createUserScenario();
    }


    private void createUserScenario() {
        //TODO create cycle in app
        String command;
        do {
            printMessageln(StringEnum.MENU_BAR.getValue());
            command = readLine();
            switch (command) {
                case "add": {
                    printMessageln(StringEnum.ENTER_NAME_PERSON.getValue());
                    String name = readLine();


                    printMessageln(StringEnum.ENTER_SURNAME_PERSON.getValue());
                    String surName = readLine();


                    printMessageln(StringEnum.ENTER_THE_NUMBER.getValue());
                    String phoneNumber = readLine();


                    if (DataBaseImitator.createContact(new Contact(name, surName, phoneNumber))) {
                        printMessageln(StringEnum.RECORD_CREATED.getValue());

                        isRunning = true;

                    }


                }
                case "remove": {
                }

                case "edit": {
                }

                case "count": {
                    if (DataBaseImitator.countDbContact() == 1) {
                        printMessageln(StringEnum.PB_WITH_SINGLE_REC_CREATED.getValue(), "single");
                    } else {
                        printMessageln(StringEnum.PHONE_BOOK_IS_EMPTY.getValue());
                    }

                }

                case "list": {
                }


            }
        } while (!command.equals("exit"));
    }
}