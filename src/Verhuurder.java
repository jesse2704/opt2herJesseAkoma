package src;

import java.text.ParseException;
import java.util.*;

import static src.Main.gebruiker;

public class Verhuurder extends Gebruiker {
    public ArrayList<Auto> Autos;

    public Verhuurder(String userName, String emailAddress, String password, String firstName, String lastName, String phoneNumber) {
        super(userName, emailAddress, password, firstName, lastName, phoneNumber);
        this.Autos = new ArrayList<Auto>();
    }

    public ArrayList<Auto> getAutos() {return Autos;}
    public void addAuto(String merk)
    {
        getAutos().add(new Auto(merk));
    }
    public void removeAuto(int index) {getAutos().remove(index);}

    @Override
    public void userOptionMenu() throws ParseException {
        Scanner scanner = new Scanner(System.in);

        Verhuurder verhuurder = (Verhuurder) gebruiker;
        System.out.println("Maak een keuze:");
        System.out.println("1. Auto toevoegen");
        System.out.println("2. Auto verwijderen");
        System.out.println("3. Overzicht");
        System.out.println("4. Inventaris auto's");
        System.out.println("5. Uitloggen");
        System.out.println("Voer je keus in:");
        int keus = scanner.nextInt();
        scanner.nextLine();
        System.out.println(" ");
        switch (keus) {
            case 1:
                System.out.println("Welke auto wilt u toevoegen");
                String merkAuto = scanner.nextLine();
                verhuurder.addAuto(merkAuto);

                //Back to option menu
                gebruiker.userOptionMenu();
                break;
            case 2:
                if (verhuurder.getAutos().isEmpty())
                {
                    System.out.println("Je hebt geen autos in je inventaris");
                    System.out.println(" ");

                    //Back to option menu
                    gebruiker.userOptionMenu();
                }
                int count = -1;
                for (Auto auto : getAutos())
                {
                    count++;

                    System.out.println(count + ". " + auto.getMerk());
                }
                System.out.println("Welke auto wilt u verwijderen");
                int verwijderAuto = scanner.nextInt();
               verhuurder.removeAuto(verwijderAuto);
                System.out.println("Auto succesvol verwijdert");

                //Back to option menu
                gebruiker.userOptionMenu();
                break;
            case 3:
                this.getAccountDetail();
                break;
            case 4:
                if (verhuurder.getAutos().isEmpty())
                {
                    System.out.println("Je hebt geen autos in je inventaris");
                    System.out.println(" ");

                    //Back to option menu
                    gebruiker.userOptionMenu();
                }
                int count1 = -1;
                System.out.println("Inventaris autos: ");
                for (Auto auto : getAutos())
                {
                    count1++;

                    System.out.println(count1 + ". " + auto.getMerk());
                }

                //Back to option menu
                gebruiker.userOptionMenu();
                break;
            case 5:
                gebruiker = null;
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
        gebruiker.userOptionMenu();
    }
}
