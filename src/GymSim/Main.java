package GymSim;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws Exception {
        User user = new User("Weishaupt", "Nevio", LocalDate.of(2008, 07, 23));
        Membership membership = new Membership(user);


        System.out.println(membership.toString());
        
    }
}
