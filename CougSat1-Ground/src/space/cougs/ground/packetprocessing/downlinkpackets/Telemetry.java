package space.cougs.ground.packetprocessing.downlinkpackets;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import space.cougs.ground.satellites.CougSat;
import space.cougs.ground.utils.FileUtils;

public class Telemetry extends DownlinkPacket {

	public static final int ID = 0x08;

	public Telemetry() {
	}

	public boolean decodePacket(File file, CougSat satellite) throws IOException {

		FileInputStream inFile = new FileInputStream(file);

		FileUtils.readNextBytes(inFile, 2);// Recipient/header/command ID and length - First 2 Bytes

		// ADCS
		satellite.getAdcs().setLatitude(FileUtils.readGeographicCoordinate(inFile));
		satellite.getAdcs().setLongitude(FileUtils.readGeographicCoordinate(inFile));
		satellite.getAdcs().setRoll(FileUtils.readEulerAngle(inFile));
		satellite.getAdcs().setPitch(FileUtils.readEulerAngle(inFile));
		satellite.getAdcs().setYaw(FileUtils.readEulerAngle(inFile));
		satellite.getAdcs().setXPWMOut(FileUtils.readNextBytes(inFile, 2));
		satellite.getAdcs().setYPWMOut(FileUtils.readNextBytes(inFile, 2));
		satellite.getAdcs().setZPWMOut(FileUtils.readNextBytes(inFile, 2));
		satellite.getAdcs().setXCurrent(FileUtils.readCurrent(inFile));
		satellite.getAdcs().setYCurrent(FileUtils.readCurrent(inFile));
		satellite.getAdcs().setZCurrent(FileUtils.readCurrent(inFile));
		// C&DH
		satellite.getCdh().setMode(inFile.read());
		satellite.getCdh().setTime(FileUtils.readTime(inFile));
		satellite.getCdh().setSDCard(FileUtils.readNextBytes(inFile, 5));
		satellite.getCdh().setResetCount(inFile.read());
		satellite.getCdh().setErrorStatus(inFile.read());
		// Comms
		satellite.getComms().setRXPower(FileUtils.readPower(inFile));
		satellite.getComms().setTX230Power(FileUtils.readPower(inFile));
		satellite.getComms().setTX700Power(FileUtils.readPower(inFile));
		satellite.getComms().setRXSNR(FileUtils.readDecibel(inFile));
		satellite.getComms().setRXFrequency(FileUtils.readFrequency(inFile));
		satellite.getComms().setTX230Frequency(FileUtils.readFrequency(inFile));
		satellite.getComms().setTX700Frequency(FileUtils.readFrequency(inFile));
		satellite.getComms().setReg5VVoltage(FileUtils.readVoltage(inFile));
		satellite.getComms().setReg5VCurrent(FileUtils.readCurrent(inFile));
		satellite.getComms().setReg9VVoltage(FileUtils.readVoltage(inFile));
		satellite.getComms().setReg9VCurrent(FileUtils.readCurrent(inFile));
		for (int i = 0; i < 3; i++) {
			satellite.getComms().set_3v3Current(i, FileUtils.readCurrent(inFile));
		}
		for (int i = 0; i < 3; i++) {
			satellite.getComms().set_5vCurrent(i, FileUtils.readCurrent(inFile));
		}
		for (int i = 0; i < 2; i++) {
			satellite.getComms().set_9vCurrent(i, FileUtils.readCurrent(inFile));
		}
		satellite.getComms().setBadPacketCount((int) FileUtils.readNextBytes(inFile, 2));
		// ECS
		satellite.getEcs().setADCSTemp(FileUtils.readTemp(inFile));
		satellite.getEcs().setIHUTemp(FileUtils.readTemp(inFile));
		satellite.getEcs().setIFJRTemp(FileUtils.readTemp(inFile));
		satellite.getEcs().setCommsTemp(FileUtils.readTemp(inFile));
		satellite.getEcs().setRXTemp(FileUtils.readTemp(inFile));
		satellite.getEcs().setTx230Temp(FileUtils.readTemp(inFile));
		satellite.getEcs().setTx700Temp(FileUtils.readTemp(inFile));
		satellite.getEcs().setReg5VTemp(FileUtils.readTemp(inFile));
		satellite.getEcs().setReg9VTemp(FileUtils.readTemp(inFile));
		satellite.getEcs().setPMICTemp(FileUtils.readTemp(inFile));
		satellite.getEcs().setBatteryATemp(FileUtils.readTemp(inFile));
		satellite.getEcs().setBatteryBTemp(FileUtils.readTemp(inFile));
		satellite.getEcs().setReg3V3ATemp(FileUtils.readTemp(inFile));
		satellite.getEcs().setReg3V3BTemp(FileUtils.readTemp(inFile));
		for (int i = 0; i < 8; i++) {
			satellite.getEcs().setPVTemp(i, FileUtils.readTemp(inFile));
		}
		for (int i = 0; i < 8; i++) {
			satellite.getEcs().setMPPTTemp(i, FileUtils.readTemp(inFile));
		}
		// EPS
		for (int i = 0; i < 8; i++) {
			satellite.getEps().setPVVoltage(i, FileUtils.readVoltage(inFile));
		}
		for (int i = 0; i < 8; i++) {
			satellite.getEps().setPVCurrent(i, FileUtils.readCurrent(inFile));
		}
		for (int i = 0; i < 8; i++) {
			satellite.getEps().setMpptCurrent(i, FileUtils.readCurrent(inFile));
		}
		satellite.getEps().setBatteryAVoltage(FileUtils.readVoltage(inFile));
		satellite.getEps().setBatteryBVoltage(FileUtils.readVoltage(inFile));
		satellite.getEps().setBatteryACurrent(FileUtils.readCurrent(inFile));
		satellite.getEps().setBatteryBCurrent(FileUtils.readCurrent(inFile));
		satellite.getEps().setReg3v3VoltageA(FileUtils.readVoltage(inFile));
		satellite.getEps().setReg3v3VoltageB(FileUtils.readVoltage(inFile));
		satellite.getEps().setReg3v3CurrentA(FileUtils.readCurrent(inFile));
		satellite.getEps().setReg3v3CurrentB(FileUtils.readCurrent(inFile));
		for (int i = 0; i < 13; i++) {
			satellite.getEps().setPR3V3Current(i, FileUtils.readCurrent(inFile));
		}
		for (int i = 0; i < 7; i++) {
			satellite.getEps().setPRBattCurrent(i, FileUtils.readCurrent(inFile));
		}
		for (int i = 0; i < 4; i++) {
			satellite.getEps().setPV3V3Current(i, FileUtils.readCurrent(inFile));
		}
		satellite.getEps().setPRBHCurrentA(FileUtils.readCurrent(inFile));
		satellite.getEps().setPRBHCurrentB(FileUtils.readCurrent(inFile));
		satellite.getEps().setDeployablesCurrent(FileUtils.readCurrent(inFile));
		satellite.getEps().setMPPTSwitchingState(FileUtils.readNextBytes(inFile, 2));
		satellite.getEps().setOutputSwitchingState(FileUtils.readNextBytes(inFile, 5));
		satellite.getEps().setePSSwitchingState(FileUtils.readNextBytes(inFile, 2));

		int lastByte = inFile.read();
		inFile.close();

		return lastByte == -1;
	}
}
