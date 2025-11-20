package vehiclesystem.model;

public class Motorcycle extends Vehicle{
    
    private static final int MIN_CYLINDERS = 1;
    private static final int MAX_CYLINDERS = 6;
    
    private int engineCylinders;
    private FuelType fuelType;

    public Motorcycle(String plate, String brand, String model, String color, int engineCylinders, FuelType fuelType) {
        super(plate, brand, model, color);
        setEngineCylinders(engineCylinders);
        setFuelType(fuelType);
    }

    private void setEngineCylinders(int engineCylinders) {    
        if (engineCylinders < MIN_CYLINDERS || engineCylinders > MAX_CYLINDERS) {
            throw new IllegalArgumentException(
                "Engine cylinders (" + engineCylinders + ") must be between " 
                + MIN_CYLINDERS + " and " + MAX_CYLINDERS + "."
            );
        }
        this.engineCylinders = engineCylinders;
    }

    private void setFuelType(FuelType fuelType) {
        if (fuelType == null) {
            throw new IllegalArgumentException("FuelType cannot be null.");
        }
        this.fuelType = fuelType;
    }

    public int getEngineCylinders() {
        return engineCylinders;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

}
