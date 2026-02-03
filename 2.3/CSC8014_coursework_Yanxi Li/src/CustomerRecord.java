import java.util.Date;


public class CustomerRecord {
    /**
     * The information of Customer
     */
    private final Name firstName;
    private final Name lastName;
    private final Name strRep;
    private final Date dob;
    private final String licence;
    private final String number;

    public CustomerRecord(Name firstName,Name lastName,Name  strRep, Date dob, String licence, String number) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.strRep = strRep;
        this.dob = dob;
        this.licence = licence;
        this.number = number;
    }

    public Name getCustomerName() {
        return firstName;
    }


    public Name getCustomerLastName() {return lastName;}


    public Name getCustomerStrRep() {return strRep;}


    public Date getDateOfBirth() {
        return dob;
    }


    public String getLicence() {
        return licence;
    }


    public String getNumber() {
        return number;
    }
}


