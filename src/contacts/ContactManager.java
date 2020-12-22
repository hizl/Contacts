package contacts;


import contacts.constants.StringEnum;
import contacts.db.DataBaseImitator;
import contacts.entity.Contact;
import contacts.utils.ConsoleUtils;

import java.util.*;

import static contacts.utils.ConsoleUtils.*;

class ContactManager {

    public void runApplication() {
        createUserScenario();
    }


    private static void createUserScenario() {
        Integer countId = 1;
        Map<Integer, Contact> mapContact = new HashMap<>();

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
                    mapContact.put(countId++, contact);

                    //DataBaseImitator.createContact(contact);

                    if (!mapContact.isEmpty()) {
                        printMessageln(StringEnum.PB_WITH_SINGLE_REC_CREATED.getValue(), "single");
                    }

//                    if (DataBaseImitator.countDbContact() != 0) {
//                        printMessageln(StringEnum.PB_WITH_SINGLE_REC_CREATED.getValue(), "single");
//                    }
                    break;
                }

                case "edit": {
                    if (mapContact.isEmpty()) {
                        printMessageln(StringEnum.NO_RECORDS_TO_EDIT.getValue());
                        break;
                    } else {

                        for (Map.Entry<Integer, Contact> o : mapContact.entrySet()) {
                            System.out.printf("%d. %s\n", o.getKey(), o.getValue());
                        }

                        printMessageln(StringEnum.SELECT_RECORD.getValue());

                        int choseContact = readInt();

                        if (mapContact.containsKey(choseContact)) {

                            printMessageln(StringEnum.SELECT_A_FIELD.getValue());
                            command = readLine();


                            switch (command) {
                                case "name": {
                                    Contact contact = new Contact
                                            .Builder()
                                            .setName(ConsoleUtils
                                                            .simplePrint(StringEnum.ENTER_NAME_PERSON.getValue()),
                                                    ConsoleUtils.readLine()).build();

                                    mapContact.put(choseContact, contact);

                                    ConsoleUtils.printMessageln(StringEnum.UPDATE_RECORD.getValue());
                                    break;
                                }


                                case "surname": {

                                    break;
                                }

                                case "number": {

                                    break;
                                }

                            }
                            break;
                        }

                        // int gettingId = readInt();

                        printMessageln(StringEnum.SELECT_A_FIELD.getValue());
                    }

                }


                case "remove": {


                    if (mapContact.isEmpty()) {
                        printMessageln(StringEnum.NO_RECORDS_TO_REMOVE.getValue());
                        break;
                    } else {

                        for (Map.Entry<Integer, Contact> o : mapContact.entrySet()) {
                            System.out.printf("%d. %s\n", o.getKey(), o.getValue());
                        }
                        printMessage(StringEnum.SELECT_RECORD.getValue());
                        int removeChoiceContact = readInt();
                        mapContact.remove(removeChoiceContact);

                        break;
                    }
                }


                case "count": {
                    if (DataBaseImitator.countDbContact() == 0) {
                        printMessageln(StringEnum.PHONE_BOOK_IS_CONTAINS_RECORDS.getValue(), 0);
                        break;
                    } else {
                        printMessageln(StringEnum.PHONE_BOOK_IS_CONTAINS_RECORDS.getValue(), DataBaseImitator.countDbContact());
                        break;
                    }
                }
                case "list": {
                    for (Map.Entry<Integer, Contact> o : mapContact.entrySet()) {
                        System.out.printf("%d. %s\n", o.getKey(), o.getValue());
                    }
                    break;
                }
            }
        } while (!command.equals("exit"));
    }
}




