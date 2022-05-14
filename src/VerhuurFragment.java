package src;

import java.util.Date;
import java.util.UUID;

public class VerhuurFragment {
    public UUID Id;
    public Date StartTijd;
    public Date EindTijd;
    public Huurder Huurder;
    public String HuurderEmail;

    public UUID getId() {
        return Id;
    }

    public Date getStartTijd() {
        return StartTijd;
    }

    public Date getEindTijd() {
        return EindTijd;
    }

    public Huurder getHuurder() {
        return Huurder;
    }

    public String getHuurderEmail() {
        return HuurderEmail;
    }
}
