package space.cougs.ground.gui.subsystems.modules.CISModules;


import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.SwingConstants;

import space.cougs.ground.gui.UIScaling;
import space.cougs.ground.gui.utils.CustomColors;
import space.cougs.ground.gui.utils.Fonts;

public class CISButton extends JButton implements UIScaling {

    private static final long serialVersionUID = 1L;
    private static final Color color = CustomColors.BACKGROUND3;
    private static final Color text = CustomColors.TEXT1;

    public CISButton() {
        setHorizontalAlignment(SwingConstants.CENTER);
        this.setForeground(text);
        this.setBackground(color);
    }

    public CISButton(String string) {
        setHorizontalAlignment(SwingConstants.CENTER);
        this.setText(string);
        this.setForeground(text);
        this.setBackground(color);
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