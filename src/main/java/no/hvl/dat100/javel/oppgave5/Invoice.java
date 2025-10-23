package no.hvl.dat100.javel.oppgave5;

import no.hvl.dat100.javel.oppgave2.MonthlyPower;
import no.hvl.dat100.javel.oppgave3.Customer;
import no.hvl.dat100.javel.oppgave3.PowerAgreementType;

public class Invoice {

    private Customer c;           // customer associated with this invoice
    private String month;         // month that the invoice covers
    private double[][] usage;     // power usage this month (per day and per hour)
    private double[][] prices;    // power prices for this month
    private double amount;        // power price for this month

    // a) Konstruktør
    public Invoice(Customer c, String month, double[][] usage, double[][] power_prices) {
        this.c = c;
        this.month = month;
        this.usage = usage;
        this.prices = power_prices;
        this.amount = 0.0; // skal være 0 i konstruktør
    }

    // b) Beregne strømpris basert på avtaletype
    public void computeAmount() {
        PowerAgreementType type = c.getAgreement();
        switch (type) {
            case SPOTPRICE:
                amount = MonthlyPower.computeSpotPrice(usage, prices);
                break;
            case POWERSUPPORT: {
                double spot = MonthlyPower.computeSpotPrice(usage, prices);
                double support = MonthlyPower.computePowerSupport(usage, prices);
                amount = spot - support;
                break;
            }
            case NORGESPRICE:
                amount = MonthlyPower.computeNorgesPrice(usage);
                break;
            default:
                amount = 0.0;
        }
    }

    // c) Generere faktura
    public void printInvoice() {
        double totalUsage = MonthlyPower.computePowerUsage(usage);

        System.out.println("Customer number " + c.getCustomer_id());
        System.out.println("Name  " + c.getName());
        System.out.println("Email " + c.getEmail());
        System.out.println("Agreement " + c.getAgreement());
        System.out.println();
        System.out.println("Month: " + month);
        System.out.printf("Usage:   %10.2f kWh%n", totalUsage);
        System.out.printf("Amount:  %10.2f NOK%n", amount);
    }
}
