package trabalhopizzaria;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
    
    public Connection getConnection() throws SQLException, IOException {
        try {
            Properties prop = new Properties();
            prop.load(getClass().getResourceAsStream("bd.properties"));
            String dbDriver = prop.getProperty("db.driver");
            String dbUrl = prop.getProperty("db.url");
            String dbUser = prop.getProperty("db.user");
            String dbPwd = prop.getProperty("db.password");
            System.out.println(dbDriver);
            Class.forName(dbDriver);
            return DriverManager.getConnection(dbUrl, dbUser, dbPwd);
        } 
        catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }
    
}
