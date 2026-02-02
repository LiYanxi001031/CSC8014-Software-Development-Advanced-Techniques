public  class Car implements Vehicle {

    public VehicleID carID;
    public final String vehicleType;
    public boolean isHired;
    public final int DistanceRequirement;
    public int CurrentMileage;
    public final boolean performServiceIfDue;

    public Car(VehicleID carID, String VehicleType, String vehicleType, boolean isHired, int DistanceRequirement, boolean performServiceIfDue, int CurrentMileage){
        this.carID = carID;
        this.vehicleType = vehicleType;
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
        return "Car";
    }

    @Override
    public boolean isHired() {
        return false;
    }

    @Override
    public boolean setHired(boolean hired) {
        return this.isHired = hired ;
    }

    @Override
    public int getDistanceRequirement() {
        return 1000;
    }

    @Override
    public int getCurrentMileage() {
        return 0;
    }

    @Override
    public void setCurrentMileage(int mileage) {
        if (mileage >= 0){
            this.CurrentMileage = mileage;
        }else{
            System.out.println("Current mileage must more than 0");
        }
    }

    @Override
    public boolean performServiceIfDue() {
        return false;
    }
}
