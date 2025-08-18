package bank.management.system;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {

    Connection connection;  // stores the connection to the database once it is established
    Statement statement;    // allows for SQL queries or updates to the database

    public Connect(){
        try{
            connection = DriverManager.getConnection("jdbc:mysql//localhost:3306/bankSystem", "root", "1234");  // establishes database connection
            statement = connection.createStatement();   // create Statement object that is used for sending SQL queries and retrieving data from database
        }
        catch(Exception e){
            e.printStackTrace();    // if exception is thrown, print stack trace
        }
    }
}