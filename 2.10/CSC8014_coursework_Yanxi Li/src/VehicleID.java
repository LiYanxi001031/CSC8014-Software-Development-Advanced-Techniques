import java.util.HashSet;
import java.util.Objects;
import java.util.Random;
import java.util.Set;

public final class VehicleID {

    public enum VehicleType { CAR, VAN }

    private static final Random random = new Random();
    private static final Set<String> usedIDs = new HashSet<>();


    private final char typeChar;
    private final char randomLetter;
    private final int randomDigit;


    private final int numberComponent;


    private VehicleID(char typeChar,
                      char randomLetter,
                      int randomDigit,
                      int numberComponent) {

        this.typeChar = typeChar;
        this.randomLetter = randomLetter;
        this.randomDigit = randomDigit;
        this.numberComponent = numberComponent;
    }


    public static VehicleID getInstance(VehicleType type) {

        char typeChar = (type == VehicleType.CAR) ? 'C' : 'V';

        while (true) {

            char randomLetter = (char) ('A' + random.nextInt(26));
            int randomDigit = random.nextInt(10);

            int number;
            do {
                number = random.nextInt(1000);
            } while ((type == VehicleType.CAR && number % 2 != 0) ||
                    (type == VehicleType.VAN && number % 2 == 0));

            String idString = String.format("%c%c%d-%03d",
                    typeChar, randomLetter, randomDigit, number);

            if (!usedIDs.contains(idString)) {
                usedIDs.add(idString);

                return new VehicleID(
                        typeChar,
                        randomLetter,
                        randomDigit,
                        number
                );
            }
        }
    }

    public String getFirstComponent() {
        return "" + typeChar + randomLetter + randomDigit;
    }

    public int getSecondComponent() {
        return numberComponent;
    }

    @Override
    public String toString() {
        return String.format("%c%c%d-%03d",
                typeChar,
                randomLetter,
                randomDigit,
                numberComponent);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VehicleID that)) return false;
        return this.toString().equals(that.toString());
    }

    @Override
    public int hashCode() {
        return Objects.hash(toString());
    }
}
