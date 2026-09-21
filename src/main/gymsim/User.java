package main.gymsim;

import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;
import java.util.regex.Pattern;


public class User {
    

    String name;
    String vorname;
    LocalDate geburtstag;
    String email;
    UUID id;
    Membership membership;

    

    
    public User(String name, String vorname, LocalDate geburtstag, String email) {
        this.name = name;
        this.vorname = vorname;
        this.geburtstag = geburtstag;
        this.email = email.trim().toLowerCase();
        this.id = UUID.randomUUID();


        validate(this.name, this.vorname, this.geburtstag, this.email, this.id);

        int age = Period.between(this.geburtstag, LocalDate.now()).getYears();

        if (age < Membership.UNDERAGE_THRESHOLD) {
            this.membership = new Membership(this, MembershipStatus.PENDING_UNDERAGE);
        } else {
            this.membership = new Membership(this, MembershipStatus.ACTIVE);
        }
    }


    private void validate(String name, String vorname, LocalDate geburtstag, String email, UUID id) {
        if (name.isBlank()) {
            throw new ValidationException(ValidationExceptionMsg.NAME_NICHT_BLANK);
        }
        if (vorname.isBlank()) {
            throw new ValidationException(ValidationExceptionMsg.VORNAME_NICHT_BLANK);
        }
        if (email.isBlank()) {
            throw new ValidationException(ValidationExceptionMsg.EMAIL_NICHT_BLANK);
        }
        if (!EMAIL_PATTERN.matcher(email).matches()) {
            throw new ValidationException(ValidationExceptionMsg.UNGUELTIGES__MAIL_FORMAT);
        }
        if (geburtstag.isAfter(LocalDate.now())) {
            throw new ValidationException(ValidationExceptionMsg.GEBURTSTAG_NICHT_NACH_HEUTE);
        }
        if (LocalDate.now().minusYears(99).isAfter(geburtstag)) {
            throw new ValidationException(ValidationExceptionMsg.USER_UNTER_99);
        }
        if (geburtstag.plusYears(13).isAfter(LocalDate.now())) {
            throw new ValidationException(ValidationExceptionMsg.USER_MIN_13);
        }
        if (!UUID_REGEX.matcher(id.toString()).matches()) {
            throw new ValidationException(ValidationExceptionMsg.ID_MUSS_VON_TYP_UUID_SEIN);
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

    public Membership getMembership() { return membership; }


    private static final Pattern EMAIL_PATTERN =
        Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");

    private static final Pattern UUID_REGEX =
        Pattern.compile("^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$");
}

