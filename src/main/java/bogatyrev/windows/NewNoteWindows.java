package bogatyrev.windows;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class NewNoteWindows {
    public NewNoteWindows() throws Exception {
        Parent newroot = FXMLLoader.load(getClass().getResource("/newNoteWindows.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Новая заметка");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.setScene(new Scene(newroot,250, 200));
        stage.showAndWait();
        }
}
