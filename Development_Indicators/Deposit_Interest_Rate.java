package Development_Indicators;

public class Deposit_Interest_Rate extends Development_Indicators{
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
