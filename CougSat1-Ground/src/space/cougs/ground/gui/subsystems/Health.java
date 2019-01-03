package space.cougs.ground.gui.subsystems;

import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.SwingConstants;

import space.cougs.ground.gui.UIScaling;
import space.cougs.ground.gui.subsystems.modules.HorizontalText;
import space.cougs.ground.gui.subsystems.modules.Map;
import space.cougs.ground.gui.subsystems.modules.SingleVerticalBarGraph;
import space.cougs.ground.gui.subsystems.modules.CISModules.BodyLabel;
import space.cougs.ground.gui.subsystems.modules.CISModules.CISPanel;
import space.cougs.ground.gui.subsystems.modules.CISModules.TitleLabel;
import space.cougs.ground.gui.utils.CustomColors;
import space.cougs.ground.gui.utils.GridBagConstraintsWrapper;
import space.cougs.ground.satellites.CougSat;
import space.cougs.ground.utils.Units;

public class Health extends CISPanel implements UIScaling, SatelliteInfo {

	private static final long serialVersionUID = 1L;
	private final CISPanel ihu = new CISPanel();
	private final CISPanel temperature = new CISPanel();
	private final CISPanel adcs = new CISPanel();
	private final CISPanel comms = new CISPanel();
	private final CISPanel power = new CISPanel();

	private final HorizontalText mode = new HorizontalText("Mode:", 0.5);
	private final HorizontalText time = new HorizontalText("Time:", 0.5);
	private final HorizontalText SD = new HorizontalText("SD:", 0.5);
	private final HorizontalText reset = new HorizontalText("Reset:", 0.5);
	private final HorizontalText status = new HorizontalText("Status:", 0.5);

	private final SingleVerticalBarGraph rx = new SingleVerticalBarGraph("RX (mW)", 0, 100, 10, 0.6, false, 1.0, 0.2,
			1.0, 0.1);
	private final SingleVerticalBarGraph tx = new SingleVerticalBarGraph("TX (mW)", 0, 100, 10, 0.6, false, 0.8, 0.0,
			0.9, 0.0);
	private final SingleVerticalBarGraph snr = new SingleVerticalBarGraph("SNR(dB)", -30, 30, 10, 0.6, false, 1.0, 0.2,
			1.0, 0.1);

	private final SingleVerticalBarGraph ihuTemp = new SingleVerticalBarGraph("IHU ", -50, 80, 10, 0.5, false, 0.7, 0.3,
			0.9, 0.1);
	private final SingleVerticalBarGraph adcsTemp = new SingleVerticalBarGraph("ADCS", -50, 80, 10, 0.5, false, 0.7,
			0.3, 0.9, 0.1);
	private final SingleVerticalBarGraph ifjrTemp = new SingleVerticalBarGraph("IFJR", -50, 80, 10, 0.5, false, 0.7,
			0.3, 0.9, 0.1);
	private final SingleVerticalBarGraph pmicTemp = new SingleVerticalBarGraph("PMIC", -50, 80, 10, 0.5, false, 0.7,
			0.3, 0.9, 0.1);
	private final SingleVerticalBarGraph commsTemp = new SingleVerticalBarGraph("COMMS ", -50, 80, 10, 0.5, false, 0.7,
			0.3, 0.9, 0.1);
	private final SingleVerticalBarGraph batteryATemp = new SingleVerticalBarGraph("BatA", -50, 80, 10, 0.5, false, 0.8,
			0.4, 0.9, 0.3);
	private final SingleVerticalBarGraph batteryBTemp = new SingleVerticalBarGraph("BatB", -50, 80, 10, 0.5, false, 0.8,
			0.4, 0.9, 0.3);

	private final List<SingleVerticalBarGraph> pvTemps = new ArrayList<SingleVerticalBarGraph>();

	private final SingleVerticalBarGraph avgPVVoltageIn = new SingleVerticalBarGraph(" PV V ", 0, 3, 10, 0.5, false,
			0.7, 0.3, 0.9, 0.1);
	private final SingleVerticalBarGraph sumPVCurrent = new SingleVerticalBarGraph(" PV I ", 0, 2, 20, 0.5, false, 0.7,
			0.0, 0.9, 0.0);
	private final SingleVerticalBarGraph sumPR3V3Current = new SingleVerticalBarGraph("PR-3 I", 0, 8, 10, 0.5, false,
			0.7, 0.0, 0.9, 0.0);
	private final SingleVerticalBarGraph sumBatteryPR = new SingleVerticalBarGraph("PR-B I", 0, 8, 10, 0.5, false, 0.7,
			0.0, 0.9, 0.0);
	private final SingleVerticalBarGraph sumPV3V3Current = new SingleVerticalBarGraph("PV-3 I", 0, 2, 10, 0.5, false,
			0.7, 0.0, 0.9, 0.0);
	private final SingleVerticalBarGraph battHeaterA = new SingleVerticalBarGraph("BH-A I", 0, 5, 10, 0.5, false, 0.7,
			0.0, 0.9, 0.0);
	private final SingleVerticalBarGraph battHeaterB = new SingleVerticalBarGraph("BH-B I", 0, 5, 10, 0.5, false, 0.7,
			0.0, 0.9, 0.0);
	private final SingleVerticalBarGraph prDeployCurrent = new SingleVerticalBarGraph("PR-D I", 0, 3, 10, 0.5, false,
			0.7, 0.0, 0.9, 0.0);
	private final SingleVerticalBarGraph battACurrent = new SingleVerticalBarGraph("I", 0, 6, 10, 0.5, false, 0.7, 0.0,
			0.9, 0.0);
	private final SingleVerticalBarGraph battAVoltage = new SingleVerticalBarGraph("V", 0, 5, 10, 0.5, false, 0.7, 0.3,
			0.9, 0.1);
	private final SingleVerticalBarGraph battBCurrent = new SingleVerticalBarGraph("I", 0, 6, 10, 0.5, false, 0.7, 0.0,
			0.9, 0.0);
	private final SingleVerticalBarGraph battBVoltage = new SingleVerticalBarGraph("V", 0, 5, 10, 0.5, false, 0.7, 0.3,
			0.9, 0.1);
	private final SingleVerticalBarGraph regulator3V3AVoltage = new SingleVerticalBarGraph("V", 0, 4, 10, 0.5, false,
			0.7, 0.3, 0.9, 0.1);
	private final SingleVerticalBarGraph regulator3V3ACurrent = new SingleVerticalBarGraph("I", 0, 4, 10, 0.5, false,
			0.7, 0.0, 0.9, 0.0);
	private final SingleVerticalBarGraph regulator3V3BVoltage = new SingleVerticalBarGraph("V", 0, 4, 10, 0.5, false,
			0.7, 0.3, 0.9, 0.1);
	private final SingleVerticalBarGraph regulator3V3BCurrent = new SingleVerticalBarGraph("I", 0, 4, 10, 0.5, false,
			0.7, 0.0, 0.9, 0.0);

	private final Map map = new Map(46.7304889, -117.1750474, 1.25);

	public Health() {
		super();

		this.setBackground(CustomColors.BACKGROUND1);
		this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		this.setLayout(new GridBagLayout());

		GridBagConstraintsWrapper gbc = new GridBagConstraintsWrapper();
		gbc.setFill(GridBagConstraintsWrapper.BOTH);

		ihu.setLayout(new GridLayout(0, 1, 5, 5));

		ihu.add(new TitleLabel("Command", SwingConstants.CENTER));
		ihu.add(mode);
		ihu.add(time);
		ihu.add(SD);
		ihu.add(reset);
		ihu.add(status);

		comms.setLayout(new GridBagLayout());

		comms.add(new TitleLabel("Radio", SwingConstants.CENTER),
				gbc.setLocation(0, 0).setSize(3, 1).setWeight(0.0, 0.0).setInsets(5, 5, 5, 5));
		comms.add(rx, gbc.setLocation(0, 1).setSize(1, 1).setWeight(1.0, 1.0));
		comms.add(tx, gbc.setLocation(1, 1));
		comms.add(snr, gbc.setLocation(2, 1));

		temperature.setLayout(new GridBagLayout());

		temperature.add(new TitleLabel("Temperature (\u00B0C)", SwingConstants.CENTER),
				gbc.setLocation(0, 0).setSize(14, 1).setWeight(0.0, 0.0));
		temperature.add(ihuTemp, gbc.setLocation(1, 1).setSize(1, 1).setWeight(1.0, 1.0));
		temperature.add(adcsTemp, gbc.setLocation(2, 1));
		temperature.add(ifjrTemp, gbc.setLocation(3, 1));
		temperature.add(pmicTemp, gbc.setLocation(4, 1));
		temperature.add(commsTemp, gbc.setLocation(5, 1));
		temperature.add(batteryATemp, gbc.setLocation(6, 1));
		temperature.add(batteryBTemp, gbc.setLocation(7, 1));

		for (int i = 0; i < 8; i++) {

			pvTemps.add(new SingleVerticalBarGraph("PV " + i, -50, 80, 10, 0.5, false, 0.7, 0.3, 0.9, 0.1));
			temperature.add(pvTemps.get(i), gbc.setLocation(i + 1, 2));
		}

		power.setLayout(new GridBagLayout());

		power.add(new TitleLabel("Power", SwingConstants.CENTER),
				gbc.setLocation(0, 0).setSize(14, 1).setWeight(0.0, 0.0));
		power.add(avgPVVoltageIn, gbc.setLocation(1, 1).setSize(1, 1).setWeight(1.0, 1.0));
		power.add(sumPVCurrent, gbc.setLocation(2, 1));
		power.add(sumPR3V3Current, gbc.setLocation(3, 1));
		power.add(sumBatteryPR, gbc.setLocation(4, 1));
		power.add(sumPV3V3Current, gbc.setLocation(5, 1));
		power.add(battHeaterA, gbc.setLocation(6, 1));
		power.add(battHeaterB, gbc.setLocation(7, 1));
		power.add(prDeployCurrent, gbc.setLocation(8, 1));
		power.add(battAVoltage, gbc.setLocation(1, 2).setInsets(5, 5, 0, 5));
		power.add(battACurrent, gbc.setLocation(2, 2));
		power.add(battBVoltage, gbc.setLocation(3, 2));
		power.add(battBCurrent, gbc.setLocation(4, 2));
		power.add(regulator3V3AVoltage, gbc.setLocation(5, 2));
		power.add(regulator3V3ACurrent, gbc.setLocation(6, 2));
		power.add(regulator3V3BVoltage, gbc.setLocation(7, 2));
		power.add(regulator3V3BCurrent, gbc.setLocation(8, 2));
		power.add(prDeployCurrent, gbc.setLocation(8, 1).setInsets(5, 5, 5, 5));

		power.add(new BodyLabel(" Battery A ", SwingConstants.CENTER),
				gbc.setLocation(1, 4).setSize(2, 1).setWeight(0.0, 0.0).setInsets(0, 5, 5, 5));
		power.add(new BodyLabel(" Battery B ", SwingConstants.CENTER), gbc.setLocation(3, 4));
		power.add(new BodyLabel("Regulator A", SwingConstants.CENTER), gbc.setLocation(5, 4));
		power.add(new BodyLabel("Regulator B", SwingConstants.CENTER), gbc.setLocation(7, 4));

		avgPVVoltageIn.setToolTipText("Solar Panel Average Voltage In");
		sumPVCurrent.setToolTipText("Sum of Solar Panel Current");
		sumPR3V3Current.setToolTipText("Sum of 3.3V Power Rail Currents, Deployables, and Batteries");
		sumBatteryPR.setToolTipText("Sum of Unregulated Battery Power Rail Currents");
		sumPV3V3Current.setToolTipText("Sum of Solar Panel 3.3V Current");
		battHeaterA.setToolTipText("Battery Heater A Current");
		battHeaterB.setToolTipText("Battery Heater B Current");
		prDeployCurrent.setToolTipText("Deployables Current");
		battACurrent.setToolTipText("Battery A Current");
		battAVoltage.setToolTipText("Battery A Voltage");
		battBCurrent.setToolTipText("Battery B Current");
		battBVoltage.setToolTipText("Battery B Voltage");
		regulator3V3AVoltage.setToolTipText("3.3V Regulator A Voltage");
		regulator3V3ACurrent.setToolTipText("3.3V Regulator A Current");
		regulator3V3BVoltage.setToolTipText("3.3V Regulator B Voltage");
		regulator3V3BCurrent.setToolTipText("3.3V Regulator B Current");

		adcs.setLayout(new GridBagLayout());

		adcs.add(new TitleLabel("Attitude", SwingConstants.CENTER),
				gbc.setLocation(0, 0).setSize(1, 1).setWeight(0.0, 0.0).setInsets(5, 5, 5, 5));
		adcs.add(map, gbc.setLocation(0, 1).setWeight(1.0, 1.0));

		this.add(ihu, gbc.setLocation(0, 0).setWeight(0.0, 0.0).setInsets(0, 0, 5, 5));
		this.add(adcs, gbc.setLocation(0, 1).setSize(2, 2).setWeight(0.0, 1.0).setInsets(5, 0, 0, 5));
		this.add(temperature, gbc.setLocation(2, 2).setSize(1, 2).setWeight(1.0, 1.0).setInsets(5, 5, 0, 0));
		this.add(comms, gbc.setLocation(1, 0).setSize(1, 1).setWeight(0.0, 0.0).setInsets(0, 5, 5, 5));
		this.add(power, gbc.setLocation(2, 0).setSize(1, 2).setWeight(1.0, 1.0).setInsets(0, 5, 5, 0));
	}

	@Override
	public void updateUIScaling(UIScale uiScale) {
		for (Component child : this.getComponents()) {
			if (child instanceof UIScaling)
				((UIScaling) child).updateUIScaling(uiScale);
		}
	}

	@Override
	public void updateSatellite(CougSat satellite) {

		mode.setValue(satellite.getCdh().getMode());

		time.setValue(Units.timeToString(satellite.getCdh().getTime()));
		SD.setValue(Units.bytePrefix(satellite.getCdh().getSDCard()));
		reset.setValue(String.valueOf(satellite.getCdh().getResetCount()));
		status.setValue(satellite.getCdh().getErrorStatus().toString());

		rx.setValue(satellite.getComms().getRXPower() * 1000, CustomColors.BAR_DEFAULT);
		tx.setValue(satellite.getComms().getTX230Power() * 1000, CustomColors.BAR_DEFAULT);
		snr.setValue(satellite.getComms().getRXSNR(), CustomColors.BAR_DEFAULT);

		ihuTemp.setValue(satellite.getEcs().getIHUTemp());
		adcsTemp.setValue(satellite.getEcs().getADCSTemp());
		ifjrTemp.setValue(satellite.getEcs().getIFJRTemp());
		pmicTemp.setValue(satellite.getEcs().getPMICTemp());
		commsTemp.setValue(satellite.getEcs().getCommsTemp());
		batteryATemp.setValue(satellite.getEcs().getBatteryATemp());
		batteryBTemp.setValue(satellite.getEcs().getBatteryBTemp());

		for (int i = 0; i < 8; i++) {
			pvTemps.get(i).setValue(satellite.getEcs().getPVTemp(i));
		}

		avgPVVoltageIn.setValue(satellite.getEps().getPVVoltageIn());
		sumPVCurrent.setValue(satellite.getEps().getPVCurrent());
		sumPR3V3Current.setValue(satellite.getEps().getPR3V3Current());
		sumBatteryPR.setValue(satellite.getEps().getBatteryPR());
		sumPV3V3Current.setValue(satellite.getEps().getPV3V3Current());

		battHeaterA.setValue(satellite.getEps().getPRBHCurrentA());
		battHeaterB.setValue(satellite.getEps().getPRBHCurrentB());
		prDeployCurrent.setValue(satellite.getEps().getDeployablesCurrent());
		battACurrent.setValue(satellite.getEps().getBatteryACurrent());
		battAVoltage.setValue(satellite.getEps().getBatteryAVoltage());
		battBCurrent.setValue(satellite.getEps().getBatteryBCurrent());
		battBVoltage.setValue(satellite.getEps().getBatteryBVoltage());
		regulator3V3AVoltage.setValue(satellite.getEps().getReg3v3VoltageA());
		regulator3V3ACurrent.setValue(satellite.getEps().getReg3v3CurrentA());
		regulator3V3BVoltage.setValue(satellite.getEps().getReg3v3VoltageB());
		regulator3V3BCurrent.setValue(satellite.getEps().getReg3v3CurrentB());

		map.setValue(satellite.getAdcs().getLatitude(), satellite.getAdcs().getLongitude());
	}
}
