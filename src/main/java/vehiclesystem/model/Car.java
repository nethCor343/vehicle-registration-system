package vehiclesystem.model;

public class Car extends Vehicle {

    private static final float MIN_SPEED = 5.0f;
    private static final float MAX_SPEED = 500.0f; 

    private float maxSpeed;
    private FuelType fuelType;

    public Car(String plate, String brand, String model, String color, float maxSpeed, FuelType fuelType) {
        super(plate, brand, model, color);
        setMaxSpeed(maxSpeed);
        setFuelType(fuelType); 

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

    public void setFuelType(FuelType fuelType) {
        if (fuelType == null) {
            throw new IllegalArgumentException("FuelType cannot be null.");
        }
        this.fuelType = fuelType;
    }

    public float getMaxSpeed() {
        return maxSpeed;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    @Override
    public String toString() {
        return super.toString() + 
               "\nFuel Type: " + fuelType + 
               "\nMax Speed: " + maxSpeed + " km/h";
    }

}
