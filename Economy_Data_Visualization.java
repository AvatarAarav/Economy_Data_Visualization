import Assets_Indicators.*;

import Development_Indicators.*;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

interface search {
    public<T> double searchbyYear(ArrayList<? extends Development_Indicators> arr , int year);
    public<T> ArrayList<Double> searchbyInterval(ArrayList<? extends Development_Indicators> arr,int a , int b);
}

interface search_assets {
    public<T> long searchbyYear_assets(ArrayList<? extends Assets_Indicators> arr , int year);
    public<T> ArrayList<Long> searchbyInterval_assets(ArrayList<? extends Assets_Indicators> arr,int a , int b);

}


public class Economy_Data_Visualization {
        static ArrayList<country> Countries = new ArrayList<country>();
        static SQL_Acc acc=new SQL_Acc();
    public static void main(String[] args)
    {

        Scanner sc=new Scanner(in);
        out.println("<----Hello, Welcome to the Economy Data Visualization Software----->");
        if(!SQLDataRegistrar.doesDBexists(acc.dbName)){
            SQLDataRegistrar.main(new String[]{""});
        }
        //Initializing Countries Array
        ArrayList<country> Countries=new ArrayList<>();
        Object[] Countries_Names= SQLDataExtractor.getCountryInfo();
        String tempStr,C_Code,C_Name;
        country tempC;
        for(Object i:Countries_Names){
            tempStr=i.toString();
            C_Code=tempStr.substring(0,3);
            C_Name=tempStr.substring(6);
            tempC=new country(C_Code,C_Name);
            Countries.add(tempC);
        }
        out.println("MENU:---->");


    }
}
