import java.util.Date;

public final class CustomerRecord {

    private static int CustomerNumber = 1;
    private final Name name;
    private final Date dob;
    private final boolean hasCommercialLicense;
    private final int customerNumber;

    public CustomerRecord(Name name, Date dob, boolean hasCommercialLicense) {
        /**
         * the name and dob cannot be empty
         */
        if (name == null || dob == null) {
            throw new IllegalArgumentException("Name and date of birth cannot be empty");
        }
        this.name = name;
        this.dob = new Date(dob.getTime());
        this.hasCommercialLicense = hasCommercialLicense;
        this.customerNumber = CustomerNumber++;
    }

    public Name getName() {
        return name;
    }

    public Date getDob() {
        return new Date(dob.getTime());
    }

    public boolean hasCommercialLicense() {
        return hasCommercialLicense;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }
}