public class Van implements Vehicle{

    public final VehicleID vanID;
    public final String vehicleType;
    public boolean isHired;
    public final int DistanceRequirement;
    public int CurrentMileage;
    public final boolean performServiceIfDue;

    public Van(VehicleID vanID, String vehicleType, boolean isHired, int distanceRequirement, int currentMileage, boolean performServiceIfDue) {
        this.vanID = vanID;
        this.vehicleType = vehicleType;
        this.isHired = isHired;
        DistanceRequirement = distanceRequirement;
        CurrentMileage = currentMileage;
        this.performServiceIfDue = performServiceIfDue;
    }

    @Override
    public VehicleID getVehicleID() {
        return vanID;
    }

    @Override
    public String getVehicleType() {
        return "Van";
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
        return 500;
    }

    @Override
    public int getCurrentMileage() {
        return CurrentMileage;
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
