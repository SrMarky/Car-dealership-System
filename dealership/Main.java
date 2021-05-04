package dealership;

import dealership.manager.AppManager;
import dealership.mariadb.MysqlManager;
import dealership.object.CarObject;
import dealership.thread.TStart;
import lombok.Getter;
import java.util.LinkedList;
import java.util.List;

public class Main implements AppManager {
    @Getter
    private MysqlManager mysqlManager;
    @Getter
    private List<CarObject> autoManagerList;

    public static void main(String[] strings){
        Main main = new Main();
        main.start();
    }

    @Override
    public void start() {
        this.autoManagerList = new LinkedList<>();
        this.mysqlManager = new MysqlManager();
        Thread tStart = new Thread(new TStart());
        tStart.start();
    }


}
