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

    public Connection getConnection() {
        Connection cn = null;

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            cn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/" + database,
                    "root", "");

        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            setMessage(ex.getMessage());
        }
        catch(Exception e)
        {
            setMessage(e.getMessage());
        }

        return cn;
    }

    public ConectionDB() {
        this.database = "sigecu";
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
