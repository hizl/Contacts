package contacts.contactsUtils;

import java.util.regex.Pattern;

public class RegexValidator {
    private static final Pattern phonePattern = Pattern.compile(
            "^\\+?([\\da-zA-Z]{1,}[\\s-]?)?(\\([\\da-zA-Z]{2,}(\\)[\\s-]|\\)$))?([\\da-zA-Z]{2,}[\\s-]?)*([\\da-zA-Z]{2,})?$"
    );


}
