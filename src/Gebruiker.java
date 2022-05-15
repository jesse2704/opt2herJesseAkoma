package src;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public abstract class Gebruiker {
    protected UUID id;
    protected String userName;
    protected String emailAddress;
    protected String password;
    protected String firstName;
    protected String lastName;
    protected String phoneNumber;
    protected static final ArrayList<Gebruiker> gebruikers = new ArrayList<>();

    public Gebruiker(String userName, String emailAddress, String password, String firstName, String lastName, String phoneNumber)
    {
        this.id = UUID.randomUUID();
        this.userName = userName;
        this.emailAddress = emailAddress;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        gebruikers.add(this);
    }

    public UUID getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public static ArrayList<Gebruiker> getGebruikers() {
        return gebruikers;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setEmailAddress(String emailAddress) {
        if(emailAddress.matches("^(.+)@(.+)$"))
            this.emailAddress = emailAddress;
        else
            throw new IllegalArgumentException("Please fill in a valid e-mailaddress.");
    }

    public void setPassword(String passWord) {
        if(password.matches("((?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[@#$%!]).{8,40})"))
            this.password = passWord;
        else
            throw new IllegalArgumentException("Password must be between 8 and 40 characters long,\n" +
                    "contain at least one digit,\n" +
                    "contain at least one lower case character,\n" +
                    "contain at least one upper case character,\n" +
                    "contain at least on special character from [ @ # $ % ! . ].");
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Boolean isInstanceOfHuurder() { return (this instanceof Huurder); }

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

                if (((Huurder) this).hasLicentie() && ((Huurder) this).getCurrentActiveRentalAmount() < ((Huurder) this).getLicentie().type) {

                    for (Auto auto : Auto.getAutos()) {
                        if (auto == selectAuto) {
                            //Maak verhuurfragment aan en voeg die toe aan de geselecteerde auto
                            VerhuurFragment newFragment = new VerhuurFragment(startDatum, eindDatum, (Huurder) this, this.emailAddress);
                            auto.addFragment(newFragment);
                            ((Huurder) this).getFragment().add(newFragment);
                            System.out.println("Uw geselecteerde auto is gehuurd");
                        }
                    }
                } else {
                    System.out.println("Je voldoet niet aan de voorwaardes");
                }
            }
        }
    }
}


