import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class VehicleID {

    private static final Random random = new Random();
    private static final Set<String> usedIDs = new HashSet<>();

    private final char vehicleType;
    private final char randomLetter;
    private final int randomDigit;
    private final int numberComponent;

    public VehicleID(char vehicleType) {
        if (vehicleType != 'C' && vehicleType != 'V') {
            throw new IllegalArgumentException("Vehicle type must be 'C' or 'V'");
        }
        this.vehicleType = vehicleType;

        String generatedID;
        char letter;
        int digit;
        int number;

        do {
            letter = (char) ('A' + random.nextInt(26));
            digit = random.nextInt(10);
            number = generateNumber(vehicleType);

            generatedID = String.format(
                    "%c%c%d-%03d",
                    vehicleType, letter, digit, number
            );
        } while (usedIDs.contains(generatedID));

        usedIDs.add(generatedID);

        this.randomLetter = letter;
        this.randomDigit = digit;
        this.numberComponent = number;
    }

    private int generateNumber(char type) {
        int num;
        do {
            num = random.nextInt(1000); // 000–999
        } while ((type == 'C' && num % 2 != 0) ||
                (type == 'V' && num % 2 == 0));
        return num;
    }

    public char getVehicleType() {
        return vehicleType;
    }

    public char getRandomLetter() {
        return randomLetter;
    }

    public int getRandomDigit() {
        return randomDigit;
    }

    public int getNumberComponent() {
        return numberComponent;
    }

    @Override
    public String toString() {
        return String.format(
                "%c%c%d-%03d",
                vehicleType, randomLetter, randomDigit, numberComponent
        );
    }
}
