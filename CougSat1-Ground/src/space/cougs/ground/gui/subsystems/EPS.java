package space.cougs.ground.gui.subsystems;

import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.Timer;

import space.cougs.ground.gui.UIScaling;
import space.cougs.ground.gui.subsystems.modules.power.Battery;
import space.cougs.ground.gui.subsystems.modules.power.Regulator;
import space.cougs.ground.gui.subsystems.modules.power.SolarPanel;
import space.cougs.ground.gui.subsystems.modules.power.Wire;
import space.cougs.ground.gui.utils.AnimationComponent;
import space.cougs.ground.gui.utils.CustomColors;
import space.cougs.ground.gui.utils.Fonts;
import space.cougs.ground.gui.utils.GridBagConstraintsWrapper;
import space.cougs.ground.satellites.CougSat;

public class EPS extends JPanel implements UIScaling, SatelliteInfo {

	private static final long serialVersionUID = 1L;
	private static final JTabbedPane mainPowerPanel = new JTabbedPane();
	private static final JPanel powerGeneration = new JPanel();
	private static final JPanel powerDistribution = new JPanel();

	private List<AnimationComponent> movingComponents = new ArrayList<AnimationComponent>();
	private static final double timerDelay = (1 / 10);
	private static int width = 0;
	private static int height = 0;

	private List<Wire> pvWires = new ArrayList<Wire>();
	private List<Regulator> mppList = new ArrayList<Regulator>();
	private List<SolarPanel> solarPanels = new ArrayList<SolarPanel>();
	private List<Battery> batts = new ArrayList<Battery>();

	Timer timer = new Timer(100, new MyActionListener());

	public EPS() {

		super();

		for (int i = 0; i < 8; i++) {
			solarPanels.add(new SolarPanel("pV" + i));
			pvWires.add(new Wire("pvWire" + i));
			mppList.add(new Regulator("mppt"));
		}
		for (int i = 0; i < 2; i++) {
			batts.add(new Battery("Battery" + i));
		}
		for (Wire pvWire : pvWires) {
			movingComponents.add(pvWire);
		}

		GridBagConstraintsWrapper gbc = new GridBagConstraintsWrapper();
		gbc.setFill(GridBagConstraintsWrapper.BOTH);
		this.setLayout(new GridBagLayout());

		powerGeneration.setLayout(null);
		for (int i = 0; i < 8; i++) {
			powerGeneration.add(solarPanels.get(i));
			powerGeneration.add(pvWires.get(i));
		}
		powerGeneration.setBackground(CustomColors.BACKGROUND2);
		powerGeneration.setOpaque(true);
		powerGeneration.addComponentListener(generationListener);

		powerDistribution.setLayout(null);
		powerDistribution.setBackground(CustomColors.BACKGROUND2);
		powerDistribution.addComponentListener(distributionListener);

		mainPowerPanel.setBackground(CustomColors.BACKGROUND1);
		mainPowerPanel.addTab("   Power Gen    ", powerGeneration);
		mainPowerPanel.addTab("   Power Dist   ", powerDistribution);
		mainPowerPanel.setSelectedComponent(powerGeneration);

		timer.start();

		this.add(mainPowerPanel, gbc.setLocation(0, 0).setSize(1, 1).setWeight(1.0, 1.0).setInsets(10, 10, 10, 10));
		this.setBackground(CustomColors.BACKGROUND1);
	}

	private final ComponentListener generationListener = new ComponentListener() {

		@Override
		public void componentHidden(ComponentEvent e) {

		}

		@Override
		public void componentMoved(ComponentEvent e) {

		}

		@Override
		public void componentResized(ComponentEvent e) {

			double voltage = 0.0;
			double current = 0.0;
			int y = 0;
			FontMetrics fontMetrics = powerGeneration.getFontMetrics(powerGeneration.getFont());
			for (int i = 0; i < solarPanels.size() / 2; i++) { // left 4 pV
				voltage = solarPanels.get(i).getVoltage();
				current = solarPanels.get(i).getCurrent();
				String printValues = String.format("%.3f", voltage) + "V " + String.format("%.3f", current) + "A";
				width = 2 + Math.max(fontMetrics.stringWidth(solarPanels.get(i).getName()),
						fontMetrics.stringWidth(printValues));
				height = fontMetrics.getHeight() * 2 + 4;
				y = 10 + 10 * i + i * height;
				solarPanels.get(i).setBounds(10, y, width, height);
				pvWires.get(i).setBounds(10 + width, y + height / 2, powerGeneration.getWidth() / 2 - width - 10, 10);
			}
			for (int i = solarPanels.size() / 2; i < solarPanels.size(); i++) {// right 4 pV
				voltage = solarPanels.get(i).getVoltage();
				current = solarPanels.get(i).getCurrent();
				String printValues = String.format("%.3f", voltage) + "V " + String.format("%.3f", current) + "A";
				width = 2 + Math.max(fontMetrics.stringWidth(solarPanels.get(i).getName()),
						fontMetrics.stringWidth(printValues));
				height = fontMetrics.getHeight() * 2 + 4;
				y = 10 + 10 * (i - solarPanels.size() / 2) + (i - solarPanels.size() / 2) * height;
				solarPanels.get(i).setBounds(powerGeneration.getWidth() - 10 - width, y, width, height);
				pvWires.get(i).setBounds(powerGeneration.getWidth() / 2, y + height / 2,
						powerGeneration.getWidth() / 2 - width - 10, 10);
			}

			// int ySpace = i * (powerGeneration.getHeight() - solarPanels.size() * (height
			// + 10))
			// / solarPanels.size();

			repaint();
		}

		@Override
		public void componentShown(ComponentEvent e) {
			this.componentResized(e);
		}
	};

	private final ComponentListener distributionListener = new ComponentListener() {

		@Override
		public void componentHidden(ComponentEvent e) {

		}

		@Override
		public void componentMoved(ComponentEvent e) {

		}

		@Override
		public void componentResized(ComponentEvent e) {

		}

		@Override
		public void componentShown(ComponentEvent e) {
			this.componentResized(e);
		}
	};

	public final class MyActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			for (AnimationComponent movingComponent : movingComponents) {
				movingComponent.updateFrame(timerDelay);
			}
		}
	}

	@Override
	public void updateUIScaling(UIScale uiScale) {

		for (Component component : mainPowerPanel.getComponents()) {
			if (component instanceof UIScaling) {
				((UIScaling) component).updateUIScaling(uiScale);
			}
		}

		Font bodyFont;
		switch (uiScale) {
		default:
		case SCALE_100:
			bodyFont = Fonts.BODY_16;
			mainPowerPanel.setFont(Fonts.TITLE_16);
			break;
		case SCALE_150:
			bodyFont = Fonts.BODY_24;
			mainPowerPanel.setFont(Fonts.TITLE_24);
			break;
		case SCALE_200:
			bodyFont = Fonts.BODY_32;
			mainPowerPanel.setFont(Fonts.TITLE_32);
			break;
		case SCALE_300:
			bodyFont = Fonts.BODY_48;
			mainPowerPanel.setFont(Fonts.TITLE_48);
			break;
		case SCALE_75:
			bodyFont = Fonts.BODY_12;
			mainPowerPanel.setFont(Fonts.TITLE_12);
			break;
		}

		for (Component component : this.getComponents()) {// JPanel - mainPowerPanel

			for (Component subComponent : ((Container) component).getComponents()) {// JTabbedPane - powerGen/Dist
				if (subComponent instanceof UIScaling) {
					((UIScaling) subComponent).updateUIScaling(uiScale);
				} else if (subComponent instanceof JPanel) {
					subComponent.setFont(bodyFont);
					for (Component subsubComponent : ((Container) subComponent).getComponents()) {
						if (subsubComponent instanceof SolarPanel) {
							((UIScaling) subsubComponent).updateUIScaling(uiScale);
							subsubComponent.setFont(bodyFont);
						}
					}
				}
			}
		}
	}

	public void updateSatellite(CougSat satellite) {

		int i = 0;
		for (SolarPanel solarPanel : solarPanels) {

			solarPanel.setVoltage(satellite.getPVVoltage(i));
			solarPanel.setCurrent(satellite.getPVCurrent(i));
			i++;
		}
		batts.get(0).setVoltage(satellite.getBatteryAVoltage());
		// batts.get(0).setPower();
		batts.get(0).setCurrent(satellite.getBatteryACurrent());
		batts.get(1).setVoltage(satellite.getBatteryBVoltage());
		batts.get(1).setCurrent(satellite.getBatteryBCurrent());
		// pvWires.add(new Wire("pvWire" + i));
		// mppList.add(new Regulator("mppt"));
	}
	// public int getHeight()
	// {
	// return height;
	// }
	// public void setHeight(int newHeight)
	// {
	// height = newHeight;
	// }
}
