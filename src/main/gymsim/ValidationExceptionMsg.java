package main.gymsim;

public class ValidationExceptionMsg {
    public static final String NAME_NICHT_BLANK = "Name darf nicht leer sein.";
    public static final String VORNAME_NICHT_BLANK = "Vorname darf nicht leer sein";
    public static final String EMAIL_NICHT_BLANK = "Email darf nicht leer sein.";
    public static final String UNGUELTIGES__MAIL_FORMAT = "Ungültiges Mail-Format.";
    public static final String GEBURTSTAG_NICHT_NACH_HEUTE = "Geburtstag darf nicht später wie heute sein.";
    public static final String USER_UNTER_99 = "Benutzer darf nicht älter als 99 Jahre alt sein.";
    public static final String USER_MIN_13 = "Benutzer muss mindestens 13 Jahre alt sein.";
    public static final String ID_MUSS_VON_TYP_UUID_SEIN = "ID muss von typ UUID sein.";
}
