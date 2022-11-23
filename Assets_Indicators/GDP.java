package Assets_Indicators;



public class GDP extends Assets_Indicators {

    protected static String unit;

    public double import_percentage;
    public double export_percentage;
    public double TAX_revenue_percentage;

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

    @Override
    public String toString() {
        return "GDP";
    }

}