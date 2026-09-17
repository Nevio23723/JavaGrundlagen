package test.gymsim;


import java.time.LocalDate;

import main.gymsim.ValidationException;
import org.junit.*;

import main.gymsim.User;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {


    @Test
    public void createUser_withValidData() {
        LocalDate geburtstag = LocalDate.of(2008, 7, 23);

        User user = new User("Weishaupt", "Nevio", geburtstag, "nevio.weishaupt@gmail.com");

        assertAll(
                () -> assertEquals("Nevio Weishaupt", user.getUsername()),
                () -> assertEquals("nevio.weishaupt@gmail.com", user.getEmail()),
                () -> assertEquals(geburtstag, user.getDateOfBirth())
        );
    }
    @Test
    public void userLastNameNotBlank() {
        ValidationException exception = assertThrows(ValidationException.class, () -> {
                    new User("", "Nevio", LocalDate.of(2008, 7, 23), "nevio.weishaupt@gmail.com");
                });

        assertEquals(User.NAME_DARF_NICHT_LEER_SEIN, exception.getMessage());
    }


}


