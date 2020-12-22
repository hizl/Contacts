package contacts.entity;

import contacts.constants.StringEnum;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import contacts.constants.StringEnum;
import contacts.db.DataBaseImitator;
import contacts.entity.Contact;

import static contacts.utils.ConsoleUtils.printMessageln;
import static contacts.utils.ConsoleUtils.readLine;


import contacts.utils.*;

public class Contact {

    public Contact Builder;
    DataBaseImitator dataBaseImitator = new DataBaseImitator();


    private String name;
    private String surName;
    private String phoneNumber;

    public Contact() {
        this.name = "";
        this.surName = "";
        this.phoneNumber = "";
    }

    public Contact(String name, String surName, String phoneNumber) {
        this.name = name;
        this.surName = surName;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public static class Builder {
        private String name;
        private String surName;
        private String phoneNumber;

        public Builder() {
        }


        public String getName() {
            return name;
        }

        public String getSurName() {
            return surName;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public Builder setName(ConsoleUtils consoleUtils, String name) {
            this.name = name;

            return this;
        }

        public Builder setSurName(ConsoleUtils consoleUtils, String surName) {
            this.surName = surName;
            return this;
        }

        public Builder setPhoneNumber(ConsoleUtils consoleUtils, String phoneNumber) {
            if (isValidNumber(phoneNumber)) {
                this.phoneNumber = phoneNumber;
            } else {
                this.phoneNumber = "[no number]";
                printMessageln(StringEnum.WRONG_NUMBER_FORMAT.getValue());
            }
            return this;
        }

        public Contact build() {
            return new Contact(name, surName, phoneNumber);
        }


        public void setName(String name) {
        }

        public void setSurName(String surName) {
            this.surName = surName;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }
    }


    private static boolean isValidNumber(String str) {
        Pattern pat = Pattern.compile("[+]?\\w?[\\s-]?(\\([\\w]{2,}\\)|" +
                "[\\w]{2,}[\\s-]\\([\\w]{2,}\\)|" +
                "[\\w]{2,})([\\s-][\\w]{2,})*");
        Matcher mat = pat.matcher(str);
        return mat.matches();
    }

    @Override
    public String toString() {
        return name + " " + surName + ", " + phoneNumber;
    }
}