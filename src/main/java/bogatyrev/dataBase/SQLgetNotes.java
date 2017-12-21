package bogatyrev.dataBase;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.apache.log4j.Logger;

import java.sql.*;

public class SQLgetNotes extends SQLHandler implements Runnable {
    private static final Logger log = Logger.getLogger(SQLgetNotes.class);
   private ObservableList<Note> noteData = FXCollections.observableArrayList();

   public SQLgetNotes(ObservableList<Note> noteData) {
        this.noteData = noteData;
    }

    @Override
    public void run() {
        try {
            Class.forName(SQL_DRIVER);
            try (Connection connection = DriverManager.getConnection(SQL_URL);
            Statement statement = connection.createStatement();) {
                noteData.clear();
                ResultSet rs = statement.executeQuery("SELECT *FROM Note");
                while (rs.next()) {
                    noteData.add(new Note(rs.getString(1), rs.getString(2)));
                }
                rs.close();
            } catch (SQLException e) {
                log.error("exception", e);;

            }
        } catch (ClassNotFoundException e) {
            log.error("exception", e);
        }
    }
}


