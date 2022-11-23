import java.util.ArrayList;

import Assets_Indicators.GDP;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;


public class LineChart_gdp extends JFrame {

    public LineChart_gdp(String applicationTitle , String chartTitle , String code, char e_or_i, int start , int end, ArrayList<country> c) {
        super(applicationTitle);
        String s1 =  Integer.toString(start);
        String s2 =    Integer.toString(end);
        JFreeChart lineChart = ChartFactory.createLineChart(
                chartTitle,
                "years from " + s1 + " to " +s2,"value",
                createDataset(code, e_or_i, start , end,c),
                PlotOrientation.VERTICAL,
                true,true,false);

        ChartPanel chartPanel = new ChartPanel( lineChart);
        chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
        setContentPane( chartPanel );
    }

    private DefaultCategoryDataset createDataset(String cod, char e_or_i,int start , int end,ArrayList<country> c ) {

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
        ArrayList<Double> a1 = new ArrayList<>();
//ArrayList<GDP> gd = new ArrayList<>();



        if(e_or_i == 'e') {

            for(int f=0;f<c.get(i).gdps.size();f++)
            {
                if(c.get(i).gdps.get(f).getyear() <= end && c.get(i).gdps.get(f).getyear()>= start)
                {
                    a1.add(c.get(i).gdps.get(f).export_percentage);
                }
            }
        }
        else if(e_or_i == 'i'){
            for(int f=0;f<c.get(i).gdps.size();f++)
            {
                if(c.get(i).gdps.get(f).getyear() <= end && c.get(i).gdps.get(f).getyear()>= start)
                {
                    a1.add(c.get(i).gdps.get(f).import_percentage);
                }
            }
        }
        else {
            for(int f=0;f<c.get(i).gdps.size();f++)
            {
                if(c.get(i).gdps.get(f).getyear() <= end && c.get(i).gdps.get(f).getyear()>= start)
                {
                    a1.add(c.get(i).gdps.get(f).TAX_revenue_percentage);
                }
            }
        }
//System.out.println(a1.size());
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
