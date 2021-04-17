package dealership.mysql;

import javax.swing.*;
import java.sql.*;

public class MysqlManager {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private JFrame jFrame;
    //TODO DA RIVEDERE

    public MysqlManager() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String database = "auto";
            String user = "root";
            String password = "password2";
            String host = "localhost";
            this.connection = DriverManager.getConnection("jdbc:mysql://" + host + "/" + database + "?autoReconnect=true&useSSL=false&tcpKeepAlive=true" + "&characterEncoding=utf8", user, password);
            System.out.println("Database collegato!");
            createTable();
        } catch (ClassNotFoundException | SQLException e) {
            this.jFrame = new JFrame();
            this.jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JOptionPane.showMessageDialog(jFrame, "Connessione al database non riuscita!!!", "Database Error", JOptionPane.ERROR_MESSAGE);
            System.exit(5);
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
            this.jFrame = new JFrame();
            this.jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JOptionPane.showMessageDialog(jFrame, "Errore impossibile creare la tabella nel database!!", "Database Error", JOptionPane.ERROR_MESSAGE);
            System.exit(5);
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
            this.jFrame = new JFrame();
            this.jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JOptionPane.showMessageDialog(jFrame, "Errore impossibile inserire l'auto!!!", "Database Error", JOptionPane.ERROR_MESSAGE);
            System.exit(5);
        }

    }
}
/*
<>
 */