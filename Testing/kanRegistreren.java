//package Testing;
//
//import org.junit.Assert;
//import org.junit.Test;
//import src.Gebruiker;
//import src.Huurder;
//import src.Login;
//
//public class kanRegistreren {
//    //Maak gebruiker aan zodat ik kan testen op uniekheid van de gebruikersnaam
//    Huurder huurder1 = new Huurder("nietUniek", "huurder@gmail.com", "#1Geheim", "test", "gebruiker", "0620903865");
//
//    @Test
//    //
//    public void testKanRegistreren1()
//    {
//        Assert.assertEquals("wachtwoord is zwak",Login.checkRegisterEligble(true, "uniek", 21, "zwak" ));
//    }
//    @Test
//    public void testKanRegistreren2()
//    {
//        Assert.assertEquals("Kies een andere gebruikersnaam",Login.checkRegisterEligble(true, "nietUniek", 21, "zwak" ));
//    }
//    @Test
//    public void testKanRegistreren3()
//    {
//        Assert.assertEquals("Je moet ouder zijn dan 21",Login.checkRegisterEligble(true, "uniek", 18, "zwak" ));
//    }
//    @Test
//    public void testKanRegistreren4()
//    {
//        Assert.assertEquals("Kies een andere gebruikersnaam" ,Login.checkRegisterEligble(true, "nietUniek", 18, "zwak" ));
//    }
//    @Test
//    public void testKanRegistreren5()
//    {
//        Assert.assertEquals("Je kan geen account aan maken zonder rijbewijs",Login.checkRegisterEligble(false, "uniek", 21, "zwak" ));
//    }
//    @Test
//    public void testKanRegistreren6()
//    {
//        Assert.assertEquals("Je kan geen account aan maken zonder rijbewijs",Login.checkRegisterEligble(false, "nietUniek", 21, "zwak" ));
//    }
//    @Test
//    public void testKanRegistreren7()
//    {
//        Assert.assertEquals("Je kan geen account aan maken zonder rijbewijs",Login.checkRegisterEligble(false, "uniek", 18, "zwak" ));
//    }
//    @Test
//    public void testKanRegistreren8()
//    {
//        Assert.assertEquals("Je kan geen account aan maken zonder rijbewijs",Login.checkRegisterEligble(false, "nietUniek", 18, "zwak" ));
//    }
//    @Test
//    public void testKanRegistreren9()
//    {
//        Assert.assertEquals("wachtwoord is matig" ,Login.checkRegisterEligble(true, "uniek", 21, "Matiger" ));
//    }
//    @Test
//    public void testKanRegistreren10()
//    {
//        Assert.assertEquals("Kies een andere gebruikersnaam" ,Login.checkRegisterEligble(true, "nietUniek", 21, "Matiger" ));
//    }
//    @Test
//    public void testKanRegistreren11()
//    {
//        Assert.assertEquals("Je moet ouder zijn dan 21" ,Login.checkRegisterEligble(true, "uniek", 18, "Matiger" ));
//    }
//    @Test
//    public void testKanRegistreren12()
//    {
//        Assert.assertEquals("Kies een andere gebruikersnaam" ,Login.checkRegisterEligble(true, "nietUniek", 18, "Matiger" ));
//    }
//    @Test
//    public void testKanRegistreren13()
//    {
//        Assert.assertEquals("Je kan geen account aan maken zonder rijbewijs",Login.checkRegisterEligble(false, "uniek", 21, "Matiger" ));
//    }
//    @Test
//    public void testKanRegistreren14()
//    {
//        Assert.assertEquals("Je kan geen account aan maken zonder rijbewijs",Login.checkRegisterEligble(false, "nietUniek", 21, "Matiger" ));
//    }
//    @Test
//    public void testKanRegistreren15()
//    {
//        Assert.assertEquals("Je kan geen account aan maken zonder rijbewijs",Login.checkRegisterEligble(false, "uniek", 18, "Matiger" ));
//    }
//    @Test
//    public void testKanRegistreren16()
//    {
//        Assert.assertEquals("Je kan geen account aan maken zonder rijbewijs",Login.checkRegisterEligble(false, "nietUniek", 18, "Matiger" ));
//    }
//    @Test
//    public void testKanRegistreren17()
//    {
//        Assert.assertEquals("Gebruiker kan worden aangemaakt" ,Login.checkRegisterEligble(true, "uniek", 21, "Sterk1234!" ));
//    }    @Test
//    public void testKanRegistreren18()
//    {
//        Assert.assertEquals("Kies een andere gebruikersnaam" ,Login.checkRegisterEligble(true, "nietUniek", 21, "Sterk12!" ));
//    }    @Test
//    public void testKanRegistreren19()
//    {
//        Assert.assertEquals("Je moet ouder zijn dan 21" ,Login.checkRegisterEligble(true, "uniek", 18, "Sterk12!" ));
//    }    @Test
//    public void testKanRegistreren20()
//    {
//        Assert.assertEquals("Kies een andere gebruikersnaam" ,Login.checkRegisterEligble(true, "nietUniek", 18, "Sterk12!" ));
//    }
//    @Test
//    public void testKanRegistreren21()
//    {
//        Assert.assertEquals("Je kan geen account aan maken zonder rijbewijs",Login.checkRegisterEligble(false, "uniek", 21, "Sterk12!" ));
//    }
//    @Test
//    public void testKanRegistreren22()
//    {
//        Assert.assertEquals("Je kan geen account aan maken zonder rijbewijs",Login.checkRegisterEligble(false, "nietUniek", 21, "Sterk12!" ));
//    }
//    @Test
//    public void testKanRegistreren23()
//    {
//        Assert.assertEquals("Je kan geen account aan maken zonder rijbewijs",Login.checkRegisterEligble(false, "uniek", 18, "Sterk12!" ));
//    }
//    @Test
//    public void testKanRegistreren24()
//    {
//        Assert.assertEquals("Je kan geen account aan maken zonder rijbewijs",Login.checkRegisterEligble(false, "nietUniek", 18, "Sterk12!" ));
//    }
//
//}
