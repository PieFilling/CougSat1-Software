package space.cougs.ground.satellites;

import space.cougs.ground.utils.CISErrors;

public class CDH {

    enum ModeEnum {
        BEACON, CHARGING, DATA_TRANSMISION, SCIENCE, ECLIPSE, SAFE, NO_CONNECTION;
    }

    private ModeEnum opMode = ModeEnum.NO_CONNECTION;
    private long time = 0;
    private long sdCard = 0;
    private int resetCount = 0;
    private CISErrors errorStatus = CISErrors.SUCCESS;

    public CDH() {

    }

    public String getMode() {

        return opMode.name();
    }

    public void setMode(int buff) {

        switch (buff) {
        case 0x31:
            opMode = ModeEnum.BEACON;
            break;
        case 0x32:
            opMode = ModeEnum.CHARGING;
            break;
        case 0x33:
            opMode = ModeEnum.DATA_TRANSMISION;
            break;
        case 0x34:
            opMode = ModeEnum.SCIENCE;
            break;
        case 0x35:
            opMode = ModeEnum.ECLIPSE;
            break;
        case 0x40:
            opMode = ModeEnum.SAFE;
            break;
        }

    }

    public long getTime() {

        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public long getSDCard() {
        return sdCard;
    }

    public void setSDCard(long sdCard) {
        this.sdCard = sdCard;
    }

    public int getResetCount() {
        return resetCount;
    }

    public void setResetCount(int resetCount) {
        this.resetCount = resetCount;
    }

    public CISErrors getErrorStatus() {
        return errorStatus;
    }

    public void setErrorStatus(int i) {
        this.errorStatus = CISErrors.values()[i];
    }
};