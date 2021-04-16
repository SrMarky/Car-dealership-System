package esercizi.dealership.save;

import esercizi.dealership.Main;

public class CarSave implements Runnable {
    private final Main main;

    public CarSave(Main main) {
        this.main = main;
    }
    
    @Override
    public void run() {
        main.getAutoManagerList().forEach(c -> main.getMysqlManager().insertCar(c.getModel(), c.getDescription(), c.getDate(), c.getColor(), c.getSeller()));
        System.out.println("SALVATAGGIO COMPLETATO");
    }
}