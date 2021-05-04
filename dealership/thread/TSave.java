package dealership.thread;

import dealership.Main;

public class TSave implements Runnable {
    private final Main main;

    public TSave(Main main) {
        this.main = main;
    }
    
    @Override
    public void run() {
        main.getAutoManagerList().forEach(c -> main.getMysqlManager().insertCar(c.getModel(), c.getDescription(), c.getDate(), c.getColor(), c.getSeller()));
        System.out.println("SALVATAGGIO COMPLETATO");
    }
}