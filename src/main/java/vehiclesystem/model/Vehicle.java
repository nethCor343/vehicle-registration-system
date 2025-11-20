package vehiclesystem.model;

public abstract class Vehicle {

    public static final int PLATE_DIGITS = 4;
    public static final int PLATE_LETTERS = 3;
    public static final int PLATE_TOTAL_LENGTH = PLATE_DIGITS + PLATE_LETTERS;

    private static final int BRAND_MIN_LEN = 2;
    private static final int BRAND_MAX_LEN = 30;
    private static final int MODEL_MIN_LEN = 1;
    private static final int MODEL_MAX_LEN = 20;
    private static final int COLOR_MIN_LEN = 3;
    private static final int COLOR_MAX_LEN = 15;

    private String plate;
    private String brand;
    private String model;
    private String color;
    
    public Vehicle(String plate, String brand, String model, String color) {
        setPlate(plate);
        setBrand(brand);
        setModel(model);
        setColor(color);
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

    private void setBrand(String brand) {
        this.brand = validateText(BRAND_MIN_LEN, BRAND_MAX_LEN, brand, "Brand");
    }

    private void setModel(String model) {
        this.model = validateText(MODEL_MIN_LEN, MODEL_MAX_LEN, model, "Model");
    }

    private void setColor(String color) {
        this.color = validateText(COLOR_MIN_LEN, COLOR_MAX_LEN, color,"Color");
    }

    public String getPlate() {
        return plate;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public String toString() {
        return "Plate: " + plate + "\n" +
               "Brand: " + brand + "\n" +
               "Model: " + model + "\n" +
               "Color: " + color;
    }

}