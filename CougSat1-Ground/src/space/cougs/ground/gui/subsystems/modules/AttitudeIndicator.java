package space.cougs.ground.gui.subsystems.modules;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JComponent;

import space.cougs.ground.gui.UIScaling;

public class AttitudeIndicator extends JComponent implements UIScaling {

	private static final long serialVersionUID = 1L;

	public AttitudeIndicator() {
		super();
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension();
	}

	@Override
	public Dimension getMinimumSize() {
		return new Dimension();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}

	@Override
	public void updateUIScaling(UIScale uiScale) {
		for (Component child : this.getComponents()) {
			if (child instanceof UIScaling)
				((UIScaling) child).updateUIScaling(uiScale);
		}
	}
}
