package GymSim;

import java.time.LocalDate;



public class User {
    String name;
    String vorname;
    LocalDate geburtstag;
    

    
    public User(String name, String vorname, LocalDate geburtstag) {
        if (name.isBlank()) {
            throw new ValidationException("Name darf nicht leer sein.");
        }
        if (vorname.isBlank()) {
            throw new ValidationException("Vorname darf nicht leer sein.");
        }
        if (geburtstag.isAfter(LocalDate.now())) {
            throw new ValidationException("Geburtstag darf nicht später wie heute sein.");
        }
        if (geburtstag.plusYears(14).isAfter(LocalDate.now())) {
            throw new ValidationException("Benutzer muss mindestens 14 Jahre alt sein");
        }
       
        


        this.name = name;
        this.vorname = vorname;
        this.geburtstag = geburtstag;
        
       
    }

    public String toString() {
        return "Vorname: " + vorname + ", Name: " + name + ", Geburtsdatum: " + geburtstag;
    }

    


    

}
