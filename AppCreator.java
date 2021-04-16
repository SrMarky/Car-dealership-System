package applications.dealership;

import applications.dealership.object.CarObject;
import applications.dealership.save.CarSave;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class AppCreator {
    public AppCreator(Main main) {
        Scanner scanner = new Scanner(System.in);
        CarObject autoManager = new CarObject();

        System.out.println("INSERISCI UN AUTO");
        System.out.println("SCRIVI IL MODELLO DELL'AUTO");

        autoManager.setModel(scanner.nextLine());
        System.out.println("SCRIVI LA DESCRIZIONE DELL'AUTO");
        autoManager.setDescription(scanner.nextLine());
        System.out.println("SCRIVI LA DATA DELL'AUTO");
        autoManager.setDate(scanner.nextLine());
        System.out.println("SCRIVI IL COLORE DELL'AUTO");
        autoManager.setColor(scanner.nextLine());
        System.out.println("SCRIVI IL VENDITORE DELL'AUTO");
        autoManager.setSeller(scanner.nextLine());

        System.out.println("AUTO AGGIUNTA CON SUCCESSO!");
        System.out.println("Modello : " + autoManager.getModel());
        System.out.println("Descrizione : " + autoManager.getDescription());
        System.out.println("Data : " + autoManager.getDate());
        System.out.println("Colore : " + autoManager.getColor());
        System.out.println("Venditore : " + autoManager.getSeller());

        Supplier<CarObject> carObjectSupplier = () -> new CarObject(autoManager.getModel(), autoManager.getDescription(), autoManager.getDate(), autoManager.getColor(), autoManager.getSeller());
        main.getAutoManagerList().add(carObjectSupplier.get());
        Thread carSave = new Thread(new CarSave(main));

        try {
            TimeUnit.SECONDS.sleep(10L);
            carSave.start();
            carSave.join();
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }

        System.exit(2);
    }
}