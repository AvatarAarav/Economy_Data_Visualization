package Development_Indicators;

public class Exchange_Rate extends Development_Indicators {
    public  Exchange_Rate(double value , int year){
        this.value = value;
        this.year = year;

    }
    public Exchange_Rate(){
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
        return "Exchange Rate";
    }
}

