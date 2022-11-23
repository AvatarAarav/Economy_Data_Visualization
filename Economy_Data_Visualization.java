import Assets_Indicators.*;
import Database_Functions.*;
import Development_Indicators.*;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.*;


public class Economy_Data_Visualization {
        static ArrayList<country> Countries = new ArrayList<country>();
        static SQL_Acc acc=new SQL_Acc();
        static Scanner sc=new Scanner(in);

        public static void print_Indicators(){
            out.println("1-> Gross Domestic Product(i.e. The total monetary value generated by a country in a year)");
            out.println("2-> Population");
            out.println("3-> Total Reserves(Monetary Gold and IMF reserves of the Country)");
            out.println("4-> Consumer Price Index(i.e. A measure of change of prices in past years)");
            out.println("5-> Deposit Interest Rate(i.e. Rate paid by banks to their customers)");
            out.println("6-> Exchange Rate(i.e. Strength of Currency of a nation against US Dollar)");
            out.println("7-> Import Percentage of GDP(i.e. How much percentage of GDP is spent on Importing Goods)");
            out.println("8-> Export Percentage of GDP(i.e. How much percentage of GDP is spent on Exporting Goods)");
            out.println("9-> Tax Revenue Percentage(Funds collected from Imports)");

            out.println("Any else key will go back");
        }
        static void print_Menu(){
            out.println("Menu:--->");
            out.println("1-> Plot Specific Country Data");
            out.println("2-> Compare Countries");
            out.println("3-> Update Country Data");
            out.println("4-> Delete Country Data");
            out.println("5-> Get Country Data by Country Name");
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
    public static ArrayList<country> Initialize_Countries(){
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
        return Countries;
    }
    public static void main(String[] args)
    {
        out.println("<----Hello, Welcome to the Economy Data Visualization Software----->");
        int input=1;
        if(!SQLDataRegistrar.doesDBexists(acc.dbName)){
            out.println("Database does not exist,\n Don't Worry, We will create one right now!");
            SQLDataRegistrar.main(new String[]{""});
        }
        else{
            out.println("Database Exists!!!,\n1->Do you want to update it on the basis of CSV files\n2->Or you want to use the old database. ");
            input=take_input();
            while (input!=1 && input!=2){
                out.println("Wrong Input!! Try again");
                input=take_input();
            }
            if(input==1){
                SQLDataRegistrar.main(new String[]{""});
            }
        }
        //Initializing Countries Array
        ArrayList<country> Countries=Initialize_Countries();

        while (input!=0){
            print_Menu();
            input=take_input();
            while(input>5 || input<0){
                out.println("Wrong Input!!!! Try Again");
                input=take_input();
            }
            switch (input){
                case 1:
                    Country_Plot(Countries);
                    continue;
                case 2:
                    ComparePlot(Countries);
                    continue;
                case 3:
                    Countries=Update_Data(Countries);
                    continue;
                case 4:
                    continue;
                case 5:
                    searchCountry(Countries);
                    continue;
                default:
            }
        }
        out.print("\n\n Thanks for using our Visualization Software :)");
    }

    private static void searchCountry(ArrayList<country> countries) {
        String Country_Name;
        out.println("Enter the Country Name:");
        Country_Name=sc.nextLine();
        out.println("Similar records:");
        for(country i:countries){
            if(i.name.toLowerCase().contains(Country_Name.toLowerCase())){
                out.println("Name:"+i.name);
                out.println("Code:"+i.code);
                out.println();
            }
        }
    }

    private static ArrayList<country> Update_Data(ArrayList<country> countries ) {
        print_Menu3();
        int input=take_input();
        while(input>9 || input<0){
            out.println("Wrong Input!!!! Try Again");
            input=take_input();
        }
        switch (input){
            case 1: countries=handle_Asset_Update(countries,"GDP");break;
            case 2: countries=handle_Asset_Update(countries,"Population");break;
            case 3: countries=handle_Asset_Update(countries,"Reserves");break;
            case 4: countries=handle_Development_Update(countries,"consumer_price_index");break;
            case 5: countries=handle_Development_Update(countries,"deposit_interest_rate");break;
            case 6: countries=handle_Development_Update(countries,"exchange_rate");break;
            case 7:
            case 8:
            case 9:
        }
        return countries;
    }

    private static ArrayList<country> handle_Development_Update(ArrayList<country> countries,String Table_Name) {
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
        countries=Initialize_Countries();
        return countries;
    }
    private static ArrayList<country> handle_Asset_Update(ArrayList<country> countries,String Table_Name) {
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
        countries=Initialize_Countries();
        return countries;
    }

    private static void ComparePlot(ArrayList<country> countries) {
        print_Menu2();
        int input=take_input();
        while(input>9 || input<0){
            out.println("Wrong Input!!!! Try Again");
            input=take_input();
        }
        switch (input) {
            case 1 -> Plot_Chart.compare_Bar(countries, new GDP());
            case 2 -> Plot_Chart.compare_Bar(countries, new Population());
            case 3 -> Plot_Chart.compare_Bar(countries, new Reserves());
            case 4 -> Plot_Chart.compare_line(countries, new CPI());
            case 5 -> Plot_Chart.compare_line(countries, new Deposit_Interest_Rate());
            case 6 -> Plot_Chart.compare_line(countries, new Exchange_Rate());
            case 7 -> Plot_Chart.compare_line_gdp(countries, "Export");
            case 8 -> Plot_Chart.compare_line_gdp(countries, "Import");
            case 9 -> Plot_Chart.compare_line_gdp(countries, "Tax");
            default -> {
            }
        }
    }

    private static void Country_Plot(ArrayList<country> countries) {
        print_Menu1();
        int input=take_input();
        while(input>9 || input<0){
            out.println("Wrong Input!!!! Try Again");
            input=take_input();
        }
        switch (input) {
            case 1 -> Plot_Chart.plot_bar(countries, new GDP());
            case 2 -> Plot_Chart.plot_bar(countries, new Population());
            case 3 -> Plot_Chart.plot_bar(countries, new Reserves());
            case 4 -> Plot_Chart.plot_line(countries, new CPI());
            case 5 -> Plot_Chart.plot_line(countries, new Deposit_Interest_Rate());
            case 6 -> Plot_Chart.plot_line(countries, new Exchange_Rate());
            case 7 -> Plot_Chart.plot_lineGDP(countries, "Export");
            case 8 -> Plot_Chart.plot_lineGDP(countries, "Import");
            case 9 -> Plot_Chart.plot_lineGDP(countries, "Tax");
        }
    }

    private static int take_input() {
            out.print("Enter Your Choice:");
            if(sc.hasNextInt()){
                int d=sc.nextInt();
                sc.nextLine();
                return d;
            }
            else{
                out.println("Please Enter only Integer Values!!!!!!!!!!!!");
                return -100;
            }
    }
}
