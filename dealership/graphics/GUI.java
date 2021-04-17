package dealership.graphics;

import dealership.events.AddCarEvent;
import dealership.graphics.gui.GuiType;

import javax.swing.*;
import java.awt.*;

public class GUI {

    public GUI(GuiType guiType) {
        selectGUI(guiType);
    }

    private void selectGUI(GuiType guiType) { //TODO : DA FINIRE AGGIUNGERE BACKGROUND SISTEMARE BENE I PULSANTI
        switch (guiType) {
            case START_APP_GUI:
                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                // FRAME
                JFrame jFrame = new JFrame("Menu principale");
                jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                jFrame.setLayout(new FlowLayout());
                jFrame.setResizable(false);
                jFrame.setLocationRelativeTo(null);
                jFrame.pack();
                jFrame.setSize(screenSize.width, screenSize.height);

                // BUTTON
                JButton addCar = new JButton();
                JButton settings = new JButton();
                JButton listCars = new JButton();

                //BUTTON SETTINGS
                addCar.setName("addCar");
                addCar.setText("Aggiungi un auto");
                addCar.setBounds(100, 100, 100, 100);

                // EVENTS
                new AddCarEvent(addCar);

                jFrame.add(addCar);
                jFrame.setVisible(true);
                break;
            case INSERT_CAR_GUI:
                // FRAME
                screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                jFrame = new JFrame("Aggiungi un auto");
                jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                jFrame.setLayout(new FlowLayout());
                jFrame.setResizable(false);
                jFrame.setLocationRelativeTo(null);
                jFrame.pack();
                jFrame.setSize(screenSize.width, screenSize.height);
                jFrame.setVisible(true);
                break;
            case LIST_CARS_GUI:
            default:
                break;
        }
    }
}