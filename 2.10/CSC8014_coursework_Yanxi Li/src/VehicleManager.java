import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

/**
 * VehicleManager  
 *
 * @author Rouaa Yassin Kassab
 * Copyright (C) 2026 Newcastle University, UK
 */

public class VehicleManager {

	/** When you add the VehicleManager.java and Vehicle.java to your project,
	 * you will get a compilation error
	 * because the other classes are not created yet. 
	 * This will be resolved once you create the required classes.
	 **/


	ArrayList<Vehicle> allVehicles = new ArrayList<Vehicle>();
	ArrayList<CustomerRecord> customers = new ArrayList<CustomerRecord>();
	HashMap<Vehicle, CustomerRecord> hiredVehicles = new HashMap<>();

	//you can add attributes and additional methods if needed.
	//you can throw an exception if needed


	public Vehicle addVehicle(String vehicleType){
		//add your code here. Do NOT change the method signature
        if(vehicleType.equals("Car")){
            Vehicle car = new Car(new VehicleID(VehicleID.VehicleType.CAR));
            allVehicles.add(car);
            return car;
        }
        else if(vehicleType.equals("Van")){
            Vehicle van = new Van(new VehicleID(VehicleID.VehicleType.VAN));
           allVehicles.add(van);
           return van;
        }else {
            throw new IllegalArgumentException("Invalid Vehicle Type, please try again");
        }
	}

	public int noOfAvailableVehicles(String vehicleType) {
		//add your code here. Do NOT change the method signature

		return 0; 
	}


	public CustomerRecord addCustomerRecord(String firstName, String lastName, Date dob, Boolean hasCommercialLicense) {
		//add your code here. Do NOT change the method signature
        CustomerRecord customerRecord = new CustomerRecord(firstName,lastName, dob,hasCommercialLicense);
        if(customers.contains(customerRecord)) {
            throw new IllegalArgumentException("Customer already exists, Please enter a new customer.");
        }else{
            customers.add(customerRecord);
            return customerRecord;
        }
	}



	public boolean hireVehicle(CustomerRecord customerRecord, String vehicleType, int duration) {
		//add your code here. Do NOT change the method signature

		return true;
	}

	public void returnVehicle(VehicleID vehicleID ,CustomerRecord customerRecord, int mileage) {		
		//add your code here. Do NOT change the method signature


	}	


	public Collection<Vehicle> getVechilesByCustomer (CustomerRecord customerRecord){
		//add your code here. Do NOT change the method signature
		return null;
	}

}
