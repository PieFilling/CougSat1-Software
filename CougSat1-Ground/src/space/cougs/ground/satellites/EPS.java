package space.cougs.ground.satellites;

import java.util.Arrays;

public class EPS {

    private double pvVoltage[] = new double[8];
    private double pvCurrent[] = new double[8];
    private double mpptCurrent[] = new double[8];
    private double batteryAVoltage = 0.0;
    private double batteryBVoltage = 0.0;
    private double batteryACurrent = 0.0;
    private double batteryBCurrent = 0.0;
    private double reg3v3VoltageA = 0.0;
    private double reg3v3VoltageB = 0.0;
    private double reg3v3CurrentA = 0.0;
    private double reg3v3CurrentB = 0.0;
    private double pr3V3Current[] = new double[13];
    private double prBattCurrent[] = new double[7];
    private double pv3V3Current[] = new double[4];
    private double prBHCurrentA = 0.0;
    private double prBHCurrentB = 0.0;
    private double deployablesCurrent = 0.0;
    private boolean mPPTSwitchingState[] = new boolean[16];
    private boolean outputSwitchingState[] = new boolean[54];
    private boolean ePSSwitchingState[] = new boolean[16];

    public EPS() {

    }

    public double getPVVoltage(int i) {
        return pvVoltage[i];
    }

    public double getPVVoltageIn() {

        return Arrays.stream(pvVoltage).average().getAsDouble();
    }

    public void setPVVoltage(int i, double pvVoltage) {
        this.pvVoltage[i] = pvVoltage;
    }

    public double getPVCurrent(int i) {
        return pvCurrent[i];
    }

    public double getPVCurrent() {

        return Arrays.stream(pvCurrent).sum();
    }

    public void setPVCurrent(int i, double pvCurrent) {
        this.pvCurrent[i] = pvCurrent;
    }

    public double getBatteryAVoltage() {
        return batteryAVoltage;
    }

    public void setBatteryAVoltage(double batteryAVoltage) {
        this.batteryAVoltage = batteryAVoltage;
    }

    public double getBatteryACurrent() {
        return batteryACurrent;
    }

    public void setBatteryACurrent(double batteryACurrent) {
        this.batteryACurrent = batteryACurrent;
    }

    public double getBatteryBVoltage() {
        return batteryBVoltage;
    }

    public void setBatteryBVoltage(double batteryBVoltage) {
        this.batteryBVoltage = batteryBVoltage;
    }

    public double getBatteryBCurrent() {
        return batteryBCurrent;
    }

    public void setBatteryBCurrent(double batteryBCurrent) {
        this.batteryBCurrent = batteryBCurrent;
    }

    public double getPR3V3Current(int i) {
        return pr3V3Current[i];
    }

    public double getPR3V3Current() {
        return Arrays.stream(pr3V3Current).sum();
    }

    public void setPR3V3Current(int i, double pr3v3Current) {
        pr3V3Current[i] = pr3v3Current;
    }

    public double getPRBattCurrent(int i) {
        return prBattCurrent[i];
    }

    public double getBatteryPR() {

        return Arrays.stream(prBattCurrent).sum();
    }

    public void setPRBattCurrent(int i, double prBattCurrent) {
        this.prBattCurrent[i] = prBattCurrent;
    }

    public double getPV3V3Current(int i) {
        return pv3V3Current[i];
    }

    public double getPV3V3Current() {

        return Arrays.stream(pv3V3Current).sum();
    }

    public void setPV3V3Current(int i, double pv3v3Current) {
        pv3V3Current[i] = pv3v3Current;
    }

    public double getPRBHCurrentA() {
        return prBHCurrentA;
    }

    public void setPRBHCurrentA(double prBHCurrentA) {
        this.prBHCurrentA = prBHCurrentA;
    }

    public double getPRBHCurrentB() {
        return prBHCurrentB;
    }

    public void setPRBHCurrentB(double prBHCurrentB) {
        this.prBHCurrentB = prBHCurrentB;
    }

    public double getDeployablesCurrent() {
        return deployablesCurrent;
    }

    public void setDeployablesCurrent(double deployablesCurrent) {
        this.deployablesCurrent = deployablesCurrent;
    }

    public boolean getMPPTSwitchingState(int i) {
        return mPPTSwitchingState[i];
    }

    public void setMPPTSwitchingState(long mPPTSwitchingState) {
        for (int i = 0; i < this.mPPTSwitchingState.length; i++) {
            this.mPPTSwitchingState[i] = ((mPPTSwitchingState >> i) & 0x1) == 0x1;
        }
    }

    public boolean getePSSwitchingState(int i) {
        return ePSSwitchingState[i];
    }

    public void setePSSwitchingState(long ePSSwitchingState) {
        for (int i = 0; i < this.ePSSwitchingState.length; i++) {
            this.ePSSwitchingState[i] = ((ePSSwitchingState >> i) & 0x1) == 0x1;
        }
    }

    public boolean getOutputSwitchingState(int i) {
        return outputSwitchingState[i];
    }

    public void setOutputSwitchingState(long outputSwitchingState) {

        for (int i = 0; i < this.outputSwitchingState.length; i++) {
            this.outputSwitchingState[i] = ((outputSwitchingState >> i) & 0x1) == 0x1;
        }
    }

    public double getMpptCurrent(int i) {
        return mpptCurrent[i];
    }

    public void setMpptCurrent(int i, double mpptCurrent) {
        this.mpptCurrent[i] = mpptCurrent;
    }

    public double getReg3v3CurrentB() {
        return reg3v3CurrentB;
    }

    public void setReg3v3CurrentB(double reg3v3CurrentB) {
        this.reg3v3CurrentB = reg3v3CurrentB;
    }

    public double getReg3v3VoltageB() {
        return reg3v3VoltageB;
    }

    public void setReg3v3VoltageB(double reg3v3VoltageB) {
        this.reg3v3VoltageB = reg3v3VoltageB;
    }

    public double getReg3v3CurrentA() {
        return reg3v3CurrentA;
    }

    public void setReg3v3CurrentA(double reg3v3CurrentA) {
        this.reg3v3CurrentA = reg3v3CurrentA;
    }

    public double getReg3v3VoltageA() {
        return reg3v3VoltageA;
    }

    public void setReg3v3VoltageA(double reg3v3VoltageA) {
        this.reg3v3VoltageA = reg3v3VoltageA;
    }

};