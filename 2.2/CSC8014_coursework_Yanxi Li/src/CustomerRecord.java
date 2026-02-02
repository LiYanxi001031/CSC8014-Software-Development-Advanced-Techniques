import java.util.Date;


public class CustomerRecord {
    /**
     * The information of Customer
     */
    private Name customerName;
    private Date dateOfBirth;
    private String licence;
    private String number;

    public CustomerRecord(Name customerName, Date dateOfBirth, String licence, String number) {
        this.customerName = customerName;
        this.dateOfBirth = dateOfBirth;
        this.licence = licence;
        this.number = number;
    }

    public Name getCustomerName() {
        return customerName;
    }

    public void setCustomerName(Name customerName) {
        this.customerName = customerName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getLicence() {
        return licence;
    }

    public void setLicence(String licence) {
        if(this.licence.equals("commercial") ){
            System.out.println("commercial");
        }else if(this.licence.equals("standard") ){
            System.out.println("standard");
        }else{
            System.out.println("Please enter a right licence");
        }
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
