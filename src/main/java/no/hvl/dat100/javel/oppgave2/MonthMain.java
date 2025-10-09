package no.hvl.dat100.javel.oppgave2;

public class MonthMain {
    public static void main(String[] args) {

        double[][] power_prices_month = MonthPowerData.powerprices_month;
        double[][] power_usage_month  = MonthPowerData.powerusage_month;

        System.out.println("==============");
        System.out.println("OPPGAVE 2");
        System.out.println("==============\n");

        System.out.println("Forbruk (kWh) pr dag:");
        MonthlyPower.print_PowerUsage(power_usage_month);

        System.out.println("\nPriser (NOK/kWh) pr dag:");
        MonthlyPower.print_PowerPrices(power_prices_month);

        System.out.println("\n— Beregninger —");
        double totalUsage = MonthlyPower.computePowerUsage(power_usage_month);
        System.out.printf("Totalt månedsforbruk (kWh): %.2f%n", totalUsage);

        double spot = MonthlyPower.computeSpotPrice(power_usage_month, power_prices_month);
        System.out.printf("Total spotpris (NOK): %.2f%n", spot);

        double support = MonthlyPower.computePowerSupport(power_usage_month, power_prices_month);
        System.out.printf("Strømstøtte (NOK): %.2f%n", support);

        double norges = MonthlyPower.computeNorgesPrice(power_usage_month);
        System.out.printf("Norgespris (NOK): %.2f%n", norges);

        boolean over1000 = MonthlyPower.exceedThreshold(power_usage_month, 1000.0);
        boolean over5000 = MonthlyPower.exceedThreshold(power_usage_month, 5000.0);
        System.out.printf("Over 1000 kWh? %s%n", over1000 ? "JA" : "NEI");
        System.out.printf("Over 5000 kWh? %s%n", over5000 ? "JA" : "NEI");
    }
}
