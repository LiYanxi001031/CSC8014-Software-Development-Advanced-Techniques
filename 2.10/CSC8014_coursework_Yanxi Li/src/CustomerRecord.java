import java.util.Date;

public final class CustomerRecord {

    private static long nextCustomerNumber = 1;
    private final String  firstName;
    private final String  lastName;
    private final Date dob;
    private final boolean commercialLicence;
    private final long customerNumber;

    public CustomerRecord(String firstName, String lastName, Date dob, boolean commercialLicence) {
        if (firstName == null || lastName == null || dob == null) {
            throw new IllegalArgumentException("The name and date of birth cannot be empty");
        }

        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = new Date(dob.getTime());
        this.commercialLicence = commercialLicence;
        this.customerNumber = nextCustomerNumber++;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getDateOfBirth() {
        return new Date(dob.getTime());
    }

    public boolean hasCommercialLicence() {
        return commercialLicence;
    }

    public long getCustomerNumber() {
        return customerNumber;
    }
}