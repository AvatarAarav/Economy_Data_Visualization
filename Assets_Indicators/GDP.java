package Assets_Indicators;



public class GDP extends Assets_Indicators {

    protected static String unit;

    protected double import_percentage;
    protected double export_percentage;
    protected double TAX_revenue_percentage;

    public GDP(long value ,String unit , int year , double imp ,  double export ,double tax ){
        this.value = value ;
        this.TAX_revenue_percentage = tax;
        this.unit = unit;
        this.import_percentage = imp;
        this.export_percentage = export;
        this.year = year;


    }
    public GDP(){
        this(0,"",0,0 , 0 ,0);
    }

    @Override
    public void setyear(int year) {
        this.year = year;
    }

    @Override
    public void setvalue(long value) {
        this.value = value;
    }

}