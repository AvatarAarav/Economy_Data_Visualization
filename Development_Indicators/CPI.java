package Development_Indicators;

public class CPI extends Development_Indicators{
   public  CPI(double value , int year){
        this.value = value;
        this.year = year;

    }
    public CPI(){
        this(0 , 0);
    }
    public double calculateInflation(){
        int A = 100 ;// AS a reference at 2010 we are taking A = 100
        double temp1 = this.year -A;
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

    @Override
    public String toString() {
        return "CPI";
    }

}
