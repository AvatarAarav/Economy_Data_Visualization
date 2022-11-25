package Database_Functions;

import java.sql.*;
import static java.lang.System.out;
public class DeleteJDBC
{
    static SQL_Acc acc = new SQL_Acc();
    static String turl = acc.url + acc.dbName;
    static Connection c = ConnectionProvider.getConnection(turl, acc.username, acc.pwd);

    public static void delRec(String tName, String cc)
    {
        try {
            Connection c = ConnectionProvider.getConnection(turl, acc.username, acc.pwd);
            Statement st = c.createStatement();
            String s = "delete from "+tName+" where Country_Code = '"+cc+"'";

            st.executeUpdate(s);

            out.println("RECORD DELETED SUCCESSFULLY...");
        }
        catch (Exception e){
            out.println("RECORD deletion failed...");
            e.printStackTrace();
        }
    }
    public static void delTable(String tName)
    {
        try {
            Connection c = ConnectionProvider.getConnection(turl, acc.username, acc.pwd);
            Statement st = c.createStatement();
            String s = "drop table "+tName;

            st.executeUpdate(s);

            out.println("Table DELETED SUCCESSFULLY...");
        }
        catch (Exception e){
            out.println("Table deletion failed...");
            e.printStackTrace();
        }
    }
    public static void delDB()
    {
        try {
            Statement st = c.createStatement();
            String s = "drop database "+acc.dbName;

            st.executeUpdate(s);

            out.println("DB DELETED SUCCESSFULLY...");
        }
        catch (Exception e){
            out.println("DB deletion failed...");
            e.printStackTrace();
        }
    }
    //TEST
    public static void main(String[] args)
    {
        //delRec("consumer_price_index","AFE");
        //delTable("consumer_price_index");
        //delDB();
    }
}