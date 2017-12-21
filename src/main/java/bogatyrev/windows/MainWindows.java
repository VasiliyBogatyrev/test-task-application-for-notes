package bogatyrev.windows;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class MainWindows extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/mainWindows.fxml"));
        primaryStage.setTitle("Заметки");
        primaryStage.setScene(new Scene(root, 450, 400));
        primaryStage.setMinHeight(100);
        primaryStage.show();
    }
}
