package Development_Indicators;

public class Population extends Assets_Indicators {


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

