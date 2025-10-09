package no.hvl.dat100.javel.oppgave1;

public class DailyPower {

    // a) print power prices during a day
    public static void printPowerPrices(double[] prices) {
        for (int i = 0; i < prices.length; i++) {
            System.out.printf("%.2f NOK ", prices[i]);
        }
        System.out.println(); // printer en ny linje oppå slutten
    }

    // b) print power usage during a day
    public static void printPowerUsage(double[] usage) { // vi definerer vi en metode
        for (int i = 0; i < usage.length; i++) {
            System.out.printf("%.2f kWh ", usage[i]);
        }
        System.out.println();
    }

    // c) compute power usage for a single day
    public static double computePowerUsage(double[] usage) {
        double sum = 0.0;
        for (int i = 0; i < usage.length; i++) {
            sum += usage[i];
        }
        return sum; //
    }

    // d) compute spot price for a single day
    public static double computeSpotPrice(double[] usage, double[] prices) {
        double price = 0.0;
        int n = Math.min(usage.length, prices.length);
        for (int i = 0; i < n; i++) {
            price += usage[i] * prices[i];
        }
        return price;
    }

    // e) compute power support for a given usage and price
    private static final double THRESHOLD = 0.9375; // 93,75 øre
    private static final double PERCENTAGE = 0.9;   // 90 %

    private static double getSupport(double usage, double price) {
        if (price > THRESHOLD) {
            double diff = price - THRESHOLD;
            return usage * diff * PERCENTAGE; // i NOK
        }
        return 0.0;
    }

    // f) compute power support for a single day
    public static double computePowerSupport(double[] usage, double[] prices) {
        double support = 0.0;
        int n = Math.min(usage.length, prices.length);
        for (int i = 0; i < n; i++) {
            support += getSupport(usage[i], prices[i]);
        }
        return support;
    }

    private static final double NORGESPRIS_KWH = 0.5; // 50 øre

    // g) compute norges pris for a single day
    public static double computeNorgesPrice(double[] usage) {
        double price = 0.0;
        for (int i = 0; i < usage.length; i++) {
            price += usage[i] * NORGESPRIS_KWH;
        }
        return price;
    }

    // h) compute peak usage during a single day
    public static double findPeakUsage(double[] usage) {
        double temp_max = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < usage.length; i++) {
            if (usage[i] > temp_max) {
                temp_max = usage[i];
            }
        }
        return temp_max;
    }

    // i) average hourly power usage
    public static double findAvgPower(double[] usage) {
        if (usage.length == 0) return 0.0;
        return computePowerUsage(usage) / usage.length;
    }
}
