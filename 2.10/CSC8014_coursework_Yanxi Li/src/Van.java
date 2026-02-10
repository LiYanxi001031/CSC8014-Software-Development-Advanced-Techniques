public class Van implements Vehicle{

    public final VehicleID vanID;
    public final String vehicleType;
    public boolean isHired;
    public final int DistanceRequirement;
    public int CurrentMileage;
    public final boolean performServiceIfDue;

    public Van(VehicleID vanID) {
        this.vanID = vanID;
        this.vehicleType = "Van";
        this.isHired = false;
        DistanceRequirement = 5000;
        CurrentMileage = 0;
        this.performServiceIfDue = false;
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
        return 5000;
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
         if (CurrentMileage >= 5000) {
            return true;
        } else {
            return false;
        }
    }
 }

