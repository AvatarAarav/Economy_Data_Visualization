import java.nio.file.Path;
import java.sql.*;
import static java.lang.System.*;
import java.io.*;
import java.nio.*;

class DBFunctions
{
    static final String url = "jdbc:mysql://localhost:3306/";
    static final String username = "root";
    static final String pwd = "root12345";

    static boolean doesDBexists(String dbName)
    {
        Connection con = null;
        ResultSet rs = null;

        try{
            con = ConnectionProvider.getConnection(url, username, pwd);

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

    static void createDB(String dbName)
    {
        if(doesDBexists(dbName)) {
            out.println("DB exists...");
            return;
        }
        try {
            Connection con = ConnectionProvider.getConnection(url, username, pwd);
            System.out.println("Connection established......");

            Statement stmt = con.createStatement();
            String query = "CREATE database " + dbName;
            stmt.execute(query);

            System.out.println("Database created");
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    static void createTable()
    {
        Connection con = null;
        String dbName = "economicdata";
        //createDB(dbName);
        try {
            String turl = url + dbName;
            con = ConnectionProvider.getConnection(turl, username, pwd);

//            String q = "create table ConsumerPriceIndex( Country_Name varchar(30), Country_Code varchar(10) primary key, " +
//                        "Indicator_Name varchar(30), Indicator_Code varchar(20)";
//            for(int i=1960;i<=2021;i++){
//                q=q+", Y"+i+" FLOAT";
//            }
//            q = q + " );";
//
//            Statement stmt = con.createStatement();
//            stmt.executeUpdate(q);
//            out.println("Database created....");


            String filepath = "Data-Files/Consumer_Price_Index123.csv";
            con.setAutoCommit(false);
            String q1 = "insert into table economicdata values( ?,?,?,?";
            for(int i=1960;i<=2021;i++){
                q1 = q1+",?";
            }
            q1 = q1 + " );";
            PreparedStatement sta = con.prepareStatement(q1);

            BufferedReader br = new BufferedReader(new FileReader(filepath));
            String linetxt = null;

            br.readLine();
            int f = 0;
            while((linetxt=br.readLine()) != null)
            {
                String[] data = linetxt.split(",");
                String n1 = data[0];
                String n2 = data[1];
                String n3 = data[2];
                String n4 = data[3];

                sta.setString(1, n1);
                sta.setString(2, n2);
                sta.setString(3, n3);
                sta.setString(4, n4);

                int k =4;
                for(int i=1960;i<=2021;i++)
                {
                    if(k>data.length-1)
                        break;
                    String n5 = data[k];
                    out.println("f,i,n5 = "+f+","+i+","+n5);
                    if(n5.equals(" ") || n5 == null )
                        sta.setFloat((k+1),0);
                    else
                        sta.setFloat((k+1), Float.parseFloat(n5));
                    k++;
                }
                f++;
                sta.addBatch();
            }
            br.close();
            sta.executeBatch();
            con.commit();
        }
        catch(Exception e){
            out.println("Database creation FAILED!!");
            e.printStackTrace();
        }
        finally{
            try {
                con.close();
            }catch(SQLException E){}
        }
    }
    public static void main(String args[])
    {
        out.println(doesDBexists("SupaStrikas"));
        createDB("SupaStrikas");
        createTable();
    }
}