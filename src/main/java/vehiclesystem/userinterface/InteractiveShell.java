package vehiclesystem.userinterface;

import java.util.Scanner;
import vehiclesystem.model.*;
import vehiclesystem.record.*;

public class InteractiveShell {

    private static final Scanner scanner = new Scanner(System.in);
    private static final RegistrationVehicle registry = new RegistrationVehicle();

    private static int folioCounter = 1; 

    public static void main(String[] args) {
        boolean running = true;
        System.out.println("=========================================");
        System.out.println("      VEHICLE REGISTRATION SYSTEM");
        System.out.println("=========================================");

        while (running) {
            try {

                System.out.println("\n--- Step 1: Owner Details ---");
                Person person = createPerson();

                System.out.println("\n--- Step 2: Vehicle Details ---");
                Vehicle vehicle = createVehicle();

                System.out.println("\n--- Step 3: Generating Record ---");
                
                String folioId = String.format("FOL-%04d", folioCounter++);
                System.out.println(">> System assigned Unique ID: " + folioId);
                
                Identifier identifier = new Identifier(folioId, person, vehicle);
                
                registry.setIdentifier(identifier);

                System.out.println("\n*********************************");
                System.out.println("   VEHICLE REGISTRATION COMPLETE");
                System.out.println("   Assigned ID: " + folioId);
                System.out.println("*********************************");

            } catch (Exception e) {
                System.out.println("\n[CRITICAL ERROR]: An unexpected error occurred: " + e.getMessage());
                folioCounter--; 
                e.printStackTrace();
            }

            running = askToContinue();
        }

        registry.showVehicle();
        System.out.println("\nThank you for using the system.");
        scanner.close();
    }

    private static Person createPerson() {
        while (true) {
            try {
                System.out.println("Enter person details:");
                String idDoc = readRequiredString("ID Document (7-10 chars): ");
                String firstName = readRequiredString("First Name: ");
                
                Person.PersonBuilder builder = Person.builder(idDoc, firstName);

                String pSurname = readString("Paternal Surname (Enter to skip): ");
                if (!pSurname.isBlank()) builder.paternalSurname(pSurname);

                String mSurname = readString("Maternal Surname (Enter to skip): ");
                if (!mSurname.isBlank()) builder.maternalSurname(mSurname);

                return builder.build();

            } catch (IllegalArgumentException e) {
                System.out.println("[Validation Error]: " + e.getMessage());
                System.out.println("Please try again.\n");
            }
        }
    }

    private static Vehicle createVehicle() {
        while (true) {
            try {
                System.out.println("Select Vehicle Type:");
                System.out.println("1. Car");
                System.out.println("2. Truck");
                System.out.println("3. Motorcycle");
                int type = readInt("Option: ");

                String plate = readRequiredString("Plate (e.g., 1234ABC): ").toUpperCase();
                String brand = readRequiredString("Brand: ");
                String model = readString("Model (Enter for default): ");
                String color = readString("Color (Enter for default): ");

                Vehicle vehicle = null;

                switch (type) {
                    case 1:
                        Car.CarBuilder carBuilder = Car.builder(plate, brand);
                        if (!model.isBlank()) carBuilder.model(model);
                        if (!color.isBlank()) carBuilder.color(color);
                        
                        float maxSpeed = readFloat("Max Speed (km/h): ");
                        carBuilder.maxSpeed(maxSpeed);
                        carBuilder.fuelType(selectFuelType());
                        
                        vehicle = carBuilder.build();
                        break;

                    case 2:
                        Truck.TruckBuilder truckBuilder = Truck.builder(plate, brand);
                        if (!model.isBlank()) truckBuilder.model(model);
                        if (!color.isBlank()) truckBuilder.color(color);

                        int hp = readInt("Horsepower (HP): ");
                        double capacity = readDouble("Cargo Capacity (tons): ");
                        truckBuilder.horsePower(hp).cargoCapacity(capacity);
                        
                        vehicle = truckBuilder.build();
                        break;

                    case 3:
                        Motorcycle.MotorcycleBuilder motoBuilder = Motorcycle.builder(plate, brand);
                        if (!model.isBlank()) motoBuilder.model(model);
                        if (!color.isBlank()) motoBuilder.color(color);

                        int cylinders = readInt("Number of Cylinders (1-6): ");
                        motoBuilder.engineCylinders(cylinders);
                        motoBuilder.fuelType(selectFuelType());

                        vehicle = motoBuilder.build();
                        break;

                    default:
                        System.out.println("Invalid vehicle type. Please try again.");
                        continue;
                }
                return vehicle;

            } catch (IllegalArgumentException e) {
                System.out.println("[Validation Error]: " + e.getMessage());
                System.out.println("Please check your data and try again.\n");
            }
        }
    }

    private static FuelType selectFuelType() {
        System.out.println("Select Fuel Type:");
        System.out.println("1. Gasoline");
        System.out.println("2. Diesel");
        System.out.println("3. Electric");
        System.out.println("4. Hybrid");
        
        while (true) {
            int opt = readInt("Option: ");
            switch (opt) {
                case 1: return FuelType.GASOLINE;
                case 2: return FuelType.DIESEL;
                case 3: return FuelType.ELECTRIC;
                case 4: return FuelType.HYBRID;
                default: System.out.println("Invalid option. Please choose 1-4.");
            }
        }
    }

    private static boolean askToContinue() {
        while (true) {
            System.out.print("\nDo you want to register another vehicle? (Y/N): ");
            String input = scanner.nextLine().trim().toUpperCase();
            if (input.equals("Y") || input.equals("YES")) return true;
            if (input.equals("N") || input.equals("NO")) return false;
        }
    }

    private static String readString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    private static String readRequiredString(String prompt) {
        String input;
        do {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("This field is required.");
            }
        } while (input.isEmpty());
        return input;
    }

    private static int readInt(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer number.");
            }
        }
    }

    private static double readDouble(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid decimal number.");
            }
        }
    }
    
    private static float readFloat(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Float.parseFloat(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid decimal number.");
            }
        }
    }
    
}
