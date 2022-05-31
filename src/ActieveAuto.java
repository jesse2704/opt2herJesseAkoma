package src;

public class ActieveAuto {
    int actieveAuto;

    public ActieveAuto(int actieveAuto)
    {
        this.actieveAuto = actieveAuto;
    }

    public String heeftActieveAutos()
    {
        String result = "";

        if(actieveAuto == 0)
            result = "Je hebt het limiet aantal auto’s tegelijkertijd bereikt, koop snel een nieuwe licentie om het te verhogen.";
        if(actieveAuto >= 1 && actieveAuto <= 3)
        {
            if (actieveAuto == 1)
                result = "Je hebt nog " + actieveAuto + " auto’s over! Indien er meer autos nodig zijn, koop dan snel een hogere licentie";
            else
                result = "Je hebt nog " + actieveAuto + " auto’s over! Indien er meer autos nodig zijn, koop dan snel een hogere licentie";
        }
        if(actieveAuto > 3)
            result = "Je hebt nog meer dan genoeg auto’s over!";

        return result;
    }
}
