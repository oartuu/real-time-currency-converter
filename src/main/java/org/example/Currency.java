package org.example;

import com.google.gson.annotations.SerializedName;

public class Currency {

    @SerializedName("time_last_update_utc")
    private String updateDate;
    @SerializedName("conversion_rates")
    private Currencies currencies;

    public String getUpdateDate() {
        return updateDate;
    }

    public Currencies getCurrencies() {
        return currencies;
    }

    public double brlToEur(double amount) {
        return (amount * (currencies.euro/currencies.real));
    }

    public double eurToBrl(double amount){
        return (amount * (currencies.real/currencies.euro));
    }

    public double brlToUsd(double amount){
        return(amount * (currencies.dollar/currencies.real));
    }

    public double usdToBrl(double amount){
        return(amount * (currencies.real/currencies.dollar));
    }

    public double eurToUsd(double amount){
        return(amount * (currencies.dollar/currencies.euro));
    }

    public double usdToEur(double amount){
        return(amount * (currencies.euro/currencies.dollar));
    }

    public static class Currencies {
        @SerializedName("USD")
        private double dollar;
        @SerializedName("EUR")
        private double euro;
        @SerializedName("CAD")
        private double cadDollar;
        @SerializedName("BRL")
        private double real;

        public double getReal() {
            return real;
        }

        public double getCadDollar() {
            return cadDollar;
        }

        public double getEuro() {
            return euro;
        }

        public double getDollar() {
            return dollar;
        }
    }
}

