package vehiclesystem.model;

public class Car extends Vehicle {
    private float maxSpeed;

    public Car(String plate, String brand, String model, String color, float maxSpeed) {
        super(plate, brand, model, color);
    }
}
