package Utility;

import java.sql.*;

public class UtilityMethods {
    
    public static Connection createConnection(String url, String username, String password) throws SQLException{
        
           CustomVariables.connection = DriverManager.getConnection( url,  username, password);
        System.out.println("DB Connected");
           return CustomVariables.connection; 
        
        
    }

}
