package esercizi.dealership;

import esercizi.dealership.manager.AppManager;
import esercizi.dealership.manager.CarManager;
import esercizi.dealership.mysql.MysqlManager;
import lombok.Getter;
import java.util.LinkedList;
import java.util.List;

public class Main implements AppManager {
            private static Main main;
    @Getter private MysqlManager mysqlManager;
    @Getter private List<CarManager> autoManagerList;

    public static void main(String[] strings){
        main = new Main();
        main.start();
    }

    @Override
    public void start() {
        this.autoManagerList = new LinkedList<>();
        this.mysqlManager = new MysqlManager();
        new AppCreator(main);

    }


}
