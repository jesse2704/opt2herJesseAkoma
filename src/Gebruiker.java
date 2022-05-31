package src;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static src.Main.gebruiker;

public abstract class Gebruiker implements AccountInformation {
    protected UUID id;
    protected String userName;
    protected String emailAddress;
    protected String password;
    protected String firstName;
    protected String lastName;
    protected String phoneNumber;
    protected Boolean isIngelogd;
    protected static final ArrayList<Gebruiker> gebruikers = new ArrayList<>();

    public Gebruiker(String userName, String emailAddress, String password, String firstName, String lastName, String phoneNumber)
    {
        this.id = UUID.randomUUID();
        this.userName = userName;
        this.emailAddress = emailAddress;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.isIngelogd = false;
        gebruikers.add(this);
    }

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
    public Boolean getIngelogd() { return isIngelogd; }
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
        if(password.matches("((?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[@#$%!]).{6,40})"))
            this.password = passWord;
        else
            throw new IllegalArgumentException("Password must be between 6 and 40 characters long,\n" +
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
    public void setIngelogd(Boolean ingelogd) {
        isIngelogd = ingelogd;
    }
}


