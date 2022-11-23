import Database_Functions.SQL_Update;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.out;

public class HandleUpdate {
    static Scanner sc=new Scanner(System.in);
    public static ArrayList<country> handle_GDP_Update(ArrayList<country> countries, String Table_Name) {
        return handle_Asset_Update(countries,Table_Name);
    }

    public static ArrayList<country> handle_Development_Update(ArrayList<country> countries,String Table_Name) {
        String year;
        double New_Val;
        String Country_Code;
        out.println("Enter The Country Code");
        Country_Code=sc.nextLine();
        out.println("Enter the Year which value you want to change");
        year=sc.nextLine();
        out.println("Enter the new value");
        New_Val=sc.nextDouble();sc.nextLine();
        SQL_Update.change_development(Table_Name,year,Country_Code,New_Val);
        countries=Economy_Data_Visualization.Initialize_Countries();
        return countries;
    }
    public static ArrayList<country> handle_Asset_Update(ArrayList<country> countries,String Table_Name) {
        String year;
        Long New_Val;
        String Country_Code;
        out.println("Enter The Country Code");
        Country_Code=sc.nextLine();
        out.println("Enter the Year which value you want to change");
        year=sc.nextLine();
        out.println("Enter the new value");
        New_Val=sc.nextLong();sc.nextLine();
        SQL_Update.change_asset(Table_Name,year,Country_Code,New_Val);
        countries=Economy_Data_Visualization.Initialize_Countries();
        return countries;
    }
}
