//package Testing;
//
//import org.junit.Assert;
//import org.junit.Test;
//import src.Huurder;
//import src.Licentie;
//import src.Login;
//
//public class kanAutoHuren {
//
//    @Test
//    //Modified Condition/Decision Coverage
//    public void testKanAutoHuren()
//    {
//        //False - True
//        Huurder huurder1 = new Huurder("huurder1", "huurder1@gmail.com", "huurder", "test1", "gebruiker", "0620903861");
//        //True - False
//        Huurder huurder2 = new Huurder("huurder2", "huurder2@gmail.com", "huurder", "test2", "gebruiker", "0620903862");
//        //True - True
//        Huurder huurder3 = new Huurder("huurder3", "huurder3@gmail.com", "huurder", "test3", "gebruiker", "0620903863");
//
//        //Set licentie huurder 1 & 3
//        Licentie licentie = new Licentie(1, 8);
//        huurder1.setLicentie(licentie);
//        huurder3.setLicentie(licentie);
//
//        //check of account bestaat huurder 1 & 2 (login)
//        Login.login("huurder2", "huurder");
//        Login.login("huurder3", "huurder");
//
//        Assert.assertFalse(huurder1.kanAutoHuren());
//        Assert.assertFalse(huurder2.kanAutoHuren());
//        Assert.assertTrue(huurder3.kanAutoHuren());
//    }
//}
