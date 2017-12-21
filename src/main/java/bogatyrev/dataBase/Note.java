package bogatyrev.dataBase;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Note {
    private StringProperty date;
    private StringProperty text;

    public Note(String date, String text) {
        this.date = new SimpleStringProperty(date);
        this.text = new SimpleStringProperty(text);
    }

    public StringProperty dateProperty() {
        return date;
    }

    public StringProperty textProperty() {
        return text;
    }
}
