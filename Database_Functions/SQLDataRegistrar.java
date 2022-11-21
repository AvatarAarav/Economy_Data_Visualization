package Database_Functions;

import Database_Functions.SQL_Acc;

import java.sql.*;
import static java.lang.System.*;
import java.io.*;
public class SQLDataRegistrar
{
    static SQL_Acc acc = new SQL_Acc();

    public static boolean doesDBexists(String dbName)
    {
        Connection con = null;
        ResultSet rs = null;
        try{
            con = ConnectionProvider.getConnection(acc.url, acc.username, acc.pwd);

            if(con != null)
            {
                rs = con.getMetaData().getCatalogs();
                while(rs.next())
                {
                    String catalogs = rs.getString(1);
                    if(dbName.equalsIgnoreCase(catalogs))
                        return true;
                }
            }
            else{
                return false;
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
        finally {
            if( rs != null) {
                try{
                    rs.close();
                }
                catch(SQLException ex){
                    ex.printStackTrace();
                }
            }
            if(con != null) {
                try{
                    con.close();
                }
                catch(SQLException ex){
                    ex.printStackTrace();
                }
            }
        }
        return false;
    }
    public static void createDB(String dbName)
    {
        if(doesDBexists(dbName)) {
            out.println("DB exists...");
            return;
        }
        try {
            Connection con = ConnectionProvider.getConnection(acc.url, acc.username, acc.pwd);
            System.out.println("Connection established......");

            Statement stmt = con.createStatement();
            String query = "CREATE database " + dbName;
            stmt.execute(query);

            System.out.println("Database created\n");
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    public static void createTable(String dbName, String tName)
    {
        try {
            String turl = acc.url + dbName;
            Connection con = ConnectionProvider.getConnection(turl, acc.username, acc.pwd);

            DatabaseMetaData dbm = con.getMetaData();
            ResultSet tables = dbm.getTables(null, null, tName, null);
            if (tables.next()) {
                out.println("Table exists....");
                return;
            }

            String q = "create table " + tName + "( Country_Name varchar(100), Country_Code varchar(10) primary key ";
            for (int i = 1960; i <= 2021; i++) {
                q = q + ", Y" + i + " FLOAT";
            }
            q = q + " );";

            Statement stmt = con.createStatement();
            stmt.executeUpdate(q);
            out.println("Table "+tName+" Created");
            con.close();
        }
        catch(Exception e){
            out.println("Table creation FAILED!!");
            e.printStackTrace();
        }
    }
    public static void insertData(String dbName, String tName, String file)
    {
        try
        {
            String turl = acc.url + dbName;
            Connection con = ConnectionProvider.getConnection(turl, acc.username, acc.pwd);

            String filepath = "CSV_Files\\"+file;
            con.setAutoCommit(false);

            String q1 = "insert into "+tName+" values( ?,?";
            for(int i=1960;i<=2021;i++){
                q1 = q1+",?";
            }
            q1 = q1 + " );";

            PreparedStatement sta = con.prepareStatement(q1);
            BufferedReader br = new BufferedReader(new FileReader(filepath));

            String line;
            br.readLine();

            while( ( line=br.readLine() ) != null )
            {
                String[] data = line.split(",");
                String n1 = data[0]; String n2 = data[1];
                sta.setString(1, n1); sta.setString(2, n2);

                int k =2;
                for(int i=1960;i<=2021;i++)
                {
                    String n5 = data[k];
                    if( n5.equals(" ") )
                        sta.setFloat((k+1),0);
                    else
                        sta.setFloat((k+1), Float.parseFloat(n5));
                    k++;
                }
                sta.addBatch();
                sta.executeUpdate();
            }
            br.close();
            con.commit();
            con.close();
            out.println("Data Inserted into "+tName+" SUCCESS!!");
        }
        catch(Exception e){
            out.println("Data insertion into table "+tName+" FAILED!!");
            e.printStackTrace();
        }
    }
    public static void setDB(String dbName,String[] tables, String[] files)
    {
        createDB(dbName);

        if(tables.length != files.length) {
            out.println("Array Size is NOT MATCHING!");
            return;
        }
        int len = tables.length;

        for(int i = 0; i<len; i++)
        {
            createTable(dbName, tables[i]);
            insertData(dbName, tables[i], files[i]);
        }
    }

    public static void main(String[] args)
    {
        String dbName = acc.dbName;
        String[] tables = {"consumer_price_index", "deposit_interest_rate",
                            "exchange_rate", "export_per", "gdp", "import_per",
                            "population", "tax", "reserves"};
        String[] files = {"Consumer_Price_Index.csv", "Deposit_Interest_Rate.csv",
                            "Exchange_Rate.csv", "Export_Percentage_of_GDP.csv",
                            "GDP.csv", "Import_percentazge_of_GDP.csv",
                            "Populaton.csv", "Tax_Revenue.csv", "Total_Reserves.csv"};
        setDB(dbName, tables, files);
    }
}