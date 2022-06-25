package src;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class Verhuurder extends Gebruiker implements VerhuurderInterface {
    public ArrayList < ModernAuto > Autos;

    public Verhuurder(UUID id, String userName, String emailAddress, String password, String firstName, String lastName, String phoneNumber) {
        super(id, userName, emailAddress, password, firstName, lastName, phoneNumber);
        this.Autos = new ArrayList < ModernAuto > ();
    }

    public ArrayList < ModernAuto > getAutos() {
        return Autos;
    }
    public void addAuto(ModernAuto modernAuto) {
        getAutos().add(modernAuto);
    }
    public void removeAuto(int index) {
        getAutos().remove(index);
    }

    @Override
    public void reportBug() throws ParseException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bug report!");
        System.out.println("Wat is er aan de hand verhuurder?");
        String respons = scanner.nextLine();
        System.out.println("Dank u wel voor je bugreport, wij zullen zo spoedig mogelijk hier naar kijken");

        Main.bugReports.add(new BugReport(respons, "verhuurder"));
        Main.loggedInGebruiker.userOptionMenu();
    }

    @Override
    public void logIn() {
        Login.login(this.userName, this.password);
        Main.loggedInGebruiker = this;
        this.setIngelogd(true);
        System.out.println("Verhuurder is ingelogd");
    }

    @Override
    public void logUit() {
        this.setIngelogd(false);
        Main.loggedInGebruiker = null;
        System.out.println("Verhuurder is uitgelogd");
    }

    @Override
    public void userOptionMenu() throws ParseException {
        Scanner scanner = new Scanner(System.in);

        Verhuurder verhuurder = (Verhuurder) Main.loggedInGebruiker;
        System.out.println("Maak een keuze:");
        System.out.println("1. Auto toevoegen");
        System.out.println("2. Auto verwijderen");
        System.out.println("3. Overzicht");
        System.out.println("4. Inventaris auto's");
        System.out.println("5. Autos schoonmaken");
        System.out.println("6. Uitloggen");
        System.out.println("7. Report bug");
        System.out.println("Voer je keus in:");
        int keus = scanner.nextInt();
        scanner.nextLine();
        System.out.println(" ");
        switch (keus) {
            case 1:
                System.out.println("Merk auto?");
                String merkAuto = scanner.nextLine();
                System.out.println("CruiseConrtol? (Y / N)");
                String cruiseControlAuto = scanner.nextLine();
                Boolean cruise = false;
                if (cruiseControlAuto == "Y") cruise = true;
                System.out.println("Aantal deuren?)");
                int aantalDeuren = 0;
                try { aantalDeuren = scanner.nextInt();} catch (Exception e) {System.out.println("Aantal deuren hebben geen juiste waarden");}
                System.out.println("Aantal Airbags?)");
                int aantalAirbags = 0;
                try { aantalAirbags = scanner.nextInt();} catch (Exception e) {System.out.println("Airbags hebben geen juiste waarden");}
                ModernAutoFactory newAuto = new ModernAutoFactory();
                ModernAuto modernAuto = newAuto.createAuto();
                modernAuto.setMerk(merkAuto);
                modernAuto.setCruiseControl(cruise);
                modernAuto.setAantalDeuren(aantalDeuren);
                modernAuto.setAantalAirbags(aantalAirbags);
                verhuurder.addAuto(modernAuto);
                ModernAuto.getAutos().add(modernAuto);

                //Back to option menu
                Main.loggedInGebruiker.userOptionMenu();
                break;
            case 2:
                verhuurder.getInventarisAutos();

                System.out.println("Welke auto wilt u verwijderen");
                int verwijderAuto = scanner.nextInt();
                verhuurder.removeAuto(verwijderAuto);
                System.out.println("Auto succesvol verwijdert");

                //Back to option menu
                Main.loggedInGebruiker.userOptionMenu();
                break;
            case 3:
                this.getAccountDetail();
                break;
            case 4:
                if (verhuurder.getAutos().isEmpty()) {
                    System.out.println("Je hebt geen autos in je inventaris");
                    System.out.println(" ");

                    //Back to option menu
                    Main.loggedInGebruiker.userOptionMenu();
                }
                int count1 = -1;
                System.out.println("Inventaris autos: ");
                for (ModernAuto auto: getAutos()) {
                    count1++;

                    System.out.println(count1 + ". " + auto.getMerk());
                }

                //Back to option menu
                Main.loggedInGebruiker.userOptionMenu();
                break;
            case 5:
                ArrayList < ModernAuto > verlopenAutos = new ArrayList < ModernAuto > ();
                for (ModernAuto auto: this.getAutos()) {
                    VerhuurFragment laatsteElement = auto.getFragmenten().get(auto.getFragmenten().size() - 1);
                    if (laatsteElement.getEindTijd().after(getTodaysDate()) && auto.getHired() == true) {
                        verlopenAutos.add(auto);
                    }
                }
                int countVerlopenAuto = -1;
                System.out.println("Lijst met beindigded huurcontracten:");
                for (ModernAuto verlopenAuto: verlopenAutos) {
                    countVerlopenAuto++;
                    System.out.println(countVerlopenAuto + ". " + verlopenAuto.getMerk());
                }
                if (verlopenAutos.isEmpty())
                {
                    System.out.println("Er zijn momenteel geen auto's die schoonmaak nodig hebben");
                    Main.loggedInGebruiker.userOptionMenu();
                }
                System.out.println("Maak een keuze");
                int inputAutoSchoonmaken = -1;
                try { inputAutoSchoonmaken = scanner.nextInt();} catch (Exception e) {System.out.println("Verkeerde input");}


                if (inputAutoSchoonmaken > verlopenAutos.size() || inputAutoSchoonmaken < 0) {
                    System.out.println("Verkeerde input");
                    Main.loggedInGebruiker.userOptionMenu();
                }
                else {
                    ModernAuto gekozenAuto = verlopenAutos.get(inputAutoSchoonmaken).getModernAuto();
                    for (ModernAuto modernAuto2: ModernAuto.getAutos()) {
                        if (modernAuto2 == gekozenAuto) {
                            modernAuto2.setHired(false);
                        }
                        for (ModernAuto auto: this.getAutos()) {
                            if (auto == gekozenAuto) {
                                auto.setHired(false);
                            }
                        }
                    }
                    System.out.println(gekozenAuto.getMerk() + " is schoongemaakt en gereed voor verhuur");
                }

                //Back to option menu
                Main.loggedInGebruiker.userOptionMenu();
                break;
            case 6:
                Main.loggedInGebruiker = null;
                break;
            case 7:
                this.reportBug();
                break;
            default:
                System.out.println("Foutieve invoer");
        }
    }

    @Override
    public void getAccountDetail() throws ParseException {
        System.out.println("Full name: " + getFirstName() + " " + getLastName());
        System.out.println("Emailadress: " + getEmailAddress());
        System.out.println("Phonenumber: " + getPhoneNumber());
        System.out.println("Count inventory cars: " + getAutos().stream().count());

        //Back to option menu
        Main.loggedInGebruiker.userOptionMenu();
    }

    @Override
    public void getInventarisAutos() throws ParseException {
        if (this.getAutos().isEmpty()) {
            System.out.println("Je hebt geen autos in je inventaris");
            System.out.println(" ");

            //Back to option menu
            this.userOptionMenu();
        }
        int count = -1;
        for (ModernAuto auto: getAutos()) {
            count++;

            System.out.println(count + ". " + auto.getMerk());
        }
    }
}