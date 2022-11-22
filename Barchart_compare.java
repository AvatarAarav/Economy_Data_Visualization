
import Assets_Indicators.*;

import Development_Indicators.*;
import java.util.ArrayList;
import java.util.Scanner;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import java.util.ArrayList;
import Assets_Indicators.*;

import javax.swing.*;


public class Barchart_compare extends JFrame {

    public Barchart_compare(String applicationTitle , String chartTitle , String code1,String code2, int start , int end, Assets_Indicators d,ArrayList<country> c) {
        super(applicationTitle);
        String s1 =  Integer.toString(start);
        String s2 =    Integer.toString(end);
        JFreeChart barchart = ChartFactory.createBarChart(
                chartTitle,
                "years from " + s1 + " to " +s2,"value",
                createDataset(code1,code2,  start , end, d,c),
                PlotOrientation.VERTICAL,
                true,true,false);

        ChartPanel chartPanel = new ChartPanel( barchart);
        chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
        setContentPane( chartPanel );
    }

    private DefaultCategoryDataset createDataset(String cod,String cod2, int start , int end, Assets_Indicators d,ArrayList<country> c ) {

        String pr = cod;
        String qr = cod2;
        DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
        int i ;
        for( i=0;i<c.size();i++)
        {
            if((c.get(i).code).equals(cod))
            {
                break;
            }
        }

        int j;
        for(j=0;j<c.size();j++)
        {
            if((c.get(j).code).equals(cod2))
            {
                break;
            }
        }
        ArrayList<? extends  Assets_Indicators> temp = new ArrayList<>();
        ArrayList<? extends  Assets_Indicators> temp2 = new ArrayList<>();
        if(d instanceof GDP)
        {
            temp = c.get(i).gdps;
            temp2 = c.get(j).gdps;
        }
        if(d instanceof  Population)
        {
            temp = c.get(i).populations;
            temp2 = c.get(j).populations;
        }
        if(d instanceof  Reserves)
        {
            temp = c.get(i).res;
            temp2 = c.get(j).res;
        }

        ArrayList<Long> a1 =   c.get(i).searchbyInterval_assets(temp,start,end);
        ArrayList<Long> b1 = c.get(j).searchbyInterval_assets(temp2,start,end);
        int w = start;
        for(int p=0;p< a1.size();p++)
        {
            String s1 =  Integer.toString(w);
            double r = a1.get(p);
            dataset.addValue(r,pr,s1);
            w++;

        }
        int jj = start;
        for(int v = 0;v < b1.size();v++)
        {
            String s1=  Integer.toString(jj);
            double r= b1.get(v);
            dataset.addValue(r,qr,s1);
            jj++;
        }


        return dataset;
    }


}