package dealership.mariadb;

import dealership.graphics.gui.Message;
import dealership.messages.Messages;
import java.sql.*;

public class MysqlManager {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public MysqlManager() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); //org.mariadb.jdbc.Driver //jdbc:mariadb: //TODO DA CAMBIARE
            String database = "auto";
            String user = "root";
            String password = "password2";
            String host = "localhost";
            this.connection = DriverManager.getConnection("jdbc:mysql://" + host + "/" + database + "?autoReconnect=true&useSSL=false&tcpKeepAlive=true" + "&characterEncoding=utf8", user, password);
            createTable();
        } catch (ClassNotFoundException | SQLException e) {
            new Message(Messages.DATABASE_CONNECTION_ERROR, 0);
        }
    }

    private void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS cars(" +
                "model VARCHAR(16)," +
                "description VARCHAR(64), " +
                "date VARCHAR(16), " +
                "color VARCHAR(16), " +
                "seller VARCHAR(16));";
        try {
            this.preparedStatement = connection.prepareStatement(sql);
            this.preparedStatement.execute();
            this.preparedStatement.close();
        } catch (SQLException e) {
            new Message(Messages.DATABASE_CREATE_TABLE_ERROR, 0);
        }
    }

    public void insertCar(String model, String field, String date, String color, String seller) {
        try {
            String sql = "INSERT INTO cars(model,description,date,color,seller) VALUES(?,?,?,?,?)";
            this.preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); //TODO NETXT UPDATE ADD * ID WITH AI *
            this.preparedStatement.setString(1, model);
            this.preparedStatement.setString(2, field);
            this.preparedStatement.setString(3, date);
            this.preparedStatement.setString(4, color);
            this.preparedStatement.setString(5, seller);
            this.preparedStatement.execute();
            this.preparedStatement.close();
        } catch (SQLException exception) {
            new Message(Messages.INSERT_CAR_ERROR, 0);
        }

    }
}