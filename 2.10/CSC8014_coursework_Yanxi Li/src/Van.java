public class Van implements Vehicle {

    private final VehicleID vanID;
    private final String vehicleType;
    private boolean hired;
    private final int distanceRequirement;
    private int currentMileage;


    private boolean inspectionRequired;

    public Van() {
        this.vanID = VehicleID.getInstance(VehicleID.VehicleType.VAN);
        this.vehicleType = "Van";
        this.hired = false;
        this.distanceRequirement = 5000;
        this.currentMileage = 0;
        this.inspectionRequired = false;
    }

    @Override
    public VehicleID getVehicleID() {
        return vanID;
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


    public boolean requiresInspection() {
        return inspectionRequired;
    }

    public void setInspectionRequired(boolean required) {
        this.inspectionRequired = required;
    }
}
