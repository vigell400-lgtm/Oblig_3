package no.hvl.dat100.javel.oppgave5;

import no.hvl.dat100.javel.oppgave2.MonthPowerData; // priser for måneden
import no.hvl.dat100.javel.oppgave3.Customer;
import no.hvl.dat100.javel.oppgave3.PowerAgreementType;

public class InvoiceMain {

    public static void main(String[] args) {

        System.out.println("==============");
        System.out.println("OPPGAVE 5");
        System.out.println("==============");
        System.out.println();

        // Tre kunder med ulike avtaler
        Customer k1 = new Customer("Charlie Rose", "charlie@example.com", 1003, PowerAgreementType.POWERSUPPORT);
        Customer k2 = new Customer("Diana Prince", "diana@example.com",   1004, PowerAgreementType.NORGESPRICE);
        Customer k3 = new Customer("Ethan Hunt",   "ethan@example.com",   1005, PowerAgreementType.SPOTPRICE);

        // Priser for måneden (oppg. 2)
        double[][] prices = MonthPowerData.powerprices_month;

        // Forbruk per kunde (oppg. 5)
        double[][] usage1 = CustomerPowerUsageData.usage_month_customer1; // k1
        double[][] usage2 = CustomerPowerUsageData.usage_month_customer2; // k2
        double[][] usage3 = CustomerPowerUsageData.usage_month_customer3; // k3

        // Lag fakturaer for "January"
        Invoice i1 = new Invoice(k1, "January", usage1, prices);
        Invoice i2 = new Invoice(k2, "January", usage2, prices);
        Invoice i3 = new Invoice(k3, "January", usage3, prices);

        // Generer og skriv ut
        Invoices.processInvoices(new Invoice[] { i1, i2, i3 });
    }
}

