package bogatyrev.dataBase;

public abstract class SQLHandler {
    protected String SQL_DRIVER = "org.sqlite.JDBC";
    protected String SQL_URL = "jdbc:sqlite:src\\main\\resources\\note.db";
}
