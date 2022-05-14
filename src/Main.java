package src;

import java.util.Scanner;

public class Main {
    public static Gebruiker gebruiker;

    public static void main(String[] args) {
        Gebruiker gebruiker = new Huurder("huurder", "huurder@gmail.com", "#1Geheim", "test", "gebruiker", "0620903865");

        Scanner scanner = new Scanner(System.in);
        // check if any user is logged in, if not ask user to login or register
        if (gebruiker == null) {
            System.out.println("1. Inloggen");
            System.out.println("2. Registreren");
            System.out.println("Maak een keuze:");
            int log = scanner.nextInt();
            scanner.nextLine();
            System.out.println(" ");
            // check if user wants to login
            switch (log) {
                case 1:
                    gebruiker = Login.login();
                    break;
                // check if user want to register
                case 2:
                    gebruiker = Login.register();
                    break;
                default:
                    System.out.println("Foutieve invoer");
                    main(args);
            }
            // if something went wrong block here
            if (gebruiker == null) {
                System.out.println("Geen gebruiker gevonden!");
                main(args);
            }
        }

        //If user is logged in and Huurder
        if (gebruiker.isInstanceOfHuurder() == true)
        {
            System.out.println("Maak een keuze:");
        System.out.println("1. Auto huren");
        System.out.println("2. Overzicht");
        System.out.println("3. Uitloggen");
        System.out.println("Voer je keus in:");
        int keus = scanner.nextInt();
        scanner.nextLine();
        System.out.println(" ");
        switch (keus) {
            case 1:
                //
                break;
            // check if user want to register
            case 2:
                //
                break;
            case 3:
                gebruiker = null;
                main(args);
                break;
            default:
                System.out.println("Foutieve invoer");
                main(args);
        }
    }

        //If user is logged in and Verhuurder
        if (gebruiker.isInstanceOfHuurder()== false)
            System.out.println("Maak een keuze:");
        System.out.println("1. Auto toevoegen");
        System.out.println("2. Auto verwijderen");
        System.out.println("3. Overzicht");
        System.out.println("4. Uitloggen");
        System.out.println("Voer je keus in:");
        int keus = scanner.nextInt();
        scanner.nextLine();
        System.out.println(" ");
        switch (keus)
        {
            case 1:
                //Toevoegen
                break;
            case 2:
                //Verwijderen
                break;
            case 3:
                //Overzicht
                break;
            case 4:
                gebruiker = null;
                main(args);
                break;
            default:
                System.out.println("Foutieve invoer");
                main(args);
        }
    }



}
