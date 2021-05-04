package dealership.graphics.principal;

import dealership.events.AddCarEvent;
import javax.swing.*;
import java.awt.*;

public class GUI {

    public GUI(GuiType guiType) {
        selectGUI(guiType);
    }

    private void selectGUI(GuiType guiType) {
        //TODO : DA FINIRE AGGIUNGERE BACKGROUND SISTEMARE BENE I PULSANTI
        switch (guiType) {
            case START_APP_GUI:
                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                // FRAME
                JFrame jFrame = new JFrame("Menu principale");
                jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                jFrame.setResizable(false);
                jFrame.setLocationRelativeTo(null);
                jFrame.pack();
                jFrame.setSize(screenSize.width, screenSize.height);

                // PANEL
                JPanel panel = new JPanel();

                // BUTTON
                JButton addCar = new JButton();
                JButton settings = new JButton();
                JButton listCars = new JButton();

                //BUTTON SETTINGS
                addCar.setSize(25,25);
                settings.setSize(25,25);
                listCars.setSize(25,2);

                addCar.setText("Aggiungi un auto");
                settings.setText("Impostazioni");
                listCars.setText("Lista auto");


                // EVENTS
                new AddCarEvent(addCar);

                // INIT
                panel.add(addCar);
                panel.add(listCars);
                panel.add(settings);
                jFrame.add(panel);

                panel.setVisible(true);
                panel.setBackground(Color.BLACK);
                jFrame.setVisible(true);

                break;
            case INSERT_CAR_GUI:
                // FRAME
                screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                jFrame = new JFrame("Aggiungi un auto");
                jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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