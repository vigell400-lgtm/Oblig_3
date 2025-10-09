package no.hvl.dat100.javel.oppgave2;

public class MonthlyPower {

    // Samme støtteparametre som i oppg. 1
    private static final double THRESHOLD = 0.9375; // 93,75 øre
    private static final double PERCENTAGE = 0.90;  // 90 %
    private static final double NORGESPRIS_KWH = 0.50; // 50 øre

    // a) print power usage for a month
    public static void print_PowerUsage(double[][] usage) {
        for (int d = 0; d < usage.length; d++) {
            System.out.print("Day " + (d + 1) + ":");
            for (int h = 0; h < usage[d].length; h++) {
                System.out.printf("%.2f kWh ", usage[d][h]);
            }
            System.out.println();
        }
    }

    // b) print power prices for a month
    public static void print_PowerPrices(double[][] prices) {
        for (int d = 0; d < prices.length; d++) {
            System.out.print("Day " + (d + 1) + ":");
            for (int h = 0; h < prices[d].length; h++) {
                System.out.printf("%.2f NOK ", prices[d][h]);
            }
            System.out.println();
        }
    }

    // c) total monthly usage
    public static double computePowerUsage(double[][] usage) {
        double sum = 0.0;
        for (int d = 0; d < usage.length; d++) {
            for (int h = 0; h < usage[d].length; h++) {
                sum += usage[d][h];
            }
        }
        return sum;
    }

    // d) exceed threshold using while (avslutt tidlig når over grensen)
    public static boolean exceedThreshold(double[][] powerusage, double threshold) {
        int d = 0;
        double acc = 0.0;

        while (d < powerusage.length && acc <= threshold) {
            int h = 0;
            while (h < powerusage[d].length && acc <= threshold) {
                acc += powerusage[d][h];
                h++;
            }
            d++;
        }
        return acc > threshold;
    }

    // e) monthly spot price (uten støtte)
    public static double computeSpotPrice(double[][] usage, double[][] prices) {
        validateSameShape(usage, prices);
        double total = 0.0;
        for (int d = 0; d < usage.length; d++) {
            for (int h = 0; h < usage[d].length; h++) {
                total += usage[d][h] * prices[d][h];
            }
        }
        return total;
    }

    // f) monthly power support (støtte)
    public static double computePowerSupport(double[][] usage, double[][] prices) {
        validateSameShape(usage, prices);
        double support = 0.0;
        for (int d = 0; d < usage.length; d++) {
            for (int h = 0; h < usage[d].length; h++) {
                support += supportOneHour(usage[d][h], prices[d][h]);
            }
        }
        return support;
    }

    private static double supportOneHour(double usage, double price) {
        if (price > THRESHOLD) {
            return usage * (price - THRESHOLD) * PERCENTAGE; // NOK
        }
        return 0.0;
    }

    // g) Norgespris for måneden (fast 0.50 NOK/kWh)
    public static double computeNorgesPrice(double[][] usage) {
        return computePowerUsage(usage) * NORGESPRIS_KWH;
    }

    // --- Hjelper ---
    private static void validateSameShape(double[][] a, double[][] b) {
        if (a.length != b.length) {
            throw new IllegalArgumentException("Ulikt antall dager i usage og prices.");
        }
        for (int d = 0; d < a.length; d++) {
            if (a[d].length != b[d].length) {
                throw new IllegalArgumentException("Ulikt antall timer på dag " + (d + 1));
            }
        }
    }
}
