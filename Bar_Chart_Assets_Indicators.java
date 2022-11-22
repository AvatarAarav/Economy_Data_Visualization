
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


public class Bar_Chart_Assets_Indicators extends JFrame {

    public Bar_Chart_Assets_Indicators(String applicationTitle , String chartTitle , String code, int start , int end,Assets_Indicators d,ArrayList<country> c) {
        super(applicationTitle);
        String s1 =  Integer.toString(start);
        String s2 =    Integer.toString(end);
        JFreeChart barchart = ChartFactory.createBarChart(
                chartTitle,
                "years from " + s1 + " to " +s2,"value",
                createDataset(code,  start , end, d,c),
                PlotOrientation.VERTICAL,
                true,true,false);

        ChartPanel chartPanel = new ChartPanel( barchart);
        chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
        setContentPane( chartPanel );
    }

    private DefaultCategoryDataset createDataset(String cod, int start , int end, Assets_Indicators d,ArrayList<country> c ) {

        String pr = cod;
        //String qr = "temp2";
        DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
        int i ;
        for( i=0;i<c.size();i++)
        {
            if((c.get(i).code).equals(cod))
            {
                break;
            }
        }
        ArrayList<? extends  Assets_Indicators> temp = new ArrayList<>();
        if(d instanceof GDP)
        {
            temp = c.get(i).gdps;
        }
        if(d instanceof  Population)
        {
            temp = c.get(i).populations;
        }
        if(d instanceof  Reserves)
        {
            temp = c.get(i).res;
        }

        ArrayList<Long> a1 =   c.get(i).searchbyInterval_assets(temp,start,end);
        int w = start;
        for(int p=0;p< a1.size();p++)
        {
            String s1 =  Integer.toString(w);
            double r = a1.get(p);
            dataset.addValue(r,pr,s1);
            w++;

        }

        return dataset;
    }


}