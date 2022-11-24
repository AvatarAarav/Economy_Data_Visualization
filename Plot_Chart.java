import Assets_Indicators.*;
import Development_Indicators.Development_Indicators;
import org.jfree.ui.RefineryUtilities;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;


public class Plot_Chart {
    static Scanner sc=new Scanner(in);
    static void plot_line(ArrayList<country> Countries, Development_Indicators parameter){
        String Country_Code;
        System.out.print("Please Enter the Country Code:");
        Country_Code=sc.nextLine();
        Country_Code=Country_Code.toUpperCase();
        while (!Economy_Data_Visualization.check_country_code(Country_Code)){
            out.println("Wrong!! Country Code");
            out.print("Enter the Country Code:");
            Country_Code=sc.nextLine();
        }
        System.out.print("Enter Start Year(>1960):");
        while(!sc.hasNextInt()){
            sc.nextLine();
            out.println("Enter only Integer!!!!");
            System.out.print("Enter Start Year(>1960):");
        }
        int start=sc.nextInt();sc.nextLine();
        while(start<1960 || start>2021){
            System.out.println("Error!!! Wrong Input Please enter within range");
            System.out.print("Enter Start Year(>1960):");
            start=sc.nextInt();sc.nextLine();
        }
        System.out.print("Enter End Year(<2021):");
        while(!sc.hasNextInt()){
            sc.nextLine();
            out.println("Enter only Integer!!!!");
            System.out.print("Enter End Year(<2021):");
        }
        int end= sc.nextInt();sc.nextLine();
        while (end>2021 || end<1960){
            System.out.println("Error!!! Wrong Input Please enter within range");
            System.out.print("Enter End Year(<2021):");
            end= sc.nextInt();sc.nextLine();
        }
        String Parameter_Name=parameter.toString();
        LineChart_Development_indicators chart = new LineChart_Development_indicators(
                "Economy data visualization" ,
                Parameter_Name+" vs years",Country_Code,start,end,parameter,Countries);
        chart.pack( );
        RefineryUtilities.centerFrameOnScreen( chart );
        chart.setVisible( true );

    }
    static void plot_bar(ArrayList<country> Countries, Assets_Indicators parameter){
        String Country_Code;
        System.out.print("Please Enter the Country Code:");
        Country_Code=sc.nextLine();
        Country_Code=Country_Code.toUpperCase();
        while (!Economy_Data_Visualization.check_country_code(Country_Code)){
            out.println("Wrong!! Country Code");
            out.print("Enter the Country Code:");
            Country_Code=sc.nextLine();
        }
        System.out.print("Enter Start Year(>1960):");
        while(!sc.hasNextInt()){
            sc.nextLine();
            out.println("Enter only Integer!!!!");
            System.out.print("Enter Start Year(>1960):");
        }
        int start=sc.nextInt();sc.nextLine();
        while(start<1960 || start>2021){
            System.out.println("Error!!! Wrong Input Please enter within range");
            System.out.print("Enter Start Year(>1960):");
            start=sc.nextInt();sc.nextLine();
        }
        System.out.print("Enter End Year(<2021):");
        while(!sc.hasNextInt()){
            sc.nextLine();
            out.println("Enter only Integer!!!!");
            System.out.print("Enter End Year(<2021):");
        }
        int end= sc.nextInt();sc.nextLine();
        while (end>2021 || end<1960){
            System.out.println("Error!!! Wrong Input Please enter within range");
            System.out.print("Enter End Year(<2021):");
            end= sc.nextInt();sc.nextLine();
        }
        String Parameter_Name=parameter.toString();
        Bar_Chart_Assets_Indicators chart = new Bar_Chart_Assets_Indicators(
                "Economy data visualization" ,
                Parameter_Name+" vs years",Country_Code,start,end,parameter,Countries);
        chart.pack( );
        RefineryUtilities.centerFrameOnScreen( chart );
        chart.setVisible( true );
    }
    static void compare_Bar(ArrayList<country> Countries, Assets_Indicators parameter){
        String Country_Code1,Country_Code2;
        System.out.print("Please Enter the first Country Code:");
        Country_Code1=sc.nextLine();
        Country_Code1=Country_Code1.toUpperCase();
        while (!Economy_Data_Visualization.check_country_code(Country_Code1)){
            out.println("Wrong!! Country Code");
            out.print("Enter the Country Code:");
            Country_Code1=sc.nextLine();
        }
        System.out.print("Please Enter the second Country Code:");
        Country_Code2=sc.nextLine();
        Country_Code2=Country_Code2.toUpperCase();
        while (!Economy_Data_Visualization.check_country_code(Country_Code2)){
            out.println("Wrong!! Country Code");
            out.print("Enter the Country Code:");
            Country_Code2=sc.nextLine();
        }
        System.out.print("Enter Start Year(>1960):");
        while(!sc.hasNextInt()){
            sc.nextLine();
            out.println("Enter only Integer!!!!");
            System.out.print("Enter Start Year(>1960):");
        }
        int start=sc.nextInt();sc.nextLine();
        while(start<1960 || start>2021){
            System.out.println("Error!!! Wrong Input Please enter within range");
            System.out.print("Enter Start Year(>1960):");
            start=sc.nextInt();sc.nextLine();
        }
        System.out.print("Enter End Year(<2021):");
        while(!sc.hasNextInt()){
            sc.nextLine();
            out.println("Enter only Integer!!!!");
            System.out.print("Enter End Year(<2021):");
        }
        int end= sc.nextInt();sc.nextLine();
        while (end>2021 || end<1960){
            System.out.println("Error!!! Wrong Input Please enter within range");
            System.out.print("Enter End Year(<2021):");
            end= sc.nextInt();sc.nextLine();
        }
        String Parameter_Name=parameter.toString();
        Barchart_compare chart = new Barchart_compare(
                "Economy data visualization" ,
                Parameter_Name+" vs years",Country_Code1,Country_Code2,start,end,parameter,Countries);

        chart.pack( );
        RefineryUtilities.centerFrameOnScreen( chart );
        chart.setVisible( true );
    }
    static void compare_line(ArrayList<country> Countries, Development_Indicators parameter){
        String Country_Code1,Country_Code2;
        System.out.print("Please Enter the first Country Code:");
        Country_Code1=sc.nextLine();
        Country_Code1=Country_Code1.toUpperCase();
        while (!Economy_Data_Visualization.check_country_code(Country_Code1)){
            out.println("Wrong!! Country Code");
            out.print("Enter the Country Code:");
            Country_Code1=sc.nextLine();
        }
        System.out.print("Please Enter the second Country Code:");
        Country_Code2=sc.nextLine();
        Country_Code2=Country_Code2.toUpperCase();
        while (!Economy_Data_Visualization.check_country_code(Country_Code2)){
            out.println("Wrong!! Country Code");
            out.print("Enter the Country Code:");
            Country_Code2=sc.nextLine();
        }
        System.out.print("Enter Start Year(>1960):");
        while(!sc.hasNextInt()){
            sc.nextLine();
            out.println("Enter only Integer!!!!");
            System.out.print("Enter Start Year(>1960):");
        }
        int start=sc.nextInt();sc.nextLine();
        while(start<1960 || start>2021){
            System.out.println("Error!!! Wrong Input Please enter within range");
            System.out.print("Enter Start Year(>1960):");
            start=sc.nextInt();sc.nextLine();
        }
        System.out.print("Enter End Year(<2021):");
        while(!sc.hasNextInt()){
            sc.nextLine();
            out.println("Enter only Integer!!!!");
            System.out.print("Enter End Year(<2021):");
        }
        int end= sc.nextInt();sc.nextLine();
        while (end>2021 || end<1960){
            System.out.println("Error!!! Wrong Input Please enter within range");
            System.out.print("Enter End Year(<2021):");
            end= sc.nextInt();sc.nextLine();
        }
        String Parameter_Name=parameter.toString();
        LineChart_compare chart = new LineChart_compare(
                "Economy data visualization" ,
                Parameter_Name+" vs years",Country_Code1,Country_Code2,start,end,parameter,Countries);

        chart.pack( );
        RefineryUtilities.centerFrameOnScreen( chart );
        chart.setVisible( true );
    }


    static void plot_lineGDP(ArrayList<country> Countries,String str){
        String Country_Code;
        String title;
        char c;
        if(str == "Export") {
            title = "Export_percentage";
            c='e';
        }
        else if (str == "Import"){
            title = "Import_percentage";
            c='i';
        }
        else
        {
         title = "Tax_revenue";
         c='t';
        }
        System.out.print("Please Enter the Country Code:");
        Country_Code=sc.nextLine();
        Country_Code=Country_Code.toUpperCase();
        while (!Economy_Data_Visualization.check_country_code(Country_Code)){
            out.println("Wrong!! Country Code");
            out.print("Enter the Country Code:");
            Country_Code=sc.nextLine();
        }
        System.out.print("Enter Start Year(>1960):");
        while(!sc.hasNextInt()){
            sc.nextLine();
            out.println("Enter only Integer!!!!");
            System.out.print("Enter Start Year(>1960):");
        }
        int start=sc.nextInt();sc.nextLine();
        while(start<1960 || start>2021){
            System.out.println("Error!!! Wrong Input Please enter within range");
            System.out.print("Enter Start Year(>1960):");
            start=sc.nextInt();sc.nextLine();
        }
        System.out.print("Enter End Year(<2021):");
        while(!sc.hasNextInt()){
            sc.nextLine();
            out.println("Enter only Integer!!!!");
            System.out.print("Enter End Year(<2021):");
        }
        int end= sc.nextInt();sc.nextLine();
        while (end>2021 || end<1960){
            System.out.println("Error!!! Wrong Input Please enter within range");
            System.out.print("Enter End Year(<2021):");
            end= sc.nextInt();sc.nextLine();
        }
       LineChart_gdp chart = new LineChart_gdp(
                "Economy data visualization" ,title
                +" vs years",Country_Code,c,start,end,Countries);
        chart.pack( );
        RefineryUtilities.centerFrameOnScreen( chart );
        chart.setVisible( true );
    }

    static void compare_line_gdp(ArrayList<country> Countries, String str){
        String Country_Code1,Country_Code2;
        String temp;
        char c;
        if(str == "Export") {
            c='e';
            temp = "Export_percentage";
        }
        else if (str == "Import"){
            c='i';
            temp = "Import_percentage";
        }
        else {
            c='t';
            temp = "Tax_revenue";
        }

        System.out.print("Please Enter the first Country Code:");
        Country_Code1=sc.nextLine();
        Country_Code1=Country_Code1.toUpperCase();
        while (!Economy_Data_Visualization.check_country_code(Country_Code1)){
            out.println("Wrong!! Country Code");
            out.print("Enter the Country Code:");
            Country_Code1=sc.nextLine();
        }
        System.out.print("Please Enter the second Country Code:");
        Country_Code2=sc.nextLine();
        Country_Code2=Country_Code2.toUpperCase();
        while (!Economy_Data_Visualization.check_country_code(Country_Code2)){
            out.println("Wrong!! Country Code");
            out.print("Enter the Country Code:");
            Country_Code2=sc.nextLine();
        }
        System.out.print("Enter Start Year(>1960):");
        while(!sc.hasNextInt()){
            sc.nextLine();
            out.println("Enter only Integer!!!!");
            System.out.print("Enter Start Year(>1960):");
        }
        int start=sc.nextInt();sc.nextLine();
        while(start<1960 || start>2021){
            System.out.println("Error!!! Wrong Input Please enter within range");
            System.out.print("Enter Start Year(>1960):");
            start=sc.nextInt();sc.nextLine();
        }
        System.out.print("Enter End Year(<2021):");
        while(!sc.hasNextInt()){
            sc.nextLine();
            out.println("Enter only Integer!!!!");
            System.out.print("Enter End Year(<2021):");
        }
        int end= sc.nextInt();sc.nextLine();
        while (end>2021 || end<1960){
            System.out.println("Error!!! Wrong Input Please enter within range");
            System.out.print("Enter End Year(<2021):");
            end= sc.nextInt();sc.nextLine();
        }
        LineChart_compare_gdp chart = new LineChart_compare_gdp(
                "Economy data visualization" ,
                temp+" vs years",Country_Code1,Country_Code2,start,end,c,Countries);

        chart.pack( );
        RefineryUtilities.centerFrameOnScreen( chart );
        chart.setVisible( true );
    }

    }

