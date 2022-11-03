import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import static java.lang.System.*;
import java.sql.PreparedStatement;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
class DBFunctions
{
    static final String URL = "jdbc:mysql://localhost:3306/";
    static final String USER = "root";
    static final String PASS = "";
    static boolean check_database(){
        return true;
    }
}