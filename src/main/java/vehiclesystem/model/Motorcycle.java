package vehiclesystem.model;

public class Motorcycle extends Vehicle {
    
    private static final int MIN_CYLINDERS = 1;
    private static final int MAX_CYLINDERS = 6;
    
    private int engineCylinders;
    private FuelType fuelType;

    private Motorcycle(MotorcycleBuilder builder) {
        super(builder);
        setEngineCylinders(builder.getEngineCylindersValue());
        setFuelType(builder.getFuelTypeValue());
    }

    public static MotorcycleBuilder builder(String plate, String brand) {
        return new MotorcycleBuilder(plate, brand);
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

    public int getEngineCylinders() { return engineCylinders; }
    public FuelType getFuelType() { return fuelType; }

    @Override
    public String toString() {
        return super.toString() + 
               "\nFuel Type: " + fuelType + 
               "\nEngine Cylinders: " + engineCylinders;
    }

    public static class MotorcycleBuilder extends VehicleBuilder<MotorcycleBuilder> {
        
        private int engineCylinders = 1;
        private FuelType fuelType = FuelType.GASOLINE;

        public MotorcycleBuilder(String plate, String brand) {
            super(plate, brand);
        }

        public MotorcycleBuilder engineCylinders(int engineCylinders) {
            this.engineCylinders = engineCylinders;
            return this;
        }

        public MotorcycleBuilder fuelType(FuelType fuelType) {
            this.fuelType = fuelType;
            return this;
        }

        protected int getEngineCylindersValue() {
            return engineCylinders;
        }

        protected FuelType getFuelTypeValue() {
            return fuelType;

        }
        
        @Override
        protected MotorcycleBuilder self() {
            return this;
        }

        @Override
        public Motorcycle build() {
            return new Motorcycle(this);
        }
    }
}