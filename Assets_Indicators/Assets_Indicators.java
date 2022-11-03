package Assets_Indicators;

interface Development{
    void setyear(int year);
    void setvalue(long value);

    long getvalue();
    int getyear();

}

abstract class Assets_Indicators implements Development{
    protected long value ;
    protected int year;

    @override
    public long getvalue(){
        return this.value;
    }
    @override
    public int getyear(){
        return this.year;
    }

}
class GDP extends Assets_Indicators{

    protected static String unit;

    protected double import_percentage;
    protected double export_percentage;
    protected double TAX_revenue_percentage;

    GDP(long value ,String unit , int year , double imp ,  double export ,double tax ){
        this.value = value ;
        this.TAX_revenue_percentage = tax;
        this.unit = unit;
        this.import_percentage = imp;
        this.export_percentage = export;
        this.year = year;


    }
    GDP(){
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
class Reserves extends Assets_Indicators{


    Reserves(long val , int year){
        this.value = val;
        this.year = year;
    }
    Reserves(){
        this(0 , 0);
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
class Population extends Assets_Indicators{


    Population(long val , int year){
        this.value = val;
        this.year = year;
    }
    Population(){
        this(0 , 0);
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

