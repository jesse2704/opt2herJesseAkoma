package src;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.Scanner;

import static src.Main.gebruiker;

public class Huurder extends Gebruiker {

    public ArrayList<VerhuurFragment> fragment;
    private Licentie licentie;

    public Huurder(String userName, String emailAddress, String password, String firstName, String lastName, String phoneNumber)
    {
        super(userName, emailAddress, password, firstName, lastName, phoneNumber);
        this.licentie = null;
        this.fragment = new ArrayList<VerhuurFragment>();
    }

    public ArrayList<VerhuurFragment> getFragment() {
        return fragment;
    }
    public Licentie getLicentie() {
        return licentie;
    }
    public void setLicentie(Licentie licentie) {this.licentie = licentie;}
    public int getMaxCarFromLicentie()
    {
        return this.getLicentie().maxAuto;
    }
    public Boolean hasLicentie(){return this.getLicentie() != null;}

    public int getCurrentActiveRentalAmount() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date today = new Date();
        String todaysdate = formatter.format(today);
        Date todaysDate= new SimpleDateFormat("d/M/yyyy").parse(todaysdate);

        int count = 0;

       for (VerhuurFragment verhuurFragment : this.getFragment())
       {
           if(!verhuurFragment.getEindTijd().before(todaysDate))
           {
               count++;
           }
       }
        return count;
    }

    public boolean kanAutoHuren()
    {
        boolean result = this.getIngelogd() && this.hasLicentie();

        return result;
    }

    public String getActiveLicentieData() throws ParseException {
        int currentActiveRentalAmount = this.getCurrentActiveRentalAmount();
        Licentie licentie = this.getLicentie();
            String result = "";

            if(currentActiveRentalAmount == 0)
                result = "Je hebt nog meer dan genoeg auto’s over!";
            if(currentActiveRentalAmount < getMaxCarFromLicentie() && currentActiveRentalAmount > (getMaxCarFromLicentie() - 3))
            {
                if (currentActiveRentalAmount >= (getMaxCarFromLicentie()-2) && currentActiveRentalAmount < getMaxCarFromLicentie())
                    result = "LET OP, Je hebt nog 2 over! Indien er meer autos nodig zijn, koop dan snel een hogere licentie";
                else
                    result = "Je hebt nog 1 auto’s over! Indien er meer autos nodig zijn, koop dan snel een hogere licentie";
            }
            if(currentActiveRentalAmount == getMaxCarFromLicentie())
                result = "Je hebt het limiet aantal auto’s tegelijkertijd bereikt, koop snel een nieuwe licentie om het te verhogen.";

            return result;

    }

    @Override
    public void userOptionMenu() throws ParseException {
        Scanner scanner = new Scanner(System.in);

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
                this.autoHuren();
                break;
            // check if user want to register
            case 2:
                this.getAccountDetail();
                break;
            case 3:
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
        System.out.println("Licentie: " + hasLicentie());
        if(hasLicentie() == true)  System.out.println("Licentie: " + getActiveLicentieData());
        System.out.println("Aantal actieve autos op dit moment: " + getCurrentActiveRentalAmount());
        System.out.println(" ");


        //Back to option menu
        gebruiker.userOptionMenu();
    }

    public void autoHuren() throws ParseException {
        DateFormat formatter = new SimpleDateFormat("d/M/yyyy");
        ArrayList<Auto> autos = new ArrayList<>();
        Boolean inputDateIsValid = false;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Wat is u gewenste startdatum? (dd/MM/yyyy):");
        String inputStartDatum = scanner.nextLine();

        System.out.println("Wat is u gewenste stopdatum? (dd-MM-yyyy):");
        String inputEindDatum = scanner.nextLine();

        if (!inputStartDatum.matches("(^(((0[1-9]|1[0-9]|2[0-8])[\\/](0[1-9]|1[012]))|((29|30|31)[\\/](0[13578]|1[02]))|((29|30)[\\/](0[4,6,9]|11)))[\\/](19|[2-9][0-9])\\d\\d$)|(^29[\\/]02[\\/](19|[2-9][0-9])(00|04|08|12|16|20|24|28|32|36|40|44|48|52|56|60|64|68|72|76|80|84|88|92|96)$)")
                && !inputEindDatum.matches("(^(((0[1-9]|1[0-9]|2[0-8])[\\/](0[1-9]|1[012]))|((29|30|31)[\\/](0[13578]|1[02]))|((29|30)[\\/](0[4,6,9]|11)))[\\/](19|[2-9][0-9])\\d\\d$)|(^29[\\/]02[\\/](19|[2-9][0-9])(00|04|08|12|16|20|24|28|32|36|40|44|48|52|56|60|64|68|72|76|80|84|88|92|96)$)")) {
            System.out.println("De datum is niet juist ingevuld");
        } else {
            inputDateIsValid = true;
        }

        if (inputDateIsValid) {
            Date startDatum = new SimpleDateFormat("d/M/yyyy").parse(inputStartDatum);
            Date eindDatum = new SimpleDateFormat("d/M/yyyy").parse(inputEindDatum);

            if (startDatum.before(VerhuurFragment.getTodaysDate()) || eindDatum.before(VerhuurFragment.getTodaysDate())) {
                System.out.println("Jouw gegeven datum is ongeldig");
            } else {

                int count = -1;
                ArrayList<Auto> beschikbaarLijst = new ArrayList<Auto>();
                System.out.println("Dit zijn de beschikbare autos op de gegeven start-eind datum:");


                for (Auto auto : Auto.getAutos()) {
                    count++;

                    for (VerhuurFragment fragment : auto.getFragmenten()) {

                        if (startDatum.before(fragment.getStartTijd()) && eindDatum.after(fragment.getStartTijd()) ||
                                startDatum.before(fragment.getEindTijd()) && eindDatum.after(fragment.getEindTijd()) ||
                                startDatum.before(fragment.getStartTijd()) && eindDatum.after(fragment.getEindTijd()) ||
                                startDatum.after(fragment.getStartTijd()) && eindDatum.before(fragment.getEindTijd())) {
                            //Auto is niet beschikbaar
                        } else {
                            //Auto is wel beschikbaar
                            beschikbaarLijst.add(auto);
                            System.out.println(count + ". " + auto.getMerk());
                        }

                    }
                }
                System.out.println("Maak een keuze");
                int inputAutoKeuze = scanner.nextInt();
                Auto selectAuto = beschikbaarLijst.get(inputAutoKeuze);

                if (this.hasLicentie() && this.getCurrentActiveRentalAmount() < this.getLicentie().type) {

                    for (Auto auto : Auto.getAutos()) {
                        if (auto == selectAuto) {
                            //Maak verhuurfragment aan en voeg die toe aan de geselecteerde auto
                            VerhuurFragment newFragment = new VerhuurFragment(startDatum, eindDatum, this, this.emailAddress);
                            auto.addFragment(newFragment);
                            this.getFragment().add(newFragment);
                            System.out.println("Uw geselecteerde auto is gehuurd");

                            //Back to option menu
                            gebruiker.userOptionMenu();
                        }
                    }
                } else {
                    System.out.println("Je voldoet niet aan de voorwaardes");
                }
            }
        }
    }
}
