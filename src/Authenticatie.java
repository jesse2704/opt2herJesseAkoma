package src;

import java.util.ArrayList;

abstract class Authenticatie {

    private final ArrayList<Gebruiker> gebruikers = Gebruiker.getGebruikers();
    public abstract Boolean checkUsername(String username);
    public abstract Boolean checkPassword(String password);
    public Boolean Authentication(String username, String password){
        if(checkUsername(username) && checkPassword(password)){
            for (Gebruiker gebruiker : gebruikers)
            {
                //Check of de gebruikersnaam EN password overeenkomen met elkaar
                if (gebruiker.getUserName() == username && gebruiker.getPassword() == password) return true;
            }
        }
        return false;
    }
}
