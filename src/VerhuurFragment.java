package src;

import java.util.Date;
import java.util.UUID;

public class VerhuurFragment {
    public UUID Id;
    public Date starttijd;
    public Date eindtijd;
    public Huurder huurder;
    public String huurderEmail;

    public VerhuurFragment(Date startTijd, Date eindTijd, Huurder huurder, String huurderEmail)
    {
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
}
