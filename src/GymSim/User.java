package gymsim;

import java.time.LocalDate;
import java.util.regex.Pattern;


public class User {
    String name;
    String vorname;
    LocalDate geburtstag;
    String email;
    

    
    public User(String name, String vorname, LocalDate geburtstag, String email) {
        if (name.isBlank()) {
            throw new ValidationException("Name darf nicht leer sein.");
        }
        if (vorname.isBlank()) {
            throw new ValidationException("Vorname darf nicht leer sein.");
        }
        if (email.isBlank()) {
            throw new ValidationException("Email darf nicht leer sein.");
        }
        if (!EMAIL_PATTERN.matcher(email).matches()) {
            throw new ValidationException("Ungültiges Mail-Format.");
        }
        if (geburtstag.isAfter(LocalDate.now())) {
            throw new ValidationException("Geburtstag darf nicht später wie heute sein.");
        }
        if (LocalDate.now().minusYears(99).isAfter(geburtstag)) {
            throw new ValidationException("Benutzer darf nicht älter als 99 Jahre alt sein.");
        }
        if (geburtstag.plusYears(14).isAfter(LocalDate.now())) {
            throw new ValidationException("Benutzer muss mindestens 14 Jahre alt sein.");
        }
       
        


        this.name = name;
        this.vorname = vorname;
        this.geburtstag = geburtstag;
        this.email = email.trim().toLowerCase();
    }

    public String toString() {
        return "Vorname: " + vorname + ", Name: " + name + ", Geburtsdatum: " + geburtstag;
    }

    public String getUsername() {
        return vorname + " " + name;
    }

    private static final Pattern EMAIL_PATTERN =
        Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");



    


    

}
