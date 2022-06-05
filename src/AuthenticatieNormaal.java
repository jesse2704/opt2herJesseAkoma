package src;

import java.util.ArrayList;

public class AuthenticatieNormaal extends Authenticatie {
    private final ArrayList <Gebruiker> gebruikers = Gebruiker.getGebruikers();
    @Override
    public Boolean checkUsername(String username) {
        for (Gebruiker gebruiker: gebruikers) {
            if (gebruiker.getUserName().equals(username)) {
                return true;
            }
        }
        return false;
    }
    @Override
    public Boolean checkPassword(String password) {
        for (Gebruiker gebruiker: gebruikers) {
            if (gebruiker.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}