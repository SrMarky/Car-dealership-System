package applications.dealership;

import applications.dealership.manager.AppManager;
import applications.dealership.object.CarObject;
import applications.dealership.mysql.MysqlManager;
import lombok.Getter;
import java.util.LinkedList;
import java.util.List;

public class Main implements AppManager {
    @Getter private MysqlManager mysqlManager;
    @Getter private List<CarObject> autoManagerList;

    public static void main(String[] strings){
        Main main = new Main();
        main.start();
    }

    @Override
    public void start() {
        this.autoManagerList = new LinkedList<>();
        this.mysqlManager = new MysqlManager();
        new AppCreator(this);

    }


}
