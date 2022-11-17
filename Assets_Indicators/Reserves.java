package Development_Indicators;

public class Reserves extends Assets_Indicators {


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

