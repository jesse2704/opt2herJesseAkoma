package src;

import java.util.ArrayList;

public class AuthenticatieNormaal extends Authenticatie {
    private final ArrayList <Gebruiker> gebruikers = Gebruiker.getGebruikers();
    @Override
    public Boolean checkUsername(String username) {
        if (gebruikers.contains(username)) return true;
        return false;
    }
    @Override
    public Boolean checkPassword(String password) {
        if (gebruikers.contains(password)) return true;
        return false;
    }
}