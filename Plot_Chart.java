import Assets_Indicators.*;
import Development_Indicators.Development_Indicators;
import org.jfree.ui.RefineryUtilities;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.in;


public class Plot_Chart {
    static Scanner sc=new Scanner(in);
    static void plot_line(ArrayList<country> Countries, Development_Indicators parameter){
        String Country_Code;
        System.out.print("Please Enter the Country Code:");
        Country_Code=sc.nextLine();
        System.out.print("Enter Start Year(>1960):");
        int start=sc.nextInt();sc.nextLine();
        System.out.print("Enter End Year(<2021):");
        String Parameter_Name=parameter.toString();
        int end= sc.nextInt();sc.nextLine();
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
        System.out.print("Enter Start Year(>1960):");
        int start=sc.nextInt();sc.nextLine();
        System.out.print("Enter End Year(<2021):");
        String Parameter_Name=parameter.toString();
        int end= sc.nextInt();sc.nextLine();
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
        System.out.print("Please Enter the second Country Code:");
        Country_Code2=sc.nextLine();
        System.out.print("Enter Start Year(>1960):");
        int start=sc.nextInt();sc.nextLine();
        System.out.print("Enter End Year(<2021):");
        String Parameter_Name=parameter.toString();
        int end= sc.nextInt();sc.nextLine();
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
        System.out.print("Please Enter the second Country Code:");
        Country_Code2=sc.nextLine();
        System.out.print("Enter Start Year(>1960):");
        int start=sc.nextInt();sc.nextLine();
        System.out.print("Enter End Year(<2021):");
        String Parameter_Name=parameter.toString();
        int end= sc.nextInt();sc.nextLine();
        LineChart_compare chart = new LineChart_compare(
                "Economy data visualization" ,
                Parameter_Name+" vs years",Country_Code1,Country_Code2,start,end,parameter,Countries);

        chart.pack( );
        RefineryUtilities.centerFrameOnScreen( chart );
        chart.setVisible( true );
    }


    static void plot_line_exp_imp(ArrayList<country> Countries, char c){
        String Country_Code;
        String temp;
        if(c == 'e')
        {
            temp = "export_percentage";
        }
        else if (c == 'i'){
            temp = "import_percentage";
        }
        else
        {
         temp = "Tax_revenue";
        }
        System.out.print("Please Enter the Country Code:");
        Country_Code=sc.nextLine();
        System.out.print("Enter Start Year(>1960):");
        int start=sc.nextInt();sc.nextLine();
        System.out.print("Enter End Year(<2021):");

        int end= sc.nextInt();sc.nextLine();
       LineChart_export_per chart = new LineChart_export_per(
                "Economy data visualization" ,temp
                +" vs years",Country_Code,c,start,end,Countries);
        chart.pack( );
        RefineryUtilities.centerFrameOnScreen( chart );
        chart.setVisible( true );

    }

    static void compare_line_imp_exp(ArrayList<country> Countries, char c){
        String Country_Code1,Country_Code2;
String temp;
        if(c == 'e')
        {
            temp = "export_percentage";
        }
        else if (c == 'i'){
            temp = "import_percentage";
        }
        else
        {
            temp = "Tax_revenue";
        }

        System.out.print("Please Enter the first Country Code:");
        Country_Code1=sc.nextLine();
        System.out.print("Please Enter the second Country Code:");
        Country_Code2=sc.nextLine();
        System.out.print("Enter Start Year(>1960):");
        int start=sc.nextInt();sc.nextLine();
        System.out.print("Enter End Year(<2021):");

        int end= sc.nextInt();sc.nextLine();
        LineChart_compare_exp_imp chart = new LineChart_compare_exp_imp(
                "Economy data visualization" ,
                temp+" vs years",Country_Code1,Country_Code2,start,end,c,Countries);

        chart.pack( );
        RefineryUtilities.centerFrameOnScreen( chart );
        chart.setVisible( true );
    }

    }

