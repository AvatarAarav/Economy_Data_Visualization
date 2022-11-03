package Development_Indicators;

interface indicator{
    void setvalue(double val);
    void setyear(int year);

    int getyear();
    double getvalue();
}

abstract class Development_Indicators implements indicator{
    protected double value;
    protected int year;

    @override
    public double getvalue(){
        return this.value;
    }
    @override
    public int getyear(){
        return this.year;
    }


}
class Exchange_Rate extends Development_Indicators {
    Exchange_Rate(double value , int year){
        this.value = value;
        this.year = year;

    }
    Exchange_Rate(){
        this(0 , 0);
    }

    @Override
    public void setvalue(double value) {
        this.value = value;
    }

    @Override
    public void setyear(int year) {
        this.year = year;
    }
}
class Deposit_Interest_Rate extends Development_Indicators{
    Deposit_Interest_Rate(double value , int year){
        this.value = value;
        this.year = year;

    }
    Deposit_Interest_Rate(){
        this(0 , 0);
    }
    @Override
    public void setvalue(double value) {
        this.value = value;
    }

    @Override
    public void setyear(int year) {
        this.year = year;
    }
}

class CPI extends Development_Indicators{
   CPI(double value , int year){
        this.value = value;
        this.year = year;

    }
    CPI(){
        this(0 , 0);
    }
    public double calculateInflation(int B){
       int A = 100 ;// AS a reference at 2010 we are taking A = 100
        double temp1 = B-A;
        double temp2 = A;
        double temp = temp1/temp2;
        double inflationRate = temp * 100;

        return inflationRate;
    }
    @Override
    public void setvalue(double value) {
        this.value = value;
    }

    @Override
    public void setyear(int year) {
        this.year = year;
    }

}