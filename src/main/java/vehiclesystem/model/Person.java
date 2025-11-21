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

    }

    private String validateText(int minCharacters, int maxCharacters, String text, String fieldName) {
        if (text == null || text.isBlank()) {
            throw new IllegalArgumentException(text + " cannot be null or empty");
        }
        
        text = text.trim();
        text = text.toUpperCase();

        int length = text.length();
        
        if (length < minCharacters || length > maxCharacters) {
            throw new IllegalArgumentException(
                text + " must be between " + minCharacters + " and " + maxCharacters +
                " characters");
        }

        return text;
    }

}
