package src;

import java.text.ParseException;

public interface AccountInformation {
    public void userOptionMenu() throws ParseException;
    public abstract void getAccountDetail() throws ParseException;
}

