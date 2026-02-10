import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class VehicleID {

    private static final Random random = new Random();
    private static final Set<String> usedIds = new HashSet<>();

    private final String firstComponent;
    private final String secondComponent;

    public enum VehicleType {
        CAR('C'),
        VAN('V');

        private final char code;

        VehicleType(char code) {
            this.code = code;
        }

        public char getCode() {
            return code;
        }
    }

    public VehicleID(VehicleType type) {
        String id;
        String comp1;
        String comp2;

        do {
            comp1 = generateFirstComponent(type);
            comp2 = generateSecondComponent(type);
            id = comp1 + "-" + comp2;
        } while (!usedIds.contains(id));

        usedIds.add(id);
        this.firstComponent = comp1;
        this.secondComponent = comp2;
    }

    private String generateFirstComponent(VehicleType type) {
        char typeChar = type.getCode();
        char randomLetter = (char) ('A' + random.nextInt(26));
        int randomDigit = random.nextInt(10);

        return "" + typeChar + randomLetter + randomDigit;
    }

    private String generateSecondComponent(VehicleType type) {
        int number;

        /**
         * Bound is 1000 because the secondComponent is 000-999
         */
         number = random.nextInt(1000);
         return String.format("%03d", number);
    }

    public String getFirstComponent() {
        return firstComponent;
    }

    public String getSecondComponent() {
        return secondComponent;
    }

    @Override
    public String toString() {
        return firstComponent + "-" + secondComponent;
    }
}