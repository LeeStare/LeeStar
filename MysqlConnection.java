package system;

import java.sql.Connection;
import java.sql.DriverManager;

public class MysqlConnection
{
	public Connection createConnection()
	{
        try{
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost/cus?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            String username = "root";
            String password = "HcHgjc105Leo00707";
            Class.forName(driver);
           
            Connection conn = DriverManager.getConnection(url,username,password);
            System.out.println("Connected");
            return conn;
        } catch(Exception e){System.out.println(e);}
       
       
        return null;
	}
	

}
