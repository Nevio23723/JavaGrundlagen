package main.gymsim;

import java.time.LocalDate;
import java.util.UUID;
import java.util.regex.Pattern;


public class User {
    public static final String NAME_DARF_NICHT_LEER_SEIN = "Name darf nicht leer sein.";
    String name;
    String vorname;
    LocalDate geburtstag;
    String email;
    UUID id;
    

    
    public User(String name, String vorname, LocalDate geburtstag, String email) {
        this.name = name;
        this.vorname = vorname;
        this.geburtstag = geburtstag;
        this.email = email.trim().toLowerCase();
        this.id = UUID.randomUUID();

        validate(this.name, this.vorname, this.geburtstag, this.email, this.id);

    }

    private void validate(String name, String vorname, LocalDate geburtstag, String email, UUID id) {
        if (name.isBlank()) {
            throw new ValidationException(NAME_DARF_NICHT_LEER_SEIN);
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
        if (!UUID_REGEX.matcher(id.toString()).matches()) {
            throw new ValidationException("ID muss von typ UUID sein.");
        }
    }

    public String toString() {
        return "Id: " + id + ", Vorname: " + vorname + ", Name: " + name + ", Geburtsdatum: " + geburtstag;
    }

    public String getUsername() {
        return vorname + " " + name;
    }

    public LocalDate getDateOfBirth() { return geburtstag; }

    public UUID getId() { return id; }

    public String getEmail() { return email; }

    

    private static final Pattern EMAIL_PATTERN =
        Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");

    private static final Pattern UUID_REGEX =
        Pattern.compile("^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$");
}

