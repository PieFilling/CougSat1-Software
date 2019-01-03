package space.cougs.ground.gui.subsystems.modules.CISModules;

import javax.swing.JTextField;

import space.cougs.ground.gui.UIScaling;
import space.cougs.ground.gui.utils.Fonts;

public class CISTextField extends JTextField implements UIScaling {

    private static final long serialVersionUID = 1L;

    public CISTextField() {

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