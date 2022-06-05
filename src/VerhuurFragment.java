package src;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class VerhuurFragment {
    private UUID Id;
    private Date starttijd;
    private Date eindtijd;
    private Huurder huurder;
    private String huurderEmail;

    public VerhuurFragment(Date startTijd, Date eindTijd, Huurder huurder, String huurderEmail) {
        this.Id = UUID.randomUUID();
        this.starttijd = startTijd;
        this.eindtijd = eindTijd;
        this.huurder = huurder;
        this.huurderEmail = huurderEmail;
    }

    public UUID getId() {
        return Id;
    }
    public Date getStartTijd() {
        return starttijd;
    }
    public Date getEindTijd() {
        return eindtijd;
    }
    public Huurder getHuurder() {
        return huurder;
    }
    public String getHuurderEmail() {
        return huurderEmail;
    }

    public static Date getTodaysDate() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date today = new Date();
        String todaysdate = formatter.format(today);
        Date todaysDate = new SimpleDateFormat("d/M/yyyy").parse(todaysdate);
        return todaysDate;
    }

    public static Date parseDate(String date) throws ParseException {
        Date parsed = new SimpleDateFormat("d/M/yyyy").parse(date);
        return parsed;
    }
}