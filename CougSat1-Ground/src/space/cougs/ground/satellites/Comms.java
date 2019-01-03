package space.cougs.ground.satellites;

public class Comms {

    private double rxPower = 0.0;
    private double tx230Power = 0.0;
    private double tx700Power = 0.0;
    private double rxSNR = 0.0;
    private int rxFrequency = 0;
    private int tx230Frequency = 0;
    private int tx700Frequency = 0;
    private double reg5VVoltage = 0.0;
    private double reg5VCurrent = 0.0;
    private double reg9VVoltage = 0.0;
    private double reg9VCurrent = 0.0;
    private double _3v3Current[] = new double[3];
    private double _5vCurrent[] = new double[3];
    private double _9vCurrent[] = new double[2];
    private int badPacketCount = 0;

    public Comms() {

    }

    public double getRXPower() {
        return rxPower;
    }

    public void setRXPower(double rxPower) {
        this.rxPower = rxPower;
    }

    public double getRXSNR() {
        return rxSNR;
    }

    public void setRXSNR(double rxSNR) {
        this.rxSNR = rxSNR;
    }

    public int getBadPacketCount() {
        return badPacketCount;
    }

    public void setBadPacketCount(int badPacketCount) {
        this.badPacketCount = badPacketCount;
    }

    public int getRXFrequency() {
        return rxFrequency;
    }

    public void setRXFrequency(int rxFrequency) {
        this.rxFrequency = rxFrequency;
    }

    public int getTX230Frequency() {
        return tx230Frequency;
    }

    public void setTX230Frequency(int tx230Frequency) {
        this.tx230Frequency = tx230Frequency;
    }

    public int getTX700Frequency() {
        return tx700Frequency;
    }

    public void setTX700Frequency(int tx700Frequency) {
        this.tx700Frequency = tx700Frequency;
    }

    public double getTX230Power() {
        return tx230Power;
    }

    public void setTX230Power(double tx230Power) {
        this.tx230Power = tx230Power;
    }

    public double getTX700Power() {
        return tx700Power;
    }

    public void setTX700Power(double tx700Power) {
        this.tx700Power = tx700Power;
    }

    public double getReg5VVoltage() {
        return reg5VVoltage;
    }

    public void setReg5VVoltage(double reg5vVoltage) {
        this.reg5VVoltage = reg5vVoltage;
    }

    public double getReg5VCurrent() {
        return reg5VCurrent;
    }

    public void setReg5VCurrent(double reg5vCurrent) {
        this.reg5VCurrent = reg5vCurrent;
    }

    public double getReg9VVoltage() {
        return reg9VVoltage;
    }

    public void setReg9VVoltage(double reg9vbVoltage) {
        this.reg9VVoltage = reg9vbVoltage;
    }

    public double getReg9VCurrent() {
        return reg9VCurrent;
    }

    public void setReg9VCurrent(double reg9vCurrent) {
        this.reg9VCurrent = reg9vCurrent;
    }

    public double get_9vCurrent(int i) {
        return _9vCurrent[i];
    }

    public void set_9vCurrent(int i, double _9vCurrent) {
        this._9vCurrent[i] = _9vCurrent;
    }

    public double get_5vCurrent(int i) {
        return _5vCurrent[i];
    }

    public void set_5vCurrent(int i, double _5vCurrent) {
        this._5vCurrent[i] = _5vCurrent;
    }

    public double get_3v3Current(int i) {
        return _3v3Current[i];
    }

    public void set_3v3Current(int i, double _3v3Current) {
        this._3v3Current[i] = _3v3Current;
    }

};
