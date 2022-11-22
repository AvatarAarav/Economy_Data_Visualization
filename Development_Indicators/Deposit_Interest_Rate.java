package Development_Indicators;

public class Deposit_Interest_Rate extends Development_Indicators{
    public Deposit_Interest_Rate(double value , int year){
        this.value = value;
        this.year = year;

    }
    public Deposit_Interest_Rate(){
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
    @Override
    public String toString() {
        return "Deposit Interest Rate";
    }
}
