package space.cougs.ground.satellites;

public class ECS {
    
    private int adcsTemp = 0;
    private int ihuTemp = 0;
    private int ifjrTemp = 0;
    private int commsTemp = 0;
    private int rxTemp = 0;
    private int tx230Temp = 0;
    private int tx700Temp = 0;
    private int reg5VTemp = 0;
    private int reg9VTemp = 0;
    private int pmicTemp = 0;
    private int batteryATemp = 0;
    private int batteryBTemp = 0;
    private int reg3V3ATemp = 0;
    private int reg3V3BTemp = 0;
    private int pvTemp[] = new int[8];
    private int mpptTemp[] = new int[8];

    public ECS() {

    }

    public int getIHUTemp() {
        return ihuTemp;
    }

    public void setIHUTemp(int ihuTemp) {
        this.ihuTemp = ihuTemp;
    }

    public int getADCSTemp() {
        return adcsTemp;
    }

    public void setADCSTemp(int adcsTemp) {
        this.adcsTemp = adcsTemp;
    }

    public int getIFJRTemp() {
        return ifjrTemp;
    }

    public void setIFJRTemp(int ifjrTemp) {
        this.ifjrTemp = ifjrTemp;
    }

    public int getPMICTemp() {
        return pmicTemp;
    }

    public void setPMICTemp(int pmicTemp) {
        this.pmicTemp = pmicTemp;
    }

    public int getBatteryATemp() {
        return batteryATemp;
    }

    public void setBatteryATemp(int batteryATemp) {
        this.batteryATemp = batteryATemp;
    }

    public int getBatteryBTemp() {
        return batteryBTemp;
    }

    public void setBatteryBTemp(int batteryBTemp) {
        this.batteryBTemp = batteryBTemp;
    }

    public int getReg3V3ATemp() {
        return reg3V3ATemp;
    }

    public void setReg3V3ATemp(int reg3V3ATemp) {
        this.reg3V3ATemp = reg3V3ATemp;
    }

    public int getReg3V3BTemp() {
        return reg3V3BTemp;
    }

    public void setReg3V3BTemp(int reg3V3BTemp) {
        this.reg3V3BTemp = reg3V3BTemp;
    }

    public int getPVTemp(int i) {
        return pvTemp[i];
    }

    public void setPVTemp(int i, int pvTemp) {
        this.pvTemp[i] = pvTemp;
    }

    public int getMPPTTemp(int i) {
        return mpptTemp[i];
    }

    public void setMPPTTemp(int i, int mpptTemp) {
        this.mpptTemp[i] = mpptTemp;
    }

    public int getCommsTemp() {
        return commsTemp;
    }

    public void setCommsTemp(int commsTemp) {
        this.commsTemp = commsTemp;
    }

    public int getRXTemp() {
        return rxTemp;
    }

    public void setRXTemp(int rxTemp) {
        this.rxTemp = rxTemp;
    }

    public int getTx700Temp() {
        return tx700Temp;
    }

    public void setTx700Temp(int tx700Temp) {
        this.tx700Temp = tx700Temp;
    }

    public int getTx230Temp() {
        return tx230Temp;
    }

    public void setTx230Temp(int tx230Temp) {
        this.tx230Temp = tx230Temp;
    }

    public int getReg9VTemp() {
        return reg9VTemp;
    }

    public void setReg9VTemp(int reg9vTemp) {
        this.reg9VTemp = reg9vTemp;
    }

    public int getReg5VTemp() {
        return reg5VTemp;
    }

    public void setReg5VTemp(int reg5vTemp) {
        this.reg5VTemp = reg5vTemp;
    }

};