package main.gymsim;

public class FacilityAccess {
    boolean hasAccess;


    public FacilityAccess (boolean hasAccess) {
        this.hasAccess = hasAccess;

        if (hasAccess) {
            System.out.println("Welcome ");
        }
    }
}
