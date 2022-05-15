package src;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static Gebruiker gebruiker;

    public static void main(String[] args) throws ParseException {
        //Huurders
        Huurder huurder1 = new Huurder("huurder", "huurder@gmail.com", "#1Geheim", "test", "gebruiker", "0620903865");
        Huurder huurder2 = new Huurder("jesse", "jesse@gmail.com", "#1Geheim", "jesse", "akoma", "0620903865");

        //Verhuurders

        //Licenties
        Licentie licentie1 = new Licentie(1, 8);
        Licentie licentie2 = new Licentie(2, 6);

        //setLicenties
        huurder1.setLicentie(licentie1);
        huurder2.setLicentie(licentie2);

        Auto auto1 = new Auto("Mercedes");
        Auto auto2 = new Auto("Ferrari");

        //Verhuurfragmenten aanmaken
        String startTijdNotParsed1 = "15/05/2022";
        String eindTijdNotParsed1 = "20/05/2022";
        Date startTijd1 = new SimpleDateFormat("d/M/yyyy").parse(startTijdNotParsed1);
        Date eindTijd1 = new SimpleDateFormat("d/M/yyyy").parse(eindTijdNotParsed1);

        String startTijdNotParsed2 = "10/06/2022";
        String eindTijdNotParsed2 = "30/06/2022";
        Date startTijd2 = new SimpleDateFormat("d/M/yyyy").parse(startTijdNotParsed2);
        Date eindTijd2 = new SimpleDateFormat("d/M/yyyy").parse(eindTijdNotParsed2);

        VerhuurFragment verhuurFragment1 = new VerhuurFragment(startTijd1, eindTijd1, huurder1, huurder1.getEmailAddress());
        VerhuurFragment verhuurFragment2 = new VerhuurFragment(startTijd2, eindTijd2, huurder1, huurder1.getEmailAddress());
        auto1.addFragment(verhuurFragment1);
        auto2.addFragment(verhuurFragment2);

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
        if (gebruiker.isInstanceOfHuurder() == true) {
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
                    gebruiker.autoHuren();
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
        if (gebruiker.isInstanceOfHuurder() == false)
        {
            Verhuurder verhuurder = (Verhuurder) gebruiker;
            System.out.println("Maak een keuze:");
            System.out.println("1. Auto toevoegen");
            System.out.println("2. Auto verwijderen");
            System.out.println("3. Overzicht");
            System.out.println("4. Uitloggen");
            System.out.println("Voer je keus in:");
            int keus = scanner.nextInt();
            scanner.nextLine();
            System.out.println(" ");
            switch (keus) {
                case 1:
                    System.out.println("Welke auto wilt u toevoegen");
                    String merkAuto = scanner.nextLine();
                    verhuurder.addAuto(merkAuto);

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



}
