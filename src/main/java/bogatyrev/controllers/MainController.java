package bogatyrev.controllers;

import bogatyrev.dataBase.Note;
import bogatyrev.dataBase.SQLgetNotes;
import bogatyrev.windows.NewNoteWindows;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.apache.log4j.Logger;


public class MainController {
    private static final Logger log = Logger.getLogger(MainController.class);
    private static ObservableList<Note> noteData = FXCollections.observableArrayList();

    @FXML
    private  TableView<Note> table;
    @FXML
    private TableColumn<Note, String> dateNote;
    @FXML
    private TableColumn<Note, String> textNote;
    @FXML
    private Button addNote;


    public void initialize() {
        addNote.setOnAction(e->addNewNote());
        dateNote.setCellValueFactory(cellData -> cellData.getValue().dateProperty());
        textNote.setCellValueFactory(cellData -> cellData.getValue().textProperty());
        table.setItems(updateTable ());
    }

    public void addNewNote (){
        try {
            new NewNoteWindows();
        }
        catch (Exception e) {
            log.error("exception", e);
        }
    }
    public static  ObservableList<Note>  updateTable (){
        Thread getNotes = new Thread(new SQLgetNotes(noteData));
        getNotes.start();
        try {
            getNotes.join();
        } catch (InterruptedException e) {
            log.error("exception", e);
        }
        return noteData;
    }
}

