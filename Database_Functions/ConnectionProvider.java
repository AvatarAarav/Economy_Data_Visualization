package Database_Functions;

import java.sql.*;
public class ConnectionProvider
{
    private static Connection con;
    public static Connection getConnection(String url, String un, String pwd)
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, un, pwd);
        }
        catch(Exception ex){}
        return con;
    }
}