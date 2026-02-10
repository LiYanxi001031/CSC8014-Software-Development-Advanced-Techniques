public class Car implements Vehicle {

    public VehicleID carID;
    public final String vehicleType;
    public boolean isHired;
    public final int DistanceRequirement;
    public int CurrentMileage;
    public final boolean performServiceIfDue;

    public Car(VehicleID carID) {
        this.carID = carID;
        this.vehicleType = "Car";
        this.isHired = false;
        this.DistanceRequirement = 10000;
        this.performServiceIfDue = false;
        this.CurrentMileage = 0;
    }


    @Override
    public VehicleID getVehicleID() {
        return carID;
    }

    @Override
    public String getVehicleType() {
        return "Car";
    }

    @Override
    public boolean isHired() {
        return false;
    }

    @Override
    public boolean setHired(boolean hired) {
        return this.isHired = hired;
    }

    @Override
    public int getDistanceRequirement() {
        return 10000;
    }

    @Override
    public int getCurrentMileage() {
        return 0;
    }

    @Override
    public void setCurrentMileage(int mileage) {
        if (mileage >= 0) {
            this.CurrentMileage = mileage;
        } else {
            System.out.println("Current mileage must more than 0");
        }
    }

    @Override
    public boolean performServiceIfDue() {
        if (CurrentMileage >= 10000) {
            return true;
        } else {
            return false;
        }
    }
}
