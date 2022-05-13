import java.util.Date;

public class VerhuurFragment {
    public int Id;
    public Date StartTijd;
    public Date EindTijd;
    public Huurder Huurder;
    public String HuurderEmail;

    public int getId() {
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
