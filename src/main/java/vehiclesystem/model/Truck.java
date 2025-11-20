package vehiclesystem.model;

public class Truck  extends Vehicle {

    private static final int MIN_HP = 90;
    private static final int MAX_HP = 450;
    private static final double MIN_CAPACITY = 0.5;
    private static final double MAX_CAPACITY = 400.0;

    private int horsePower;
    private double cargoCapacity;

    public Truck(String plate, String brand, String model, String color, int horsePower, double cargoCapacity) {
        super(plate, brand, model, color);
        setHorsePower(horsePower);
        setCargoCapacity(cargoCapacity);
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

}
