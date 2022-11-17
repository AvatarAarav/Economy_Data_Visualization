import java.sql.*;
import java.io.*;
import static java.lang.System.*;
public class SQL_Update
{
    public static void main(String[] args)throws Exception
    {
        String url = "jdbc:mysql://localhost:3306/myjdbc";
        String un = "root", pwd = "root12345";
        Connection c = ConnectionProvider.getConnection(url,un,pwd);

        String q = "update table1 set tName=?, tCity=? where tID=?";

        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        out.println("Enter new Name and City:");
        String n = br.readLine();
        String city = br.readLine();

        out.print("Enter ID: ");
        int id = Integer.parseInt(br.readLine());

        PreparedStatement pmt = c.prepareStatement(q);
        pmt.setString(1,n);
        pmt.setString(2,city);
        pmt.setInt(3,id);

        pmt.executeUpdate();

        out.println("Job done..");
    }
}
