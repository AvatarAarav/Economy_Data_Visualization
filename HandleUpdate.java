import Database_Functions.*;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.out;

public class HandleUpdate {
    static Scanner sc=new Scanner(System.in);
    public static ArrayList<country> handle_GDP_Update(ArrayList<country> countries, String Table_Name) {
        return handle_Asset_Update(countries,Table_Name);
    }

    public static ArrayList<country> handle_Development_Update(ArrayList<country> countries,String Table_Name) {
        int year;
        double New_Val;
        String Country_Code;
        out.println("Enter The Country Code");
        Country_Code=sc.nextLine();
        while (!Economy_Data_Visualization.check_country_code(Country_Code)){
            out.println("Wrong!! Country Code");
            out.print("Enter the Country Code:");
            Country_Code=sc.nextLine();
        }
        out.println("Enter the Year which value you want to change");
        while(!sc.hasNextInt()){
            out.println("Enter the correct data type!!");
            sc.nextLine();
            out.println("Enter the Year which value you want to change");
        }
        year=sc.nextInt();
        if(year<1960 || year>2021){
            out.println("Enter Correct Year!!");
            out.println("Enter the Year which value you want to change");
            year=sc.nextInt();
        }
        out.println("Enter the new value");
        while(!sc.hasNextDouble()){
            out.println("Enter the correct data type!!");
            sc.nextLine();
            out.println("Enter the new value");
        }
        New_Val=sc.nextDouble();sc.nextLine();
        SQL_Update.change_development(Table_Name,Integer.toString(year),Country_Code,New_Val);
        countries=Economy_Data_Visualization.Initialize_Countries();
        return countries;
    }
    public static ArrayList<country> handle_Asset_Update(ArrayList<country> countries,String Table_Name)
    {
        int year;
        Long New_Val;
        String Country_Code;
        out.println("Enter The Country Code");
        Country_Code=sc.nextLine();
        while (!Economy_Data_Visualization.check_country_code(Country_Code)){
            out.println("Wrong!! Country Code");
            out.print("Enter the Country Code:");
            Country_Code=sc.nextLine();
        }
        out.println("Enter the Year which value you want to change");
        while(!sc.hasNextInt()){
            out.println("Enter the correct data type!!");
            sc.nextLine();
            out.println("Enter the Year which value you want to change");
        }
        year=sc.nextInt();
        if(year<1960 || year>2021){
            out.println("Enter Correct Year!!");
            out.println("Enter the Year which value you want to change");
            year=sc.nextInt();
        }
        out.println("Enter the new value");
        while(!sc.hasNextLong()){
            out.println("Enter the correct data type!!");
            sc.nextLine();
            out.println("Enter the new value");
        }
        New_Val=sc.nextLong();sc.nextLine();
        SQL_Update.change_asset(Table_Name,Integer.toString(year),Country_Code,New_Val);
        countries=Economy_Data_Visualization.Initialize_Countries();
        return countries;
    }
    public static ArrayList<country> handle_Delete(ArrayList<country> countries,String Table_Name,String Country_Code)//throws Exception
    {
        //Class.forName("Database_Functions.DeleteJDBC");
        DeleteJDBC.delRec(Table_Name,Country_Code);
        countries=Economy_Data_Visualization.Initialize_Countries();
        return countries;
    }

}
