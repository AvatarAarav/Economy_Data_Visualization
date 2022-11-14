import java.sql.*;
import java.util.*;
import static java.lang.System.out;
public class SQLDataExtractor
{
    static SQL_Acc acc = new SQL_Acc();
    static String turl = acc.url + acc.dbName;

    static Object[] getData_CountryWise(String tName, String code)
    {
        Connection con = ConnectionProvider.getConnection(turl, acc.username, acc.pwd);
        String q;
        ArrayList<Double> data = new ArrayList<Double>();
        try {
            Statement stmt = con.createStatement();
            q = "SELECT * FROM "+tName+" WHERE Country_Code ='"+code+"'";
            ResultSet res = stmt.executeQuery(q);

            while(res.next()) {
                for(int i = 3; i <= 64; i++) {
                    data.add(res.getDouble(i));
                }
            }

            Object[] arr = data.toArray();
            return arr;
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    static Object[] getData_YearWise(String tName, String year)
    {
        Connection con = ConnectionProvider.getConnection(turl, acc.username, acc.pwd);
        String q;
        ArrayList<String> data = new ArrayList<String>();
        try {
            Statement stmt = con.createStatement();
            q = "SELECT Country_Code, Y"+year+" FROM "+tName;
            ResultSet res = stmt.executeQuery(q);

            while(res.next()) {
                String temp = res.getString(1)+" - ";
                data.add( temp + res.getDouble(2) );
            }

            Object[] arr = data.toArray();
            return arr;
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    //TEST CODE
    static void display(Object[] arr)
    {
        out.println("OUTPUT");
        for(int i = 0; i<arr.length;i++)
            out.println(arr[i]);
    }
    public static void main(String[] args)
    {
        //display(getData_CountryWise("export_per", "AFG"));
        //display(getData_YearWise("export_per", "1960"));
    }
}
