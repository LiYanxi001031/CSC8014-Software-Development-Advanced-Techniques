
public class Car implements Vehicle {

    private final VehicleID carID;
    private final String vehicleType;
    private boolean hired;
    private final int distanceRequirement;
    private int currentMileage;

    public Car() {
        this.carID = VehicleID.getInstance(VehicleID.VehicleType.CAR);
        this.vehicleType = "Car";
        this.hired = false;
        this.distanceRequirement = 10000;
        this.currentMileage = 0;
    }

    @Override
    public VehicleID getVehicleID() {
        return carID;
    }

    @Override
    public String getVehicleType() {
        return vehicleType;
    }

    @Override
    public boolean isHired() {
        return hired;
    }

    @Override
    public boolean setHired(boolean hired) {
        this.hired = hired;
        return this.hired;
    }

    @Override
    public int getDistanceRequirement() {
        return distanceRequirement;
    }

    @Override
    public int getCurrentMileage() {
        return currentMileage;
    }

    @Override
    public void setCurrentMileage(int mileage) {
        if (mileage < 0) {
            throw new IllegalArgumentException("Mileage is negative");
        }
        this.currentMileage = mileage;
    }

    @Override
    public boolean performServiceIfDue() {
        if (currentMileage >= distanceRequirement) {
            currentMileage = 0;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return carID + " (Car) - Hired: " + hired +
                ", Mileage: " + currentMileage;
    }
}