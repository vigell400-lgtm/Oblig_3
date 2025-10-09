package no.hvl.dat100.javel.oppgave1;

public class DayMain {

    public static void main(String[] args) {

        double[] powerusage_day = DayPowerData.powerusage_day;
        double[] powerprices_day = DayPowerData.powerprices_day;

        System.out.println("==============");
        System.out.println("OPPGAVE 1");
        System.out.println("==============\n");

        System.out.println("StrømFORBRUK (kWh) pr time:");
        DailyPower.printPowerUsage(powerusage_day);

        System.out.println("Spotpriser (NOK/kWh) pr time:");
        DailyPower.printPowerPrices(powerprices_day);

        System.out.println("\n— Beregninger —");
        double totalUsage = DailyPower.computePowerUsage(powerusage_day);
        System.out.printf("Total forbruk (kWh): %.2f%n", totalUsage);

        double spotPrice = DailyPower.computeSpotPrice(powerusage_day, powerprices_day);
        System.out.printf("Total pris med spot (NOK): %.2f%n", spotPrice);

        double support = DailyPower.computePowerSupport(powerusage_day, powerprices_day);
        System.out.printf("Strømstøtte (NOK): %.2f%n", support);

        double norgespris = DailyPower.computeNorgesPrice(powerusage_day);
        System.out.printf("Norgespris (NOK): %.2f%n", norgespris);

        double peak = DailyPower.findPeakUsage(powerusage_day);
        System.out.printf("Maks time-forbruk (kWh): %.2f%n", peak);

        double avg = DailyPower.findAvgPower(powerusage_day);
        System.out.printf("Gjennomsnitt/time (kWh): %.2f%n", avg);
    }
}

