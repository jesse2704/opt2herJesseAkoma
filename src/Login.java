package src;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class Login {
    private static final ArrayList < Gebruiker > gebruikers = Gebruiker.getGebruikers();

    public static Gebruiker engageLogin(String username, String password)
    {
        AuthenticatieNormaal Auth = new AuthenticatieNormaal();
        if (Auth.Authentication(username, password)) {
            return null;
        };
        for (Gebruiker gebruiker: gebruikers) {
            if (gebruiker.getUserName().equals(username) && gebruiker.getPassword().equals(password)) {
                gebruiker.setIngelogd(true);
                return gebruiker;
            }
        }
        return null;
    }

    // The login method ask the username and password and checks if they exist
    public static Gebruiker login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Voer uw gebruikersnaam in:");
        String username = scanner.nextLine();
        System.out.println("Voer uw wachtwoord in:");
        String password = scanner.nextLine();
        System.out.println(" ");
        return engageLogin(username, password);
    }

    public static Gebruiker login(String userName, String passWord) {
        return engageLogin(userName, passWord);
    }

    // The register method collects all the data that's needed to create a new user
    public static Gebruiker register() {
        Scanner scanner = new Scanner(System.in);
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
            return new Huurder(UUID.randomUUID(), username, email, password, firstName, lastName, phone);
        } else {
            return new Verhuurder(UUID.randomUUID(), username, email, password, firstName, lastName, phone);
        }
    }

    public static ArrayList < Gebruiker > getGebruikers() {
        return gebruikers;
    }

    public static String checkRegisterEligble(Boolean heeftRijbewijs, Boolean usernameUniek, int leeftijd, String wachtwoord) {
        ArrayList<String> result = new ArrayList<String>();
        String sterkte = "zwak";

        if (heeftRijbewijs) {
            if (usernameUniek) {
                if (leeftijd >= 21) {
                    if (wachtwoord == "goed") {
                        sterkte = "goed";
                        result.add("Gebruiker kan worden aangemaakt!");

                    } else if (wachtwoord == "matig") {
                        result.add("Wachtwoord is matig");
                    } else if (wachtwoord == "zwak") {
                        result.add("Wachtwoord is zwak");
                    }
                } else {
                    result.add("Je moet ouder zijn dan 20");
                }
            } else {
                result.add("Gebruikersnaam is niet uniek");
            }
        } else {
            result.add("Je kan geen account aan maken zonder rijbewijs");
        }

        return result.get(0);
    }
}