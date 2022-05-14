package src;

import java.util.ArrayList;
import java.util.UUID;

public abstract class Gebruiker {
    protected UUID id;
    protected String userName;
    protected String emailAddress;
    protected String password;
    protected String firstName;
    protected String lastName;
    protected String phoneNumber;
    protected static final ArrayList<Gebruiker> gebruikers = new ArrayList<>();

    public UUID getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public static ArrayList<Gebruiker> getGebruikers() {
        return gebruikers;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setEmailAddress(String emailAddress) {
        if(emailAddress.matches("^(.+)@(.+)$"))
            this.emailAddress = emailAddress;
        else
            throw new IllegalArgumentException("Please fill in a valid e-mailaddress.");
    }

    public void setPassword(String passWord) {
        if(password.matches("((?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[@#$%!]).{8,40})"))
            this.password = passWord;
        else
            throw new IllegalArgumentException("Password must be between 8 and 40 characters long,\n" +
                    "contain at least one digit,\n" +
                    "contain at least one lower case character,\n" +
                    "contain at least one upper case character,\n" +
                    "contain at least on special character from [ @ # $ % ! . ].");
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Boolean isInstanceOfHuurder() { return (this instanceof Huurder); }


}

