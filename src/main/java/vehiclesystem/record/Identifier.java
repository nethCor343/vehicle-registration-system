package vehiclesystem.record;

import vehiclesystem.model.Person;
import vehiclesystem.model.Vehicle;

public class Identifier {

    private String idNumber;
    private Vehicle vehicle;
    private Person person;

    public Identifier(String idNumber, Person person, Vehicle vehicle) {
        setIdNumber(idNumber);
        setPerson(person);
        setVehicle(vehicle);
    }

    public void setIdNumber(String idNumber) {
        if (idNumber == null || idNumber.isBlank()) {
            throw new IllegalArgumentException("ID Number cannot be null or empty");
        }
        this.idNumber = idNumber.trim();
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Person getPerson() {
        return person;
    }

    @Override
    public String toString() {
        return "Identifier ID: " + idNumber + 
               "\n--- Person ---\n" + person.toString() +
               "\n--- Vehicle ---\n" + vehicle.toString();
    }
}