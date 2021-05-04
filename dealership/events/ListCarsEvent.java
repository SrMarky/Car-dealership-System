package dealership.events;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListCarsEvent implements ActionListener {
    private final JButton button;

    public ListCarsEvent(JButton button) {
        this.button = button;
        this.button.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //TODO
    }
}
