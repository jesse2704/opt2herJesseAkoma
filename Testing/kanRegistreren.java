package Testing;

import org.junit.Assert;
import org.junit.Test;
import src.Gebruiker;
import src.Huurder;
import src.Login;

import java.util.UUID;

public class kanRegistreren {
    @Test
    //
    public void testKanRegistreren1()
    {
        Assert.assertEquals("Gebruikersnaam is niet uniek",Login.checkRegisterEligble(true, false, 21, "matig" ));
    }
    @Test
    public void testKanRegistreren2()
    {
        Assert.assertEquals("Je moet ouder zijn dan 20",Login.checkRegisterEligble(true, true, 20, "goed" ));
    }
    @Test
    public void testKanRegistreren3()
    {
        Assert.assertEquals("Je kan geen account aan maken zonder rijbewijs",Login.checkRegisterEligble(false, false, 20, "zwak" ));
    }
    @Test
    public void testKanRegistreren4()
    {
        Assert.assertEquals("Je kan geen account aan maken zonder rijbewijs" ,Login.checkRegisterEligble(false, true, 20, "matig" ));
    }
    @Test
    public void testKanRegistreren5()
    {
        Assert.assertEquals("Je kan geen account aan maken zonder rijbewijs",Login.checkRegisterEligble(false, true, 21, "goed" ));
    }
    @Test
    public void testKanRegistreren6()
    {
        Assert.assertEquals("Wachtwoord is zwak",Login.checkRegisterEligble(true, true, 21, "zwak" ));
    }
    @Test
    public void testKanRegistreren7()
    {
        Assert.assertEquals("Gebruikersnaam is niet uniek",Login.checkRegisterEligble(true, false, 20, "goed" ));
    }

}
