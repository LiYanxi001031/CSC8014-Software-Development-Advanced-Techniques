import java.util.*;

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



	private final ArrayList<Vehicle> allVehicles = new ArrayList<Vehicle>();
	private final Map<Integer, CustomerRecord> customers = new HashMap<>();
	private final Map<Integer, Set<Vehicle>> hiredVehicles = new HashMap<>();

	//you can add attributes and additional methods if needed.
	//you can throw an exception if needed
	
	public Vehicle addVehicle(String vehicleType){
		//add your code here. Do NOT change the method signature
		if ("Car".equalsIgnoreCase(vehicleType)) {

			Vehicle car = new Car();
			allVehicles.add(car);
			return car;

		} else if ("Van".equalsIgnoreCase(vehicleType)) {

			Vehicle van = new Van();
			allVehicles.add(van);
			return van;

		} else {
			throw new IllegalArgumentException(
					"Invalid Vehicle Type: " + vehicleType);
		}
	}

	public int noOfAvailableVehicles(String vehicleType) {
		//add your code here. Do NOT change the method signature
		int count = 0;
		for (Vehicle v : allVehicles) {
			if (v.getVehicleType().equalsIgnoreCase(vehicleType) && !v.isHired()) {
				count++;
			}
		}
		return count;
	}

	public CustomerRecord addCustomerRecord(String firstName, String lastName, Date dob, Boolean hasCommercialLicense) {
		//add your code here. Do NOT change the method signature
		for (CustomerRecord c : customers.values()) {
			if (c.getName().getFirstName().equals(firstName)
					&& c.getName().getLastName().equals(lastName)
					&& c.getDob().equals(dob)) {
				throw new IllegalArgumentException("Customer already exists");
			}
		}

		CustomerRecord record = new CustomerRecord(new Name(firstName, lastName), dob, hasCommercialLicense);

		customers.put(record.getCustomerNumber(), record);
		return record;
	}


	public boolean hireVehicle(CustomerRecord customerRecord, String vehicleType, int duration) {
		//add your code here. Do NOT change the method signature
		if (!customers.containsKey(customerRecord.getCustomerNumber()))
			return false;

		Set<Vehicle> customerVehicles =
				hiredVehicles.getOrDefault(customerRecord.getCustomerNumber(), new HashSet<>());

		if (customerVehicles.size() >= 3)
			return false;

		for (Vehicle v : allVehicles) {

			if (v.getVehicleType().equalsIgnoreCase(vehicleType)
					&& !v.isHired()
					&& v.getCurrentMileage() <= v.getDistanceRequirement()) {

				if (vehicleType.equalsIgnoreCase("Van")) {

					if (!customerRecord.hasCommercialLicense())
						return false;

					if ( v.performServiceIfDue())
						return false;

					if (duration >= 10)
						v.performServiceIfDue();
				}

				(v).setHired(true);
				customerVehicles.add(v);
				hiredVehicles.put(customerRecord.getCustomerNumber(), customerVehicles);
				return true;
			}
		}
		return false;
	}

	public void returnVehicle(VehicleID vehicleID ,CustomerRecord customerRecord, int mileage) {
		//add your code here. Do NOT change the method signature
		if (vehicleID == null || customerRecord == null) return;
		if (mileage < 0) throw new IllegalArgumentException("Mileage cannot be negative");

		Set<Vehicle> vehicles = hiredVehicles.get(customerRecord.getCustomerNumber());
		if (vehicles == null || vehicles.isEmpty()) return;

		Iterator<Vehicle> it = vehicles.iterator();
		while (it.hasNext()) {
			Vehicle v = it.next();
			if (vehicleID.equals(v.getVehicleID())) {

				it.remove();
				v.setHired(false);
				v.setCurrentMileage(v.getCurrentMileage() + mileage);
				v.performServiceIfDue();

				if (v instanceof Van) {
					Van van = (Van) v;
					if (van.requiresInspection()) {
						van.setInspectionRequired(false);
					}
				}

				if (vehicles.isEmpty()) {
					hiredVehicles.remove(customerRecord.getCustomerNumber());
				}

				System.out.println("Return success: Customer " + customerRecord.getCustomerNumber()
						+ " returned " + v.getVehicleType() + " " + v.getVehicleID());
				return;
			}
		}


	}


	public Collection<Vehicle> getVechilesByCustomer (CustomerRecord customerRecord){
		//add your code here. Do NOT change the method signature
		if (customerRecord == null) return Collections.unmodifiableCollection(Collections.emptySet());
		Set<Vehicle> set = hiredVehicles.get(customerRecord.getCustomerNumber());
		if (set == null) set = Collections.emptySet();
		return Collections.unmodifiableCollection(set);
	}

	private int calculateAge(Date dob) {
		Calendar birth = Calendar.getInstance();
		birth.setTime(dob);

		Calendar now = Calendar.getInstance();

		int age = now.get(Calendar.YEAR) - birth.get(Calendar.YEAR);
		int nowDay = now.get(Calendar.DAY_OF_YEAR);
		int birthDay = birth.get(Calendar.DAY_OF_YEAR);

		if (nowDay < birthDay) age--;
		return age;
	}

}
