package space.cougs.ground.satellites;

public class ADCS {

    private double latitude = 0.0;
    private double longitude = 0.0;
    private double roll = 0.0;
    private double pitch = 0.0;
    private double yaw = 0.0;
    private long xPWMOut = 0;
    private long yPWMOut = 0;
    private long zPWMOut = 0;
    private double xCurrent = 0;
    private double yCurrent = 0;
    private double zCurrent = 0;

    public ADCS() {

    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getRoll() {
        return roll;
    }

    public void setRoll(double roll) {
        this.roll = roll;
    }

    public double getPitch() {
        return pitch;
    }

    public void setPitch(double pitch) {
        this.pitch = pitch;
    }

    public double getYaw() {
        return yaw;
    }

    public void setYaw(double yaw) {
        this.yaw = yaw;
    }

    public long getXPWMOut() {
        return xPWMOut;
    }

    public void setXPWMOut(long xPWMOut) {
        this.xPWMOut = xPWMOut;
    }

    public long getYPWMOut() {
        return yPWMOut;
    }

    public void setYPWMOut(long yPWMOut) {
        this.yPWMOut = yPWMOut;
    }

    public long getZPWMOut() {
        return zPWMOut;
    }

    public void setZPWMOut(long zPWMOut) {
        this.zPWMOut = zPWMOut;
    }

    public double getXCurrent() {
        return xCurrent;
    }

    public void setXCurrent(double xCurrent) {
        this.xCurrent = xCurrent;
    }

    public double getYCurrent() {
        return yCurrent;
    }

    public void setYCurrent(double yCurrent) {
        this.yCurrent = yCurrent;
    }

    public double getZCurrent() {
        return zCurrent;
    }

    public void setZCurrent(double zCurrent) {
        this.zCurrent = zCurrent;
    }

};