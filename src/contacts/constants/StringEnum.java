package contacts.constants;



public enum StringEnum {
    /*
        Message for input
     */
    ENTER_NAME_PERSON("Enter the name of person:"),
    ENTER_SURNAME_PERSON("Enter the surname of the person:"),
    ENTER_THE_NUMBER("Enter the number:"),


    MENU("Enter action (add, remove, edit, count, list, exit):"),

    /*
        Message for after-input
     */
    RECORD_CREATED("A record created!"),
    PB_WITH_SINGLE_REC_CREATED("A Phone book with a %s record created!");

    private String stringValue;

    StringEnum(String s) {
        stringValue = s;
    }

    public String getValue() {
        return stringValue;
    }
}