package vehiclesystem.model;

public class Person {

    private static final int NAME_MIN_LEN = 3;
    private static final int NAME_MAX_LEN = 25;
    private static final int ID_MIN_LEN = 7;
    private static final int ID_MAX_LEN = 10;

    private String firstName;
    private String paternalSurname;
    private String maternalSurname;
    private String idNumber;

    public Person(String firstName, String paternalSurname, String maternalSurname, String idNumber) {
        setFirstName(firstName);
        setPaternalSurname(paternalSurname);
        setMaternalSurname(maternalSurname);
        setIdNumber(idNumber);

    }

    private String validateText(int minCharacters, int maxCharacters, String text, String fieldName) {
        if (text == null || text.isBlank()) {
            throw new IllegalArgumentException(fieldName + " cannot be null or empty");
        }
        
        text = text.trim();
        text = text.toUpperCase();

        int length = text.length();
        
        if (length < minCharacters || length > maxCharacters) {
            throw new IllegalArgumentException(
                fieldName + " must be between " + minCharacters + " and " + maxCharacters +
                " characters");
        }

        return text;
    }

    private void setFirstName(String firstName) {
        this.firstName = validateText(NAME_MIN_LEN, NAME_MAX_LEN, firstName, "First Name");
    }

    private void setPaternalSurname(String paternalSurname) {
        this.paternalSurname = validateText(NAME_MIN_LEN, NAME_MAX_LEN, paternalSurname, "Paternal Surname");
    }

    private void setMaternalSurname(String maternalSurname) {
        this.maternalSurname = validateText(NAME_MIN_LEN, NAME_MAX_LEN, maternalSurname, "Maternal Surname");
    }

    private void setIdNumber(String idNumber) {
        this.idNumber = validateText(ID_MIN_LEN, ID_MAX_LEN, idNumber, "ID Number");
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPaternalSurname() {
        return paternalSurname;
    }

    public String getMaternalSurname() {
        return maternalSurname;
    }

    public String getIdNumber() {
        return idNumber;
    }

    @Override
    public String toString() {
        return "First Name: " + firstName + "\n" +
               "Paternal Surname: " + paternalSurname + "\n" +
               "Maternal Surname: " + maternalSurname + "\n" +
               "ID Number: " + idNumber;
    }
    
}
