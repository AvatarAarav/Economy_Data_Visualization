package Database_Functions;

import Database_Functions.SQL_Acc;

import java.sql.*;
import java.util.*;
import static java.lang.System.out;
public class SQLDataExtractor
{
    static SQL_Acc acc = new SQL_Acc();
    static String turl = acc.url + acc.dbName;
    static Connection con = ConnectionProvider.getConnection(turl, acc.username, acc.pwd);

    public static Object[] getData_CountryWise(String tName, String code)
    {
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

    public static Object[] getData_YearWise(String tName, String year)
    {
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
    public static Object[] getCountryInfo()
    {
        String q;
        ArrayList<String> data = new ArrayList<String>();
        try {
            Statement stmt = con.createStatement();
            q = "SELECT * FROM consumer_price_index";
            ResultSet res = stmt.executeQuery(q);

            while(res.next()) {
                String k = res.getString(2) +" - "+ res.getString(1);
                data.add(k);
            }

            Object[] arr = data.toArray();
            return arr;
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public static String getData_Specific(String tName, String code, String year)
    {
        String q, out="";
        try {
            Statement stmt = con.createStatement();
            q = "SELECT Country_Code, Y"+year+" FROM "+tName+" WHERE Country_Code ='"+code+"'";
            ResultSet res = stmt.executeQuery(q);

            while(res.next()) {
                out = code + " - " + res.getDouble(2);
            }

            return out;
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
        //out.println(getData_Specific("export_per", "AFG","1969"));
        //display(getCountryInfo());
    }
}