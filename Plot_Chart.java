import Assets_Indicators.*;
import org.jfree.ui.RefineryUtilities;

import java.util.ArrayList;

public class Plot_Chart {
    static void plot_line(){

    }
    static void plot_bar(ArrayList<country> Countries){
        Bar_Chart_Assets_Indicators chart = new Bar_Chart_Assets_Indicators(
                "Economy data visualization" ,
                "change in value vs years","USA",2000,2021,new GDP(),Countries);

        chart.pack( );
        RefineryUtilities.centerFrameOnScreen( chart );
        chart.setVisible( true );
    }
}
