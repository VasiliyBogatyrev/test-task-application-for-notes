package bogatyrev.dataBase;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLsetNote extends SQLHandler implements Runnable {
    private static final Logger log = Logger.getLogger(SQLsetNote.class);
    private String date;
    private String text;

    public SQLsetNote(String date, String text) {
        this.date = date;
        this.text = text;
    }

    @Override
    public void run() {
        try {
            Class.forName(SQL_DRIVER);
            try (Connection connection = DriverManager.getConnection(SQL_URL);
                 Statement statement = connection.createStatement();) {
                statement.executeUpdate("INSERT INTO Note  (Date, Text) VALUES ('" + date + "', '" + text + "')");
            } catch (SQLException e) {
                log.error("exception", e);
            }
        } catch (ClassNotFoundException e) {
            log.error("exception", e);
        }
    }

}
