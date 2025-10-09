package no.hvl.dat100.javel.oppgave5;


import no.hvl.dat100.javel.oppgave3.Customer;
import no.hvl.dat100.javel.oppgave2.MonthlyPower;


import java.util.Arrays;


public class Invoice {


    private Customer c; // customer associated with this invoice
    private String month; // month that the invoice covers
    private double[][] usage; // power usage this month (per day and per hour)
    private double[][] prices; // power prices for this month


    private double amount; // power price for this month




    public Invoice(Customer c, String month, double[][] usage, double[][] power_prices) {
        this.c = c;
        this.month = month;
        this.usage = usage;
        prices = power_prices;
        amount=0;





    }


    public void computeAmount() {






    }


    public void printInvoice() {


        // TODO


    }
}
