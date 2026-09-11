package test.gymsim;

import static org.junit.jupiter.api.Assertions.assertEquals;


import java.time.LocalDate;
import org.junit.*;

import main.gymsim.User;

public class UserTest {


    @Test 
    public void testeMich() {
        User user = new User("Weishaupt ", "Nevio", LocalDate.of(2008, 07, 23),"nevio.weishaupt@gmail.com");

        assertEquals(user.getName(), "Weishaupt "); 
    }
}
