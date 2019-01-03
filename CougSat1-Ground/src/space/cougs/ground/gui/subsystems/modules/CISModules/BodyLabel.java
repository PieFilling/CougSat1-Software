package space.cougs.ground.gui.subsystems.modules.CISModules;

import java.awt.Color;

import javax.swing.Icon;
import javax.swing.JLabel;

import space.cougs.ground.gui.UIScaling;
import space.cougs.ground.gui.utils.CustomColors;
import space.cougs.ground.gui.utils.Fonts;

public class BodyLabel extends JLabel implements UIScaling {

    private static final long serialVersionUID = 1L;
    private static final Color color = CustomColors.TEXT1;

    public BodyLabel() {
        this.setForeground(color);
    }

    public BodyLabel(String text) {
        super(text);
        this.setForeground(color);
    }

    public BodyLabel(Icon image) {
        super(image);
        this.setForeground(color);
    }

    public BodyLabel(String text, int horizontalAlignment) {
        super(text, horizontalAlignment);
        this.setForeground(color);
    }

    public BodyLabel(Icon image, int horizontalAlignment) {
        super(image, horizontalAlignment);
        this.setForeground(color);
    }

    public BodyLabel(String text, Icon icon, int horizontalAlignment) {
        super(text, icon, horizontalAlignment);
        this.setForeground(color);
    }

    @Override
    public void updateUIScaling(UIScale uiScale) {

        switch (uiScale) {
        case SCALE_100:
            this.setFont(Fonts.BODY_16);
            break;
        case SCALE_150:
            this.setFont(Fonts.BODY_24);
            break;
        case SCALE_200:
            this.setFont(Fonts.BODY_32);
            break;
        case SCALE_300:
            this.setFont(Fonts.BODY_48);
            break;
        case SCALE_75:
            this.setFont(Fonts.BODY_12);
            break;
        default:
            break;
        }
    }
}
