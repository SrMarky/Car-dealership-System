package dealership.graphics.gui;

import dealership.manager.GuiManager;
import dealership.messages.Messages;
import javax.swing.*;

public class Message implements GuiManager {

    public Message(Messages messages, int err) {
        show(messages, err);
    }

    @Override
    public void show(Messages messages, int err) {
        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JOptionPane.showMessageDialog(jFrame, messages.toString(), messages.name(), err);
        System.exit(5);
    }
}
