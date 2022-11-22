package Assets_Indicators;

interface Development{
    void setyear(int year);
    void setvalue(long value);

    long getvalue();
    int getyear();

}

public abstract class Assets_Indicators implements Development {
    protected long value ;
    protected int year;

    @Override
    public long getvalue(){
        return this.value;
    }
    @Override
    public int getyear(){
        return this.year;
    }



}
