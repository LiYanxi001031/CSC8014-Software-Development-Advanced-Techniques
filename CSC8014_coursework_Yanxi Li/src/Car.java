public final class Car implements Vehicle {
    public final VehicleID carID;
    public final String VehicleType;
    public final boolean isHired;
    public final int DistanceRequirement;
    public final int CurrentMileage;
    public final boolean performServiceIfDue;
    public Car(VehicleID carID, String VehicleType, String vehicleType, boolean isHired, int DistanceRequirement, boolean performServiceIfDue, int CurrentMileage){

        this.carID = carID;
        this.VehicleType = vehicleType;
        this.isHired = isHired;
        this.DistanceRequirement = DistanceRequirement;
        this.performServiceIfDue = performServiceIfDue;
        this.CurrentMileage = CurrentMileage;
    }

    @Override
    public VehicleID getVehicleID() {
        return carID;
    }

    @Override
    public String getVehicleType() {
        return VehicleType;
    }

    @Override
    public boolean isHired() {
        return false;
    }

    @Override
    public int getDistanceRequirement() {
        return 0;
    }

    @Override
    public int getCurrentMileage() {
        return 0;
    }

    @Override
    public void setCurrentMileage(int mileage) {

    }

    @Override
    public boolean performServiceIfDue() {
        return false;
    }
}
