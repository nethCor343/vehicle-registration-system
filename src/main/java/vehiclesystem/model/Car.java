package vehiclesystem.model;

public class Car extends Vehicle {

    private static final float MIN_SPEED = 5.0f;
    private static final float MAX_SPEED = 500.0f; 

    private float maxSpeed;
    private FuelType fuelType;

    private Car(CarBuilder builder) {
        super(builder);
        setMaxSpeed(builder.getMaxSpeedValue());
        setFuelType(builder.getFuelTypeValue()); 
    }

    public static CarBuilder builder(String plate, String brand) {
        return new CarBuilder(plate, brand);
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

    public float getMaxSpeed() { return maxSpeed; }
    public FuelType getFuelType() { return fuelType; }

    @Override
    public String toString() {
        return super.toString() + 
               "\nFuel Type: " + fuelType + 
               "\nMax Speed: " + maxSpeed + " km/h";
    }

    public static class CarBuilder extends VehicleBuilder<CarBuilder> {
        
        private float maxSpeed = 100.0f;
        private FuelType fuelType = FuelType.GASOLINE;

        public CarBuilder(String plate, String brand) {
            super(plate, brand);
        }

        public CarBuilder maxSpeed(float maxSpeed) {
            this.maxSpeed = maxSpeed;
            return this;
        }

        public CarBuilder fuelType(FuelType fuelType) {
            this.fuelType = fuelType;
            return this;
        }

        protected float getMaxSpeedValue() {
            return maxSpeed;
        }

        protected FuelType getFuelTypeValue() {
            return fuelType;
        }

        @Override
        protected CarBuilder self() {
            return this;
        }

        @Override
        public Car build() {
            return new Car(this);
        }
    }
}