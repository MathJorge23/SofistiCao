
package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
    public Connection getConnectionUSBWebService(){
        try {
            var conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/petshop?zeroDateTimeBehavior=CONVERT_TO_NULL&useTimezone=true&serverTimezone=UTC", "root", "32131156theco");
            //private static String url = "jdbc:mysql://localhost:3306/petshop?zeroDateTimeBehavior=CONVERT_TO_NULL&useTimezone=true&serverTimezone=UTC";
            return conn;
        } catch (Exception erro) {
            throw new RuntimeException(erro);
        }
    }

}
