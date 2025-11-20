package vehiclesystem.model;

public abstract class Vehicle {

    public static final int PLATE_DIGITS = 4;
    public static final int PLATE_LETTERS = 3;
    public static final int PLATE_TOTAL_LENGTH = PLATE_DIGITS + PLATE_LETTERS;

    private String plate;
    private String brand;
    private String model;
    private String color;
    
    public Vehicle(String plate, String brand, String model, String color) {
        setPlate(plate);
    }

    private void setPlate(String plate) {
        char indexChar;
        boolean isUpper;

        if (plate == null) {
            throw new IllegalArgumentException("The plate cannot be null.");
        }

        plate = plate.trim();

        if (plate.length() != (PLATE_TOTAL_LENGTH)) {
            throw new IllegalArgumentException(
                "The plate must have exactly " + (PLATE_TOTAL_LENGTH) + " characters ("
                + PLATE_DIGITS + " digits + " + PLATE_LETTERS + " letters)."
            );
        }

        for (int i = 0; i < PLATE_DIGITS; i++) {
            indexChar = plate.charAt(i);

            if (indexChar < '0' || indexChar > '9') {
                throw new IllegalArgumentException(
                    "The first " + PLATE_DIGITS + " characters must be digits. Error at position "
                    + (i + 1) + " ('" + indexChar + "')."
                );
            }
        }

        for (int i = PLATE_DIGITS; i < (PLATE_TOTAL_LENGTH); i++) {
            indexChar = plate.charAt(i);
            isUpper = (indexChar >= 'A' && indexChar <= 'Z');

            if (!isUpper) {
                throw new IllegalArgumentException(
                    "The last " + PLATE_LETTERS + " characters must be UPPERCASE letters. Error at position "
                    + (i + 1) + " ('" + indexChar + "')."
                );
            }
        }
        this.plate = plate;
    }
    
    private String validateText(int minCharacters, int maxCharacters, String text, String fieldName) {   
        
        if (text == null || text.isBlank()) {
            throw new IllegalArgumentException(fieldName + " cannot be null or empty");
        }
        
        text = text.trim();
        int length = text.length();
        
        if (length < minCharacters || length > maxCharacters) {
            throw new IllegalArgumentException(
                fieldName + " must be between " + minCharacters + " and " + maxCharacters +
                " characters");
        }

        return text;
    }

    public String getPlate() {
        return plate;
    }

}