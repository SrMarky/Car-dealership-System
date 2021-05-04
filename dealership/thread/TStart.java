package dealership.thread;

import dealership.graphics.principal.GUI;
import dealership.graphics.principal.GuiType;

public class TStart implements Runnable {

    @Override
    public void run() {
        new GUI(GuiType.START_APP_GUI);
    }
}
