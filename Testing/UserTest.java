package Testing;

import org.junit.Assert;
import org.junit.Test;

class UserTest {

    @Test
    void isEmailFilled() {
        User test1 = new User("test", "test", "test", "test@test.nl","test");
        User test2 = new User("test", "test", "test", "undefined","test");
        Assert.assertTrue(test1.isEmailFilled());
        Assert.assertFalse(test2.isEmailFilled());
    }


}