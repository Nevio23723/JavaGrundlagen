package test.gymsim;


import java.lang.reflect.Member;
import java.time.LocalDate;

import main.gymsim.Membership;
import main.gymsim.MembershipStatus;
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
                () -> assertEquals(geburtstag, user.getDateOfBirth()),
                () -> assertEquals(MembershipStatus.ACTIVE, user.getMembership().getMembershipStatus())
        );
    }

    @Test
    public void createUser_Pending_Underage() {
        LocalDate geburtstag = LocalDate.now().minusYears(13);
        User user = new User("Weishaupt", "Nevio", geburtstag, "nevio.weishaupt@gmail.com");

        assertEquals(MembershipStatus.PENDING_UNDERAGE, user.getMembershipStatus());
    }

    @Test
    public void createUser_Awaiting_Clearance() {
        LocalDate geburtstag = LocalDate.now().minusYears(90);
        User user = new User("Weishaupt", "Nevio", geburtstag, "nevio.weishaupt@gmail.com");

        assertEquals(MembershipStatus.AWAITING_MEDICAL_CLEARANCE, user.getMembershipStatus());
    }




}


