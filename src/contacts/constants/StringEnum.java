package contacts.constants;


public enum StringEnum {
    /*
        Message for input
     */
    ENTER_NAME_PERSON("Enter the name of person:"),
    ENTER_SURNAME_PERSON("Enter the surname of the person:"),
    ENTER_THE_NUMBER("Enter the number:"),


    MENU_BAR("Enter action (add, remove, edit, count, list, exit):"),


    /*
        Message for after-input
     */
    RECORD_CREATED("A record created!"),
    PB_WITH_SINGLE_REC_CREATED("A Phone book with a %s record created!"),
    PB_WITH_OTHER_REC_CREATED("The Phone Book has %d records."),


    PHONE_BOOK_IS_EMPTY("The Phone Book has 0 records."),
    NO_RECORDS_TO_EDIT("No records to edit!"),
    NO_RECORDS_TO_REMOVE("No records to remove!"),
    WRONG_NUMBER_FORMAT("Wrong number format!"),
    RECORD_ADDED("The record added."),
    SELECT_RECORD("Select a record:"),
    UPDATE_RECORD("The record updated!"),
    REMOVED_RECORD("The record removed!"),
    NO_NUMBER("[no number]");


    private String stringValue;

    StringEnum(String s) {
        stringValue = s;
    }

    public String getValue() {
        return stringValue;
    }
}