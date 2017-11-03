package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
*clase de concecion general a base de datos 
*/
public class ConectionDB {
	
    private final String database;
    private String message;

    public Connection getConnection() throws Exception{
        Connection cn = null;


            Class.forName("com.mysql.jdbc.Driver").newInstance();
            cn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/" + database,
                    "root", "");

        return cn;
    }

    public ConectionDB() {
        this.database = "escela";
    }

    public ConectionDB(String database) {
        this.database = database;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
