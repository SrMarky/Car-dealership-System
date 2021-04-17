package dealership.thread;

import dealership.graphics.GUI;
import dealership.graphics.gui.GuiType;

public class Start implements Runnable {

    @Override
    public void run() {
        new GUI(GuiType.START_APP_GUI);
    }
}
