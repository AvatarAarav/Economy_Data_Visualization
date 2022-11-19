import Assets_Indicators.Assets_Indicators;
import Assets_Indicators.GDP;
import Assets_Indicators.Population;
import Assets_Indicators.Reserves;
import Development_Indicators.CPI;
import Development_Indicators.Deposit_Interest_Rate;
import Development_Indicators.Development_Indicators;
import Development_Indicators.Exchange_Rate;

import java.util.ArrayList;

class country implements search, search_assets {
    private String name;
    private String code;
    private ArrayList<Exchange_Rate> exchange_rates;
    private ArrayList<Deposit_Interest_Rate> interest_rates;
    private ArrayList<CPI> cpis;
    private ArrayList<GDP> gdps;
    private ArrayList<Reserves> res;
    private ArrayList<Population> populations;

    country(String code,String name){
        this.code=code;
        this.name=name;
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
