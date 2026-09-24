package main.gymsim;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws Exception {
        try {
        User user = new User("Weishaupt ", "Nevio", LocalDate.of(2008, 07, 23),"nevio.weishaupt@gmail.com");
        //System.out.println(user);

        Membership membership = new Membership(user);
        System.out.println(user.getMembershipStatus());

        } catch (ValidationException e) {
            System.out.println("Fehler beim Erstellen des Benutzers: " + e.getMessage());
        }
        finally {
            // spätere features 
            // databaseConnection.close();
        }

        
        
    }
}
