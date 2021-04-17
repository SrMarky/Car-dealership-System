package applications.dealership.mysql;

import java.sql.*;

public class MysqlManager {
    private Connection connection;

    public MysqlManager() {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                String database = "auto";
                String user = "root";
                String password = "password2";
                String host = "localhost";
                System.out.println("Database collegato!");
                connection = DriverManager.getConnection("jdbc:mysql://" + host + "/" + database + "?autoReconnect=true&useSSL=false&tcpKeepAlive=true" + "&characterEncoding=utf8", user, password);
                createTable();
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
                System.err.println("Conessione al database non riuscita!");
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
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.execute();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertCar(String model,String field,String date,String color,String seller) {
        try {
            String sql = "INSERT INTO cars(model,description,date,color,seller) VALUES(?,?,?,?,?)";
            PreparedStatement ps1 = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); //TODO NETXT UPDATE ADD * ID AI *
            ps1.setString(1, model);
            ps1.setString(2, field);
            ps1.setString(3, date);
            ps1.setString(4, color);
            ps1.setString(5, seller);
            ps1.execute();
            ps1.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

    }
}
/*
<>
 */
