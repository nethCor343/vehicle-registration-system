package vehiclesystem.record;

import java.util.ArrayList;

public class RegistrationVehicle {

    private ArrayList<Identifier> record;

    public RegistrationVehicle() {
        record = new ArrayList<>();
    }

    public void setIdentifier(Identifier newIdentifier) {
        if (newIdentifier == null) {
            throw new IllegalArgumentException("Cannot register a null Identifier.");
        }

        record.add(newIdentifier);
    }

    public void showVehicle() {
        System.out.println("\n=== VEHICLE REGISTRY ===");
        
        if (record.isEmpty()) {
            System.out.println("No vehicles currently registered.");
            return;
        }

        int count = 1;
        for (Identifier id : record) {
            System.out.println("\nRecord #" + count);
            System.out.println(id); 
            System.out.println("------------------------------------------------");
            count++;
        }

        System.out.println("Total records: " + record.size());
    }
    
    public Identifier findById(String idNumber) {
        for (Identifier id : record) {
            if (id.getIdNumber().equals(idNumber)) {
                return id;
            }
        }
        return null; 
    }
    
}