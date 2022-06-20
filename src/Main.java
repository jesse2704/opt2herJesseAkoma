package src;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.UUID;

public class Main {
    public static ArrayList<BugReport> bugReports;
    public static Gebruiker loggedInGebruiker;

    public static void main(String[] args) throws ParseException {
        //Huurders
        Huurder huurder1 = new Huurder(UUID.randomUUID(), "huurder", "huurder@gmail.com", "#1Geheim", "gebruiker", "gebruiker", "0620903444");
        Huurder huurder2 = new Huurder(UUID.randomUUID(), "jesse@gmail.com", "#1Geheim", "jesse", "Jesse", "Akoma", "0620903865");

        //Verhuurders
        Verhuurder verhuurder1 = new Verhuurder(UUID.randomUUID(), "verhuurder", "huurder@gmail.com", "#1Geheim", "test", "gebruiker", "0620903865");
        Verhuurder verhuurder2 = new Verhuurder(UUID.randomUUID(), "verhuurder2", "huurder@gmail.com", "#1Geheim", "test", "gebruiker", "0620903865");

        //Maak licenties
        Licentie licentie1 = new Licentie(1, 3);
        Licentie licentie2 = new Licentie(2, 6);

        //stel licentie in voor huurders
        huurder1.setLicentie(licentie1);
        huurder2.setLicentie(licentie2);

        //Autos maken met factory en toevoegen aan finalList
        ModernAutoFactory factory = new ModernAutoFactory();
        ModernAuto auto1 = factory.createAuto();
        ModernAuto auto2 = factory.createAuto();

        //Autos configuren
        auto1.setMerk("Ford Mustang");
        auto1.setAantalAirbags(4);
        auto1.setCruiseControl(true);
        auto1.setAantalDeuren(5);

        auto2.setMerk("Ford Fiesta");
        auto2.setAantalAirbags(4);
        auto2.setCruiseControl(false);
        auto2.setAantalDeuren(5);

        //Add cars to final list
        ModernAuto.getAutos().add(auto1);
        ModernAuto.getAutos().add(auto2);

        //Zet autos in verhuurders inventaris
        verhuurder1.getAutos().add(auto1);
        verhuurder1.getAutos().add(auto2);

        //Verhuurfragmenten aanmaken
        String startTijdNotParsed1 = "15/05/2022";
        String eindTijdNotParsed1 = "20/05/2022";
        Date startTijd1 = new SimpleDateFormat("d/M/yyyy").parse(startTijdNotParsed1);
        Date eindTijd1 = new SimpleDateFormat("d/M/yyyy").parse(eindTijdNotParsed1);

        String startTijdNotParsed2 = "02/07/2022";
        String eindTijdNotParsed2 = "30/07/2022";
        Date startTijd2 = new SimpleDateFormat("d/M/yyyy").parse(startTijdNotParsed2);
        Date eindTijd2 = new SimpleDateFormat("d/M/yyyy").parse(eindTijdNotParsed2);

        VerhuurFragment verhuurFragment1 = new VerhuurFragment(startTijd1, eindTijd1, huurder1, huurder1.getEmailAddress());
        VerhuurFragment verhuurFragment2 = new VerhuurFragment(startTijd2, eindTijd2, huurder1, huurder1.getEmailAddress());

        //Verhuurfragment toevoegen aan autos
        auto1.addFragment(verhuurFragment1);
        auto2.addFragment(verhuurFragment2);

        Scanner scanner = new Scanner(System.in);
        // check if any user is logged in, if not ask user to login or register
        if (loggedInGebruiker == null) {

            System.out.println("1. Inloggen");
            System.out.println("2. Registreren");
            System.out.println("Maak een keuze:");
            int log = scanner.nextInt();
            scanner.nextLine();
            System.out.println(" ");
            // check if user wants to login
            switch (log) {
                case 1:
                    loggedInGebruiker = Login.login();
                    break;
                // check if user want to register
                case 2:
                    loggedInGebruiker = Login.register();
                    break;
                default:
                    System.out.println("Foutieve invoer");
                    main(args);
            }
            // if something went wrong block here
            if (loggedInGebruiker == null) {
                System.out.println("Geen gebruiker gevonden!");
                main(args);
            }
        }
        loggedInGebruiker.userOptionMenu();
    }
}