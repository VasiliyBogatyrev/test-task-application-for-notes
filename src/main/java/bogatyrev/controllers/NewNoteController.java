package bogatyrev.controllers;

import bogatyrev.dataBase.SQLsetNote;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.apache.log4j.Logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class NewNoteController {
    private static final Logger log = Logger.getLogger(NewNoteController.class);
    private int MAX_SIZE_NOTE=100;
    private String dataNote;
    private String textNote;
    @FXML
    private Button ok;
    @FXML
    private Button cancel;
    @FXML
    private TextField currentDate;
    @FXML
    private TextArea textNewNote;

    public void initialize() {
        ok.setOnAction(e->saveNote());
        cancel.setOnAction(e->closeWindows());
        textNewNote.setWrapText(true);
        textNewNote.textProperty().addListener((observable, oldValue, newValue) -> {
            if (textNewNote.getText().length() > MAX_SIZE_NOTE) {
                String s = textNewNote.getText().substring(0, MAX_SIZE_NOTE);
                textNewNote.setText(s);
            }
        });
        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("MMM d yyyy  hh:mm a");
        currentDate.setText(LocalDateTime.now().format(formatDate));


    }
    public void closeWindows(){
        Stage stage = (Stage) cancel.getScene().getWindow();
        stage.close();
    }

    public void saveNote(){
        textNote=textNewNote.getText();
        dataNote=currentDate.getText();
        Thread setNote = new Thread(new SQLsetNote(dataNote,textNote));
        setNote.start();
        try {
            setNote.join();
        } catch (InterruptedException e) {
            log.error("exception", e);
        }
        MainController.updateTable();
        closeWindows();
    }

}
