package Testing;

import org.junit.Assert;
import org.junit.Test;
import src.ActieveAuto;

import static org.junit.Assert.assertEquals;

public class licentieTest {

   @Test
   //Equivalentieklasse 1
   public void testHeeftAuto1() {

        ActieveAuto actieveAuto = new ActieveAuto(0);

        assertEquals("Je hebt het limiet aantal auto’s tergelijkertijd bereikt, koop snel een nieuwe licentie om het te verhogen.", actieveAuto.heeftActieveAutos());
    }

    @Test
    //Equivalentieklasse 2
    public void testHeeftAuto2() {

        ActieveAuto actieveAuto1 = new ActieveAuto(1);
        ActieveAuto actieveAuto2 = new ActieveAuto(2);

        assertEquals("Je hebt nog 1 auto’s over! Indien er meer autos nodig zijn, koop dan snel een hogere licentie", actieveAuto1.heeftActieveAutos());
        assertEquals("Je hebt nog 2 auto’s over! Indien er meer autos nodig zijn, koop dan snel een hogere licentie", actieveAuto2.heeftActieveAutos());
    }

    @Test
    //Equivalentieklasse 3
    public void testHeeftAuto3() {

        ActieveAuto actieveAuto1 = new ActieveAuto(4);
        ActieveAuto actieveAuto2 = new ActieveAuto(5);
        ActieveAuto actieveAuto3 = new ActieveAuto(99);

        assertEquals("Je hebt nog meer dan genoeg auto’s over!", actieveAuto1.heeftActieveAutos());
        assertEquals("Je hebt nog meer dan genoeg auto’s over!", actieveAuto2.heeftActieveAutos());
        assertEquals("Je hebt nog meer dan genoeg auto’s over!", actieveAuto2.heeftActieveAutos());
    }
}
