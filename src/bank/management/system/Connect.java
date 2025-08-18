package bank.management.system;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {

    Connection connection;  // stores the connection to the database once it is established

    public Connect(){
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankSystem", "root", "1234");  // establishes database connection
        }
        catch(Exception e){
            e.printStackTrace();    // if exception is thrown, print stack trace
        }
    }

    public Connection getConnection(){
        return connection;
    }
}
