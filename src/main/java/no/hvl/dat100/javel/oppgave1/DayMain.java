package no.hvl.dat100.javel.oppgave1;

public class DayMain {

    public static void main(String[] args) {

        double[] powerusage_day = DayPowerData.powerusage_day;

        double[] powerprices_day = DayPowerData.powerprices_day;

        System.out.println("==============");
        System.out.println("OPPGAVE 1");
        System.out.println("==============");
        System.out.println();

        // Tests for all the methods implemented in the DailyPower class

        // test a) printPowerPrices
        System.out.println("a) Strømprisene for hele dagen:");
        DailyPower.printPowerPrices(powerprices_day);
        System.out.println();


        // test b) printPowerUsage
        System.out.println("b) Strømforbruket for hele dagen:");
        DailyPower.printPowerUsage(powerusage_day);
        System.out.println();

        // test c) computePowerUsage
        double totalUsage = DailyPower.computePowerUsage(powerusage_day);
        System.out.printf("c) Ditt strømforbruk for dagen er: %.2f kWh. \n\n", totalUsage);

        // test d) computeSpotPrice
        double spotPrice = DailyPower.computeSpotPrice(powerusage_day, powerprices_day);
        System.out.printf("d) Dette skal du betale for dagens forbruk med spotpris: %.2f kr. \n\n", spotPrice);

        // test e) privat metode, kan ikke kalles i main

        // test f) computePowerSupport
        double support = DailyPower.computePowerSupport(powerusage_day, powerprices_day);
        System.out.printf("f) Dette får du i stromsøtte for dagens strømforbruk: %.2f kr. \n\n", support);

        // test g) computeNorgesPrice
        double norgesPrice = DailyPower.computeNorgesPrice(powerusage_day);
        System.out.printf("g) Dette skal du betale for dagens strømforbruk med Norges pris: %.2f kr. \n\n", norgesPrice);

        // test h) findPeakUsage
        double peak = DailyPower.findPeakUsage(powerusage_day);
        System.out.printf("h) Høyeste time-forbruk denne dagen: %.2f kWh.\n\n", peak);

        // test i) findAvgPower
        double avg = DailyPower.findAvgPower(powerusage_day);
        System.out.printf("i) Ditt gjennomsnittlig strømforbruk denne dagen (per time): %.2f kWh.\n", avg);
    }
}