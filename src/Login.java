package src;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import java.util.UUID;

public class Login {
    private static final ArrayList<Gebruiker> gebruikers = Gebruiker.getGebruikers();

    // The login method ask the username and password and checks if they exist
    public static Gebruiker login(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Voer uw gebruikersnaam in:");
        String username = scanner.nextLine();
        System.out.println("Voer uw wachtwoord in:");
        String password = scanner.nextLine();
        System.out.println(" ");
        AuthenticatieNormaal Auth = new AuthenticatieNormaal();
        if(!Auth.Authentication(username, password)){return null;};
        for (Gebruiker gebruiker : gebruikers){
            if(gebruiker.getUserName().equals(username) && gebruiker.getPassword().equals(password)) {
                gebruiker.setIngelogd(true);
                return gebruiker;
            }
        }
        return null;
    }

    public static Gebruiker login(String userName, String passWord)
    {
        AuthenticatieNormaal Auth = new AuthenticatieNormaal();
        if(!Auth.Authentication(userName, passWord)){return null;};
        for (Gebruiker gebruiker : gebruikers){
            if(gebruiker.getUserName().equals(userName) && gebruiker.getPassword().equals(passWord)) {
                gebruiker.setIngelogd(true);
                return gebruiker;
            }
        }
        return null;
    }

    // The register method collects all the data that's needed to create a new user
    public static Gebruiker register(){
        Scanner scanner = new Scanner (System.in);
        System.out.println("Voer uw gebruikersnaam in:");
        String username = scanner.nextLine();
        System.out.println("Voer uw wachtwoord in:");
        String password = scanner.nextLine();
        System.out.println("Voer uw email in:");
        String email = scanner.nextLine();
        System.out.println("Voer uw telefoonnummer in 06:");
        String phone = scanner.nextLine();
        System.out.println("Voer naam in:");
        String firstName = scanner.nextLine();
        System.out.println("Voer achternaam in:");
        String lastName = scanner.nextLine();
        System.out.println("Registreren als Huurder of Verhuurder (H/V)");
        String hOfV = scanner.nextLine();
        System.out.println("Successvol geregistreerd ('Druk enter op in te loggen')");
        scanner.nextLine();
        Login.login();


        if (hOfV == "H" || hOfV == "h") {
            return new Huurder(username, email, password, firstName, lastName, phone);
        } else {
            return new Verhuurder(username, email, password, firstName, lastName, phone);
        }
    }

    public static ArrayList<Gebruiker> getGebruikers() {
        return gebruikers;
    }

    public static String checkRegisterEligble(Boolean heeftRijbewijs, String usernameUniek, int leeftijd, String wachtwoord)
    {
        String result = "";
        ArrayList<String> gebruikersnamen = new ArrayList<>();
        String sterkte = "zwak";

        for (Gebruiker gebruiker : Login.getGebruikers())
        {
            gebruikersnamen.add(gebruiker.getUserName());
        }

        if (heeftRijbewijs)
        {
            if(!gebruikersnamen.contains(usernameUniek))
            {
                if (leeftijd >= 21)
                {
                    if(wachtwoord.length() > 6 && wachtwoord.matches(".*[A-Z].*"))
                    {
                        sterkte = "matig";

                        if(wachtwoord.matches("^(?=.*[a-z])(?=.*\\d)(?=.*[A-Z])" + "(?=.*[@#$%!]).+$")){
                            sterkte = "goed";
                            result = "Gebruiker kan worden aangemaakt";
                        } else {
                            result += "wachtwoord is matig";
                        }
                    }
                    else
                    {
                        result += "wachtwoord is zwak";
                    }
                }
                else
                {
                    result += "Je moet ouder zijn dan 21";
                }
            }
            else
            {
                result += "Kies een andere gebruikersnaam";
            }
        } else {
            result = "Je kan geen account aan maken zonder rijbewijs";
        }

//        if (!heeftRijbewijs)
//        {
//            if(gebruikersnamen.contains(usernameUniek))
//            {
//               return result = "gebruikersnaam komt al voor";
//
//                if (leeftijd < 21)
//                {
//                   return result = "je moet minimaal 21 jaar oud zijn";
//                }
//                if(wachtwoord.length() < 6){
//                    sterkte = "zwak";
//                    result += "wachtwoord te zwak.";
//                }
//
//            }
//            return result = "Je kan geen account aan maken zonder rijbewijs";
//        }
           return result;
    }
}