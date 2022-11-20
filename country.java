import Assets_Indicators.*;
import Development_Indicators.*;

import java.util.ArrayList;

class country implements search, search_assets {
    private String name;
    private String code;
    private ArrayList<Exchange_Rate> exchange_rates=new ArrayList<>();
    private ArrayList<Deposit_Interest_Rate> interest_rates=new ArrayList<>();
    private ArrayList<CPI> cpis=new ArrayList<>();
    private ArrayList<GDP> gdps=new ArrayList<>();
    private ArrayList<Reserves> res=new ArrayList<>();
    private ArrayList<Population> populations=new ArrayList<>();

    country(String code,String name){
        this.code=code;
        this.name=name;
        Object[] o1 = SQLDataExtractor.getData_CountryWise("Exchange_Rate" , code);
        int start = 1960;
        for(int i=0;i<o1.length; i++){
            Exchange_Rate r = new Exchange_Rate((Double) o1[i], start);
            exchange_rates.add(r);
            start++;
        }
        Object[] o2 = SQLDataExtractor.getData_CountryWise("Deposit_Interest_Rate" , code);
         start = 1960;
        for(int i=0;i<o2.length; i++){
            Deposit_Interest_Rate t = new Deposit_Interest_Rate((Double) o2[i], start);
            interest_rates.add(t);
            start++;
        }
        Object[] o3 = SQLDataExtractor.getData_CountryWise("consumer_price_index" , code);
        start = 1960;
        for(int i=0;i<o3.length; i++){
             CPI s = new CPI((Double) o3[i], start);
            cpis.add(s);
            start++;
        }

        Object[] o4 = SQLDataExtractor.getData_CountryWise("gdp" , code);
        start = 1960;
        Object[] o5 = SQLDataExtractor.getData_CountryWise("import_per" , code);
        Object[] o6 = SQLDataExtractor.getData_CountryWise("export_per" , code);
        Object[] o7 = SQLDataExtractor.getData_CountryWise("tax" , code);


        for(int i=0;i<o4.length; i++){
            long k = Long.parseLong(""+o4[i]);
            GDP u = new GDP(k, "$" ,start , (Double)o5[i] , (Double) o6[i] , (Double) o7[i] );
            gdps.add(u);
            start++;
        }
        Object[] o8 = SQLDataExtractor.getData_CountryWise("reserves" , code);
        start = 1960;
        for(int i=0;i<o8.length; i++){
            Reserves v = new Reserves((Long) o8[i], start);
            res.add(v);
            start++;
        }
        Object[] o9 = SQLDataExtractor.getData_CountryWise("population" , code);
        start = 1960;
        for(int i=0;i<o9.length; i++){
            Population w = new Population((Long) o9[i], start);
            populations.add(w);
            start++;
        }




    }

    @Override
    public <T> double searchbyYear(ArrayList<? extends Development_Indicators> arr, int year) {
        double findvalue = -1;
        for (Development_Indicators x : arr) {
            if (year == x.getyear()) {
                findvalue = x.getvalue();
                break;

            }
        }
        return -1;
    }

    @Override
    public <T> ArrayList<Double> searchbyInterval(ArrayList<? extends Development_Indicators> arr, int a, int b) {
        ArrayList<Double> ret = new ArrayList<Double>();
        for (Development_Indicators x : arr) {
            if (x.getyear() >= a && x.getyear() <= b) {
                ret.add(x.getvalue());
            }
        }
        return ret;
    }

    @Override
    public <T> long searchbyYear_assets(ArrayList<? extends Assets_Indicators> arr, int year) {
        long findvalue = -1;
        for (Assets_Indicators x : arr) {
            if (year == x.getyear()) {
                findvalue = x.getvalue();
                break;

            }
        }
        return -1;
    }

    @Override
    public <T> ArrayList<Long> searchbyInterval_assets(ArrayList<? extends Assets_Indicators> arr, int a, int b) {
        ArrayList<Long> ret = new ArrayList<>();
        for (Assets_Indicators x : arr) {
            if (x.getyear() >= a && x.getyear() <= b) {
                ret.add(x.getvalue());
            }
        }
        return ret;
    }

    public ArrayList<Double> inflation_Difference() {
        ArrayList<Double> ret = new ArrayList<>();
        for (int i = 1; i < cpis.size(); i++) {
            CPI temp = cpis.get(i);
            CPI temp2 = cpis.get(i - 1);
            double temporary = temp.calculateInflation() - temp2.calculateInflation();
            ret.add(temporary);
        }
        return ret;
    }


}
