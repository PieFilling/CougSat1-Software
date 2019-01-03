package space.cougs.ground.gui.subsystems;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.SwingConstants;

import space.cougs.ground.gui.UIScaling;
import space.cougs.ground.gui.subsystems.modules.HorizontalText;
import space.cougs.ground.gui.subsystems.modules.Map;
import space.cougs.ground.gui.subsystems.modules.CISModules.BodyLabel;
import space.cougs.ground.gui.subsystems.modules.CISModules.CISButton;
import space.cougs.ground.gui.subsystems.modules.CISModules.CISPanel;
import space.cougs.ground.gui.subsystems.modules.CISModules.CISTextField;
import space.cougs.ground.gui.utils.CustomColors;
import space.cougs.ground.gui.utils.GridBagConstraintsWrapper;
import space.cougs.ground.satellites.CougSat;
import space.cougs.ground.utils.Units;

public class ADCS extends CISPanel implements UIScaling, SatelliteInfo {

	private static final long serialVersionUID = 1L;

	private final CISPanel coordinatePanel = new CISPanel(new BorderLayout());
	private final Map map = new Map(46.7304889, -117.1750474, 2.00);
	private final CISPanel panelWrapper = new CISPanel(new CardLayout());
	private final CardSwitcher cardSwitcherButtons = new CardSwitcher();
	private final CISPanel telemetryPanel = new CISPanel(new GridBagLayout());
	private final CISPanel attitudeIndicator = new CISPanel();

	private final CISPanel earthPanel = new CISPanel(new GridBagLayout());
	private final CISPanel attitudePanel = new CISPanel(new GridBagLayout());
	private final CISPanel celestialPanel = new CISPanel(new GridBagLayout());

	private final CISTextField lattCoordinates = new CISTextField();
	private final CISTextField longCoordinates = new CISTextField();
	private final CISTextField rightAscensionCoordinates = new CISTextField();
	private final CISTextField leftAscensionCoordinates = new CISTextField();
	private final CISTextField rollCoordinates = new CISTextField();
	private final CISTextField yawCoordinates = new CISTextField();
	private final CISTextField pitchCoordinates = new CISTextField();

	private final HorizontalText adcsTemp = new HorizontalText("Temp:", 0.5);
	private final HorizontalText roll = new HorizontalText("Roll:", 0.5);
	private final HorizontalText pitch = new HorizontalText("Pitch:", 0.5);
	private final HorizontalText yaw = new HorizontalText("Yaw:", 0.5);
	private final HorizontalText xPWMOut = new HorizontalText("X PWM Out:", 0.5);
	private final HorizontalText yPWMOut = new HorizontalText("Y PWM Out:", 0.5);
	private final HorizontalText zPWMOut = new HorizontalText("Z PWM Out:", 0.5);
	private final HorizontalText xCurrent = new HorizontalText("X Current:", 0.5);
	private final HorizontalText yCurrent = new HorizontalText("Y Current:", 0.5);
	private final HorizontalText zCurrent = new HorizontalText("Z Current:", 0.5);

	public ADCS() {

		super();
		this.setBorder(BorderFactory.createLineBorder(CustomColors.BACKGROUND1, 10));

		GridBagConstraintsWrapper gbc = new GridBagConstraintsWrapper();
		gbc.setFill(GridBagConstraintsWrapper.BOTH);
		this.setLayout(new GridBagLayout());
		this.setBackground(CustomColors.BACKGROUND1);

		// Panel in panel switcher showing latt/long
		earthPanel.add(new BodyLabel("Latitude"),
				gbc.setLocation(0, 0).setSize(1, 1).setWeight(0.0, 0.0).setInsets(5, 5, 5, 5));
		earthPanel.add(lattCoordinates, gbc.setLocation(1, 0).setWeight(1.0, 0.0));
		earthPanel.add(new BodyLabel("\u00B0"), gbc.setLocation(2, 0).setWeight(0.0, 0.0));
		earthPanel.add(new BodyLabel("Longitude"), gbc.setLocation(0, 1));
		earthPanel.add(longCoordinates, gbc.setLocation(1, 1));
		earthPanel.add(new BodyLabel("\u00B0"), gbc.setLocation(2, 1));
		earthPanel.add(new CISButton("Transmit"), gbc.setLocation(1, 2));
		panelWrapper.add(earthPanel, "Earth");

		// Panel in switcher showing degree of Ascension
		celestialPanel.add(new BodyLabel("Right Ascension"), gbc.setLocation(0, 0));
		celestialPanel.add(rightAscensionCoordinates, gbc.setLocation(1, 0).setWeight(1.0, 0.0));
		celestialPanel.add(new BodyLabel("\u00B0"), gbc.setLocation(2, 0).setWeight(0.0, 0.0));
		celestialPanel.add(new BodyLabel("Left Ascension"), gbc.setLocation(0, 1));
		celestialPanel.add(leftAscensionCoordinates, gbc.setLocation(1, 1).setWeight(1.0, 0.0));
		celestialPanel.add(new BodyLabel("\u00B0"), gbc.setLocation(2, 1).setWeight(0.0, 0.0));
		celestialPanel.add(new CISButton("Transmit"), gbc.setLocation(1, 2));
		panelWrapper.add(celestialPanel, "Celestial");

		// Panel in switcher showing Roll/Pitch/Yaw
		attitudePanel.add(new BodyLabel("Roll"), gbc.setLocation(0, 0));
		attitudePanel.add(rollCoordinates, gbc.setLocation(1, 0).setWeight(1.0, 0.0));
		attitudePanel.add(new BodyLabel("\u00B0"), gbc.setLocation(2, 0).setWeight(0.0, 0.0));
		attitudePanel.add(new BodyLabel("Pitch"), gbc.setLocation(0, 1));
		attitudePanel.add(pitchCoordinates, gbc.setLocation(1, 1).setWeight(1.0, 0.0));
		attitudePanel.add(new BodyLabel("\u00B0"), gbc.setLocation(2, 1).setWeight(0.0, 0.0));
		attitudePanel.add(new BodyLabel("Yaw"), gbc.setLocation(0, 2));
		attitudePanel.add(yawCoordinates, gbc.setLocation(1, 2).setWeight(1.0, 0.0));
		attitudePanel.add(new BodyLabel("\u00B0"), gbc.setLocation(2, 2).setWeight(0.0, 0.0));
		attitudePanel.add(new CISButton("Transmit"), gbc.setLocation(1, 3));
		panelWrapper.add(attitudePanel, "Attitude");

		coordinatePanel.add(panelWrapper, BorderLayout.CENTER);
		coordinatePanel.add(cardSwitcherButtons, BorderLayout.PAGE_START);
		this.add(coordinatePanel, gbc.setLocation(2, 2).setWeight(1.0, 0.0).setInsets(5, 5, 0, 0));

		// Panel showing stats/telemetry
		telemetryPanel.add(adcsTemp, gbc.setLocation(0, 1).setInsets(0, 0, 0, 0));
		telemetryPanel.add(roll, gbc.setLocation(0, 2));
		telemetryPanel.add(pitch, gbc.setLocation(0, 3));
		telemetryPanel.add(yaw, gbc.setLocation(0, 4));
		telemetryPanel.add(xPWMOut, gbc.setLocation(0, 5));
		telemetryPanel.add(yPWMOut, gbc.setLocation(1, 1));
		telemetryPanel.add(zPWMOut, gbc.setLocation(1, 2));
		telemetryPanel.add(xCurrent, gbc.setLocation(1, 3));
		telemetryPanel.add(yCurrent, gbc.setLocation(1, 4));
		telemetryPanel.add(zCurrent, gbc.setLocation(1, 5));

		this.add(telemetryPanel, gbc.setLocation(1, 2).setWeight(0.0, 0.0).setInsets(5, 5, 0, 5));
		this.add(map, gbc.setLocation(0, 0).setSize(3, 2).setWeight(1.0, 1.0));
		this.add(attitudeIndicator, gbc.setLocation(0, 2).setSize(1, 1).setWeight(1.0, 0.0).setInsets(5, 0, 0, 5));
	}

	private class CardSwitcher extends CISPanel implements ActionListener, UIScaling {

		private static final long serialVersionUID = 1L;

		private final CISButton earthButton = new CISButton(String.format("%9s", "Earth"));
		private final CISButton attitudeButton = new CISButton(String.format("%9s", "Attitude"));
		private final CISButton celestialButton = new CISButton(String.format("%9s", "Celestial"));

		private CardSwitcher() {

			GridBagConstraintsWrapper gbc = new GridBagConstraintsWrapper();
			gbc.setFill(GridBagConstraintsWrapper.BOTH);

			this.setOpaque(false);
			this.setLayout(new GridBagLayout());

			earthButton.setHorizontalAlignment(SwingConstants.CENTER);
			attitudeButton.setHorizontalAlignment(SwingConstants.CENTER);
			celestialButton.setHorizontalAlignment(SwingConstants.CENTER);

			this.add(earthButton, gbc.setLocation(1, 0).setSize(1, 1).setWeight(1.0, 1.0).setInsets(5, 5, 5, 5));
			this.add(attitudeButton, gbc.setLocation(2, 0).setInsets(5, 0, 5, 0));
			this.add(celestialButton, gbc.setLocation(3, 0).setInsets(5, 5, 5, 5));

			for (Component component : this.getComponents()) {
				if (component instanceof CISButton) {
					((CISButton) component).addActionListener(this);
				}
			}
			earthButton.doClick();
		}

		@Override
		public void updateUIScaling(UIScale uiScale) {
			for (Component child : this.getComponents()) {
				if (child instanceof UIScaling)
					((UIScaling) child).updateUIScaling(uiScale);
			}
		}

		@Override
		public void actionPerformed(ActionEvent evt) {

			((CardLayout) panelWrapper.getLayout()).show(panelWrapper, evt.getActionCommand());
			for (Component component : this.getComponents()) {
				if (component instanceof CISButton) {
					component.setBackground(CustomColors.BUTTON_INACTIVE);
				}
			}
			((CISButton) evt.getSource()).setBackground(CustomColors.BUTTON_ACTIVE);
		}
	}

	@Override
	public void updateSatellite(CougSat satellite) {
		map.setValue(satellite.getAdcs().getLatitude(), satellite.getAdcs().getLongitude());

		adcsTemp.setValue(String.format(" %d\u00B0C", satellite.getEcs().getADCSTemp()));
		roll.setValue(String.format(" %6.2f\u00B0", satellite.getAdcs().getRoll()));
		pitch.setValue(String.format(" %6.2f\u00B0", satellite.getAdcs().getPitch()));
		yaw.setValue(String.format(" %6.2f\u00B0", satellite.getAdcs().getYaw()));
		xPWMOut.setValue(String.format("%d", satellite.getAdcs().getXPWMOut()));
		yPWMOut.setValue(String.format("%d", satellite.getAdcs().getYPWMOut()));
		zPWMOut.setValue(String.format("%d", satellite.getAdcs().getZPWMOut()));
		xCurrent.setValue(Units.currentPrefix(satellite.getAdcs().getXCurrent()));
		yCurrent.setValue(Units.currentPrefix(satellite.getAdcs().getYCurrent()));
		zCurrent.setValue(Units.currentPrefix(satellite.getAdcs().getZCurrent()));

	}

	@Override
	public void updateUIScaling(UIScale uiScale) {
		for (Component child : this.getComponents()) {
			if (child instanceof UIScaling) {
				((UIScaling) child).updateUIScaling(uiScale);
			}
		}
	}
}
