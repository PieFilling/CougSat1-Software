package space.cougs.ground.gui.subsystems.modules.CISModules;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTabbedPane;

import space.cougs.ground.gui.UIScaling;
import space.cougs.ground.gui.utils.CustomColors;

public class CISTabbedPane extends JTabbedPane implements UIScaling {

    private static final long serialVersionUID = 1L;
    private static final Color color = CustomColors.BACKGROUND2;

    public CISTabbedPane() {
        setBackground(color);
    }

    @Override
    public void updateUIScaling(UIScale uiScale) {
        for (Component child : this.getComponents()) {
            if (child instanceof UIScaling)
                ((UIScaling) child).updateUIScaling(uiScale);
        }
    }

}