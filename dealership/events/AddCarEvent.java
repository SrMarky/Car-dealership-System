package dealership.events;

import dealership.graphics.GUI;
import dealership.graphics.gui.GuiType;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCarEvent implements ActionListener {
    private final JButton button;

    public AddCarEvent(JButton button) {
        this.button = button;
        this.button.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            new GUI(GuiType.INSERT_CAR_GUI);
        }
    }
}
