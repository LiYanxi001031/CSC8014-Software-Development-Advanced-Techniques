import java.util.*;

public class VehicleManagerTest {
    public static void main(String[] args) {
        System.out.println("=== VehicleManager Tests ===");

        // Test 1: Add Car
        try {
            VehicleManager manager = new VehicleManager();
            Vehicle car = manager.addVehicle("Car");
            if (car == null) throw new AssertionError("Car is null");
            if (!"Car".equals(car.getVehicleType())) throw new AssertionError("Wrong type");
            if (car.isHired()) throw new AssertionError("New car should not be hired");
            System.out.println("testAddCar PASSED");
        } catch (AssertionError e) {
            System.out.println("testAddCar FAILED: " + e.getMessage());
        }

        // Test 2: Add Van
        try {
            VehicleManager manager = new VehicleManager();
            Vehicle van = manager.addVehicle("Van");
            if (van == null) throw new AssertionError("Van is null");
            if (!"Van".equals(van.getVehicleType())) throw new AssertionError("Wrong type");
            System.out.println("testAddVan PASSED");
        } catch (AssertionError e) {
            System.out.println("testAddVan FAILED: " + e.getMessage());
        }

        // Test 3: Number of available vehicles
        try {
            VehicleManager manager = new VehicleManager();
            manager.addVehicle("Car");
            manager.addVehicle("Car");
            manager.addVehicle("Van");
            if (manager.noOfAvailableVehicles("Car") != 2)
                throw new AssertionError("Expected 2 available cars, got " + manager.noOfAvailableVehicles("Car"));
            if (manager.noOfAvailableVehicles("Van") != 1)
                throw new AssertionError("Expected 1 available van, got " + manager.noOfAvailableVehicles("Van"));
            System.out.println("testNoOfAvailableVehicles PASSED");
        } catch (AssertionError e) {
            System.out.println("testNoOfAvailableVehicles FAILED: " + e.getMessage());
        }

        // Test 4: Add Customer
        try {
            VehicleManager manager = new VehicleManager();
            Calendar cal = Calendar.getInstance();
            cal.set(1995, Calendar.MAY, 20);
            Date dob = cal.getTime();
            CustomerRecord cr = manager.addCustomerRecord("Yanxi", "Li", dob, true);
            if (cr == null) throw new AssertionError("Customer is null");
            if (!"Yanxi".equals(cr.getName().getFirstName())) throw new AssertionError("First name mismatch");
            if (!"Li".equals(cr.getName().getLastName())) throw new AssertionError("Last name mismatch");
            if (!dob.equals(cr.getDob())) throw new AssertionError("Date of birth mismatch");
            if (!cr.hasCommercialLicense()) throw new AssertionError("Should have commercial license");
            System.out.println("testAddCustomer PASSED");
        } catch (AssertionError e) {
            System.out.println("testAddCustomer FAILED: " + e.getMessage());
        }

        // Test 5: Duplicate Customer (should throw exception)
        try {
            VehicleManager manager = new VehicleManager();
            Calendar cal = Calendar.getInstance();
            cal.set(1995, Calendar.MAY, 20);
            Date dob = cal.getTime();
            manager.addCustomerRecord("Yanxi", "Li", dob, true);
            manager.addCustomerRecord("Yanxi", "Li", dob, true); // should throw
            throw new AssertionError("No exception thrown for duplicate customer");
        } catch (IllegalArgumentException e) {
            System.out.println("testDuplicateCustomer PASSED");
        } catch (AssertionError e) {
            System.out.println("testDuplicateCustomer FAILED: " + e.getMessage());
        }

        // Test 6: Hire Car - age exactly 18 (should succeed)
        try {
            VehicleManager manager = new VehicleManager();
            manager.addVehicle("Car");
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.YEAR, -18);
            Date dob = cal.getTime();
            CustomerRecord customer = manager.addCustomerRecord("Yanxi", "Li", dob, false);
            boolean hired = manager.hireVehicle(customer, "Car", 5);
            if (!hired) throw new AssertionError("18-year-old should be able to hire a car");
            System.out.println("testHireCar_ValidAge PASSED");
        } catch (AssertionError e) {
            System.out.println("testHireCar_ValidAge FAILED: " + e.getMessage());
        }

        // Test 7: Hire Car - age 17 (should fail)
        try {
            VehicleManager manager = new VehicleManager();
            manager.addVehicle("Car");
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.YEAR, -17);
            Date dob = cal.getTime();
            CustomerRecord customer = manager.addCustomerRecord("Yanxi", "Li", dob, false);
            boolean hired = manager.hireVehicle(customer, "Car", 5);
            if (hired) throw new AssertionError("17-year-old should NOT be able to hire a car");
            System.out.println("testHireCar_UnderAge PASSED");
        } catch (AssertionError e) {
            System.out.println("testHireCar_UnderAge FAILED: " + e.getMessage());
        }

        // Test 8: Hire Van - age 23 with commercial license (should succeed)
        try {
            VehicleManager manager = new VehicleManager();
            manager.addVehicle("Van");
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.YEAR, -23);
            Date dob = cal.getTime();
            CustomerRecord customer = manager.addCustomerRecord("Yanxi", "Li", dob, true);
            boolean hired = manager.hireVehicle(customer, "Van", 5);
            if (!hired) throw new AssertionError("23-year-old with commercial license should be able to hire a van");
            System.out.println("testHireVan_Valid PASSED");
        } catch (AssertionError e) {
            System.out.println("testHireVan_Valid FAILED: " + e.getMessage());
        }

        // Test 9: Hire Van - age 25 without commercial license
        try {
            VehicleManager manager = new VehicleManager();
            manager.addVehicle("Van");
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.YEAR, -25);
            Date dob = cal.getTime();
            CustomerRecord customer = manager.addCustomerRecord("Yanxi", "Li", dob, false);
            boolean hired = manager.hireVehicle(customer, "Van", 5);
            if (hired) throw new AssertionError("Customer without commercial license should NOT hire a van");
            System.out.println("testHireVan_NoLicense PASSED");
        } catch (AssertionError e) {
            System.out.println("testHireVan_NoLicense FAILED: " + e.getMessage());
        }

        // Test 10: Maximum three vehicles per customer
        try {
            VehicleManager manager = new VehicleManager();
            for (int i = 0; i < 4; i++) {
                manager.addVehicle("Car");
            }
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.YEAR, -25);
            Date dob = cal.getTime();
            CustomerRecord customer = manager.addCustomerRecord("Yanxi", "Li", dob, false);

            if (!manager.hireVehicle(customer, "Car", 1))
                throw new AssertionError("First hire failed");
            if (!manager.hireVehicle(customer, "Car", 1))
                throw new AssertionError("Second hire failed");
            if (!manager.hireVehicle(customer, "Car", 1))
                throw new AssertionError("Third hire failed");
            if (manager.hireVehicle(customer, "Car", 1))
                throw new AssertionError("Fourth hire should have failed");
            System.out.println("testHireMaxThreeVehicles PASSED");
        } catch (AssertionError e) {
            System.out.println("testHireMaxThreeVehicles FAILED: " + e.getMessage());
        }

        // Test 11: Return vehicle and check status
        try {
            VehicleManager manager = new VehicleManager();
            Vehicle car = manager.addVehicle("Car");
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.YEAR, -25);
            Date dob = cal.getTime();
            CustomerRecord customer = manager.addCustomerRecord("Yanxi", "Li", dob, false);

            manager.hireVehicle(customer, "Car", 3);
            manager.returnVehicle(car.getVehicleID(), customer, 500);
            if (car.isHired()) throw new AssertionError("Vehicle should not be hired after return");
            if (car.getCurrentMileage() != 500) throw new AssertionError("Mileage not updated correctly");
            System.out.println("testReturnVehicle PASSED");
        } catch (AssertionError e) {
            System.out.println("testReturnVehicle FAILED: " + e.getMessage());
        }

        // Test 12: Get vehicles by customer (unmodifiable)
        try {
            VehicleManager manager = new VehicleManager();
            manager.addVehicle("Car");
            manager.addVehicle("Car");
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.YEAR, -25);
            Date dob = cal.getTime();
            CustomerRecord customer = manager.addCustomerRecord("Yanxi", "Li", dob, false);
            manager.hireVehicle(customer, "Car", 1);
            manager.hireVehicle(customer, "Car", 1);

            Collection<Vehicle> hired = manager.getVechilesByCustomer(customer); // note the typo in method name
            if (hired.size() != 2) throw new AssertionError("Expected 2 hired vehicles, got " + hired.size());

            try {
                hired.add(manager.addVehicle("Car"));
                throw new AssertionError("Collection should be unmodifiable");
            } catch (UnsupportedOperationException e) {
                System.out.println("testGetCustomerVehicles FAILED");

            }
            System.out.println("testGetCustomerVehicles PASSED");
        } catch (AssertionError e) {
            System.out.println("testGetCustomerVehicles FAILED: " + e.getMessage());
        }

        System.out.println("=== VehicleManager Tests Finished ===");
    }
}