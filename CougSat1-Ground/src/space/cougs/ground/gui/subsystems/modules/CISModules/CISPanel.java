package space.cougs.ground.gui.subsystems.modules.CISModules;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import space.cougs.ground.gui.UIScaling;
import space.cougs.ground.gui.utils.CustomColors;
import space.cougs.ground.gui.utils.Fonts;

public class CISPanel extends JPanel implements UIScaling {

    private static final long serialVersionUID = 1L;
    private static final Color color = CustomColors.BACKGROUND2;

    public CISPanel() {
        this.setBackground(color);
    }

    public CISPanel(CardLayout cardLayout) {
        this.setLayout(cardLayout);
        this.setBackground(color);
    }

    public CISPanel(BorderLayout borderLayout) {
        this.setLayout(borderLayout);
    }

    public CISPanel(GridBagLayout gridBagLayout) {
        this.setLayout(gridBagLayout);
        this.setBackground(color);
    }

    @Override
    public void updateUIScaling(UIScale uiScale) {

        switch (uiScale) {
        default:
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
        }
        for (Component child : this.getComponents()) {
            if (child instanceof UIScaling)
                ((UIScaling) child).updateUIScaling(uiScale);
        }
    }
}