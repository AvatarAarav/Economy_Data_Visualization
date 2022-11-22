package Database_Functions;

import Database_Functions.SQL_Acc;

import java.sql.*;
import static java.lang.System.*;
public class SQL_Update
{
    static SQL_Acc acc = new SQL_Acc();
    static String turl = acc.url + acc.dbName;
    static Connection c = ConnectionProvider.getConnection(turl, acc.username, acc.pwd);

    public static void change_development(String tN, String yr, String cc, double val)
    {
        try {
            String q = "update " + tN + " set Y" + yr + "=? where Country_Code=?";

            PreparedStatement pmt = c.prepareStatement(q);
            pmt.setDouble(1, val);
            pmt.setString(2, cc);
            pmt.executeUpdate();

            out.println("Table Updated Successfully...");
        }
        catch(Exception e){
            out.println("Table Update failed!!!");
            e.printStackTrace();
        }
    }
    public static void change_asset(String tN, String yr, String cc,long val)
    {
        try {
            String q = "update " + tN + " set Y" + yr + "=? where Country_Code=?";

            PreparedStatement pmt = c.prepareStatement(q);
            pmt.setLong(1, val);
            pmt.setString(2, cc);
            pmt.executeUpdate();

            out.println("Table Updated Successfully...");
        }
        catch(Exception e){
            out.println("Table Update failed!!!");
            e.printStackTrace();
        }
    }
    public static void main(String[] args)
    {
        //change("consumer_price_index","1960","AFG",1964.1);
    }
}