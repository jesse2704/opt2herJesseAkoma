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

        Scanner scanner = new Scanner (System.in);
        System.out.println("Wat is u gewenste startdatum? (30/06/2022):");
        String inputStartDatum = scanner.nextLine();
        Date startDatum= new SimpleDateFormat("d/M/yyyy").parse(inputStartDatum);

        System.out.println("Wat is u gewenste stopdatum? (31-06-2022):");
        String inputEindDatum = scanner.nextLine();
        Date eindDatum= new SimpleDateFormat("d/M/yyyy").parse(inputEindDatum);


        int count = -1;
        ArrayList<Auto> beschikbaarLijst = new ArrayList<Auto>();
        System.out.println("Dit zijn de beschikbare autos op de gegeven start-eind datum:");


        for (Auto auto : Auto.getAutos())
        {
            count++;

            for (VerhuurFragment fragment : auto.getFragmenten())
            {

                if(startDatum.before(fragment.getStartTijd()) && eindDatum.after(fragment.getStartTijd()) ||
                        startDatum.before(fragment.getEindTijd()) && eindDatum.after(fragment.getEindTijd()) ||
                        startDatum.before(fragment.getStartTijd()) && eindDatum.after(fragment.getEindTijd()) ||
                        startDatum.after(fragment.getStartTijd()) && eindDatum.before(fragment.getEindTijd()) )
                {
                    //Auto is niet beschikbaar
                    System.out.print("They overlap");
                }

                else {
                    //Auto is wel beschikbaar
                    beschikbaarLijst.add(auto);
                    System.out.println(count + ". "+  auto.getMerk());
                }

            }
        }
        System.out.println("Maak een keuze");
        int inputAutoKeuze = scanner.nextInt();
        Auto selectAuto = beschikbaarLijst.get(inputAutoKeuze);
        System.out.println(selectAuto);

            for (Auto auto : Auto.getAutos())
            {
                if (auto == selectAuto)
                {
                    //Maak verhuurfragment aan en voeg die toe aan de geselecteerde auto
                    VerhuurFragment newFragment = new VerhuurFragment(startDatum, eindDatum, (Huurder) this, this.emailAddress);
                    auto.addFragment(newFragment);
                    System.out.println("Uw geselecteerde auto is gehuurd");
                }
            }

        }

    }


