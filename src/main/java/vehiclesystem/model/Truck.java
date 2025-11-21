package vehiclesystem.model;

public class Truck extends Vehicle {

    private static final int MIN_HP = 90;
    private static final int MAX_HP = 450;
    private static final double MIN_CAPACITY = 0.5;
    private static final double MAX_CAPACITY = 400.0;

    private int horsePower;
    private double cargoCapacity;

    private Truck(TruckBuilder builder) {
        super(builder);
        setHorsePower(builder.getHorsePowerValue());
        setCargoCapacity(builder.getCargoCapacityValue());
    }

    public static TruckBuilder builder(String plate, String brand) {
        return new TruckBuilder(plate, brand);
    }

    private void setHorsePower(int horsePower) {
        if (horsePower < MIN_HP || horsePower > MAX_HP) {
            throw new IllegalArgumentException(
                "HorsePower (" + horsePower + ") must be between " + MIN_HP + " and " + MAX_HP + "."
            );
        }

        this.horsePower = horsePower;
    }

    private void setCargoCapacity(double cargoCapacity) {        
        if (cargoCapacity < MIN_CAPACITY || cargoCapacity > MAX_CAPACITY) {
            throw new IllegalArgumentException(
                "Cargo capacity (" + cargoCapacity + ") must be between " + MIN_CAPACITY +
                " and " + MAX_CAPACITY + " tons."
            );
        }

        this.cargoCapacity = cargoCapacity;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public double getCargoCapacity() {
        return cargoCapacity;
    }

    @Override
    public String toString() {
        return super.toString() + 
               "\nHorse Power: " + horsePower + " hp" +
               "\nCargo Capacity: " + cargoCapacity + " tons";
    }

    public static class TruckBuilder extends VehicleBuilder<TruckBuilder> {

        private int horsePower = 90; 
        private double cargoCapacity = 0.5;

        public TruckBuilder(String plate, String brand) {
            super(plate, brand);
        }

        public TruckBuilder horsePower(int horsePower) {
            this.horsePower = horsePower;
            return this;
        }

        public TruckBuilder cargoCapacity(double cargoCapacity) {
            this.cargoCapacity = cargoCapacity;
            return this;
        }

        protected int getHorsePowerValue() {
            return horsePower; 
        }

        protected double getCargoCapacityValue() {
            return cargoCapacity;
        }

        @Override
        protected TruckBuilder self() {
            return this;
        }

        @Override
        public Truck build() {
            return new Truck(this);
        }
    }

}