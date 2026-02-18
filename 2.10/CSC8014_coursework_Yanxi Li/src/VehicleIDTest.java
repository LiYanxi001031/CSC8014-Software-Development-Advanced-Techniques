public class VehicleIDTest {
    public static void main(String[] args) {
        System.out.println("=== VehicleID Tests ===");

        // Test 1: Car ID format
        try {
            VehicleID id = VehicleID.getInstance(VehicleID.VehicleType.CAR);
            String str = id.toString();

            if (!str.matches("C[A-Z][0-9]-\\d{3}")) {
                throw new AssertionError("Wrong format: " + str);
            }
            String[] parts = str.split("-");
            int num = Integer.parseInt(parts[1]);
            if (num % 2 != 0) {
                throw new AssertionError("Car ID should end with an even number, got: " + num);
            }
            System.out.println("testCarIDFormat PASSED");
        } catch (AssertionError e) {
            System.out.println("testCarIDFormat FAILED: " + e.getMessage());
        }

        // Test 2: Van ID format
        try {
            VehicleID id = VehicleID.getInstance(VehicleID.VehicleType.VAN);
            String str = id.toString();
            if (!str.matches("V[A-Z][0-9]-\\d{3}")) {
                throw new AssertionError("Wrong format: " + str);
            }
            String[] parts = str.split("-");
            int num = Integer.parseInt(parts[1]);
            if (num % 2 == 0) {
                throw new AssertionError("Van ID should end with an odd number, got: " + num);
            }
            System.out.println("testVanIDFormat PASSED");
        } catch (AssertionError e) {
            System.out.println("testVanIDFormat FAILED: " + e.getMessage());
        }

        // Test 3: ID uniqueness
        try {
            VehicleID id1 = VehicleID.getInstance(VehicleID.VehicleType.CAR);
            VehicleID id2 = VehicleID.getInstance(VehicleID.VehicleType.CAR);
            if (id1.toString().equals(id2.toString())) {
                throw new AssertionError("Two different car IDs are the same: " + id1);
            }
            System.out.println("testIDUniqueness PASSED");
        } catch (AssertionError e) {
            System.out.println("testIDUniqueness FAILED: " + e.getMessage());
        }

        System.out.println("=== VehicleID Tests Finished ===");
    }
}