package contacts;


import contacts.constants.StringEnum;
import contacts.db.DataBaseImitator;
import contacts.entity.Contact;

import static contacts.utils.ConsoleUtils.printMessageln;
import static contacts.utils.ConsoleUtils.readLine;

//TODO adding menu bar

class ContactManager {
    boolean doNotExit = true;

    public void runApplication() {
        createUserScenario();
    }


    private void createUserScenario() {
        DataBaseImitator dataBaseImitator;
        String command;
        boolean doNotExit = true;
        do {
            printMessageln(StringEnum.MENU_BAR.getValue());
            command = readLine();
            switch (command) {
                case "add": {

                    Contact contact = new Contact();
                    printMessageln(StringEnum.ENTER_NAME_PERSON.getValue());
                    String name;
                    contact.setName(name = readLine());


                    printMessageln(StringEnum.ENTER_SURNAME_PERSON.getValue());
                    String surName;
                    contact.setSurName(surName = readLine());

                    printMessageln(StringEnum.ENTER_THE_NUMBER.getValue());
                    String phoneNumber;
                    contact.setPhoneNumber(phoneNumber = readLine());

                    if (DataBaseImitator.createContact(new Contact(name, surName, phoneNumber))) {
                        printMessageln(StringEnum.RECORD_CREATED.getValue());

                    }

                    if (DataBaseImitator.countDbContact() == 1) {
                        printMessageln(StringEnum.PB_WITH_SINGLE_REC_CREATED.getValue(), "single");
                    }
                }

                case "edit": {
                    if (DataBaseImitator.countDbContact() < 1) {
                        printMessageln(StringEnum.NO_RECORDS_TO_EDIT.getValue());
                        break;
                    }

                }

                case "remove": {
                    if (DataBaseImitator.countDbContact() < 1) {
                        printMessageln(StringEnum.NO_RECORDS_TO_REMOVE.getValue());
                        break;
                    }

                }

                case "count": {
                    if (DataBaseImitator.countDbContact() < 1) {
                        printMessageln(StringEnum.PHONE_BOOK_IS_EMPTY.getValue());
                        break;
                    }
                }


                case "list": {
                    DataBaseImitator.getContactList();
                    for (Contact o : DataBaseImitator.getContactList()) {
                        System.out.println(o);
                    }
                }
            }

        } while (!command.equals("exit"));
    }
}
