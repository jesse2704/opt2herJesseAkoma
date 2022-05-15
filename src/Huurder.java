package src;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Huurder extends Gebruiker {

    public ArrayList<VerhuurFragment> fragment;
    public Licentie licentie;

    public Huurder(String userName, String emailAddress, String password, String firstName, String lastName, String phoneNumber) {
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

    public Boolean hasLicentie(){
        if (this.getLicentie() != null) return true;
        return false;
    }

    public int getMaxCarFromLicentie()
    {
        return this.getLicentie().maxAuto;
    }

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

    public void setLicentie(Licentie licentie) {
        this.licentie = licentie;
    }
}
