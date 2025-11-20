package vehiclesystem.model;

public class Car extends Vehicle {

    private static final float MIN_SPEED = 5.0f;
    private static final float MAX_SPEED = 500.0f; 

    private float maxSpeed;

    public Car(String plate, String brand, String model, String color, float maxSpeed) {
        super(plate, brand, model, color);
        setMaxSpeed(maxSpeed);

    }

    private void setMaxSpeed(float maxSpeed) {
        if (maxSpeed < MIN_SPEED || maxSpeed > MAX_SPEED) {
            throw new IllegalArgumentException(
                "Max speed is invalid. It must be between " + MIN_SPEED + " and " + MAX_SPEED +
                " km/h. Received value: " + maxSpeed
            );
        }
        this.maxSpeed = maxSpeed;
    }

    public float getMaxSpeed() {
        return maxSpeed;
    }

}
