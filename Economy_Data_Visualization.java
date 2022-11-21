import Assets_Indicators.*;

import Development_Indicators.*;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.*;

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
        static Scanner sc=new Scanner(in);

        public static void print_Indicators(){
            out.println("1-> Gross Domestic Product(i.e. The total monetary value generated by a country in a year)");
            out.println("2-> Consumer Price Index(i.e. A measure of change of prices in past years)");
            out.println("3-> Deposit Interest Rate(i.e. Rate paid by banks to their customers)");
            out.println("4-> Exchange Rate(i.e. Strength of Currency of a nation against US Dollar)");
            out.println("5-> Import Percentage of GDP(i.e. How much percentage of GDP is spent on Importing Goods)");
            out.println("6-> Export Percentage of GDP(i.e. How much percentage of GDP is spent on Exporting Goods)");
            out.println("7-> Population");
            out.println("8-> Tax Revenue(Funds collected from Imports)");
            out.println("9-> Total Reserves(Monetary Gold and IMF reserves of the Country)");
            out.println("Any else key will go back");
        }
        static void print_Menu(){
            out.println("Menu:--->");
            out.println("1-> Plot Specific Country Data");
            out.println("2-> Compare Countries");
            out.println("3-> Update Country Data");
            out.println("4-> Delete Country Data");
            out.println("0-> Exit");
            out.println("Any other key will Print the Menu again");
        }
     static void print_Menu1(){
        out.println("Menu_1:--->");
        out.println("You want to Plot:::");
        Economy_Data_Visualization.print_Indicators();
    }
    static void print_Menu2(){
        out.println("Menu_2:--->");
        out.println("On the Basis of:::");
        Economy_Data_Visualization.print_Indicators();
    }
    static void print_Menu3(){
        out.println("Menu_3:--->");
        out.println("You want to change:::");
        Economy_Data_Visualization.print_Indicators();
    }

    public static void main(String[] args)
    {
        out.println("<----Hello, Welcome to the Economy Data Visualization Software----->");
        int input=-100;
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
        print_Menu();
        while (input!=0){
            input=-100;
            while(input==-100){
                input=take_input();
            }
            switch (input){
                case 1:
                    Country_Plot();
                    continue;
                case 2:
                    ComparePlot();
                    continue;
                case 3:
                    Update_Data();
                    continue;
                case 4:
                    continue;
                default:
            }
        }
        out.print("\n\n Thanks for using our Visualization Software :)");
    }

    private static void Update_Data() {
        print_Menu3();
        int input=take_input();
        switch (input){
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
        }
    }

    private static void ComparePlot() {
        print_Menu2();
        int input=take_input();
        switch (input){
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
        }
    }

    private static void Country_Plot() {
        print_Menu1();
        int input=take_input();
        switch (input){
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
        }
    }

    private static int take_input() {
            out.print("Enter Your Choice:");
            if(sc.hasNextInt()){
                return sc.nextInt();
            }
            else{
                out.println("Please Enter only Integer Values!!!!!!!!!!!!");
                return -100;
            }
    }
}
