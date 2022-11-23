import java.util.ArrayList;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;


public class LineChart_compare_gdp extends JFrame {

    public LineChart_compare_gdp(String applicationTitle , String chartTitle , String code1, String code2, int start , int end, char ch, ArrayList<country> c) {
        super(applicationTitle);
        String s1 =  Integer.toString(start);
        String s2 =    Integer.toString(end);
        JFreeChart lineChart = ChartFactory.createLineChart(
                chartTitle,
                "years from " + s1 + " to " +s2,"value",
                createDataset(code1,code2,  start , end, ch,c),
                PlotOrientation.VERTICAL,
                true,true,false);

        ChartPanel chartPanel = new ChartPanel( lineChart);
        chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
        setContentPane( chartPanel );
    }

    private DefaultCategoryDataset createDataset(String cod,String cod2, int start , int end, char ch,ArrayList<country> c ) {

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
        ArrayList<Double> a1 = new ArrayList<>();
        ArrayList<Double> b1 = new ArrayList<>();

if(ch == 'e')
{
    for (int h = 0; h < c.get(i).gdps.size(); h++) {
        a1.add(c.get(i).gdps.get(h).export_percentage);

    }
    for (int h = 0; h < c.get(j).gdps.size(); h++) {
        b1.add(c.get(j).gdps.get(h).export_percentage);

    }

}
else if (ch == 'i')
{
    for (int h = 0; h < c.get(i).gdps.size(); h++) {
        a1.add(c.get(i).gdps.get(h).import_percentage);

    }
    for (int h = 0; h < c.get(j).gdps.size(); h++) {
        b1.add(c.get(j).gdps.get(h).import_percentage);

    }
}
else
{
    for (int h = 0; h < c.get(i).gdps.size(); h++) {
        a1.add(c.get(i).gdps.get(h).TAX_revenue_percentage);

    }
    for (int h = 0; h < c.get(j).gdps.size(); h++) {
        b1.add(c.get(j).gdps.get(h).TAX_revenue_percentage);

    }
}

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