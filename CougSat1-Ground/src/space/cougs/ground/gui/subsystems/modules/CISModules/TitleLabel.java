package space.cougs.ground.gui.subsystems.modules.CISModules;

import java.awt.Color;
import java.awt.Component;

import javax.swing.Icon;
import javax.swing.JLabel;

import space.cougs.ground.gui.UIScaling;
import space.cougs.ground.gui.utils.CustomColors;
import space.cougs.ground.gui.utils.Fonts;

public class TitleLabel extends JLabel implements UIScaling {

	private static final long serialVersionUID = 1L;
	private static final Color color = CustomColors.TEXT1;

	public TitleLabel() {
		this.setForeground(color);
	}

	public TitleLabel(String text) {
		super(text);
		this.setForeground(color);
	}

	public TitleLabel(Icon image) {
		super(image);
		this.setForeground(color);
	}

	public TitleLabel(String text, int horizontalAlignment) {
		super(text, horizontalAlignment);
		this.setForeground(color);
	}

	public TitleLabel(Icon image, int horizontalAlignment) {
		super(image, horizontalAlignment);
		this.setForeground(color);
	}

	public TitleLabel(String text, Icon icon, int horizontalAlignment) {
		super(text, icon, horizontalAlignment);
		this.setForeground(color);
	}

	@Override
	public void updateUIScaling(UIScale uiScale) {

		switch (uiScale) {
		case SCALE_100:
			this.setFont(Fonts.TITLE_16);
			break;
		case SCALE_150:
			this.setFont(Fonts.TITLE_24);
			break;
		case SCALE_200:
			this.setFont(Fonts.TITLE_32);
			break;
		case SCALE_300:
			this.setFont(Fonts.TITLE_48);
			break;
		case SCALE_75:
			this.setFont(Fonts.TITLE_12);
			break;
		default:
			break;
		}
		for (Component child : this.getComponents()) {
			if (child instanceof UIScaling)
				((UIScaling) child).updateUIScaling(uiScale);
		}
	}
}
