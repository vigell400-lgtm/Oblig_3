package no.hvl.dat100.javel.oppgave1;

public class DailyPower {

    // a) print power prices during a day
    public static void printPowerPrices(double[] prices) {
        for (int i = 0; i < prices.length; i++) {
            System.out.printf("%.2f kr, ", prices[i]);
        }
        System.out.println(); // printer en ny linje oppå slutten
    }

    // b) print power usage during a day
    public static void printPowerUsage(double[] usage) { // vi definerer vi en metode
        for (int i = 0; i < usage.length; i++) {
            System.out.printf("%.2f kWh, ", usage[i]);
        }
        System.out.println();
    }

    // c) compute power usage for a single day (som beregner det totale strømforbruk for hele dagen ved å legge sammen strømforbruk for de enkelte timene. **Hint** se tilbake på `summer` metoden for Java innlevering 2 eller Mini-Excel eksemplet fra forelesninger.)
    public static double computePowerUsage(double[] usage) {
        double sum = 0;

        for (int i = 0; i < usage.length; i++) {
            sum += usage[i];
        }
        return sum;
    }

    // d) compute spot price for a single day (som utfra strømforbruk time for time (`usage`) og spotpris per kWh time for hver time (`prices`) beregner den totale strømpris for dagen. Strømprisen for en gitt time fås ved å multiplisere strømforbruket for timen med den tilsvarende spotpris for timen.)
    public static double computeSpotPrice(double[] usage, double[] prices) {
        double price = 0;

        //for loop som går gjennom alle 24 timer
        for (int i = 0; i < usage.length; i++) {
            price += usage[i] * prices[i]; //totalsummen = 24 timer * (forbruket * med spotprisen for hver time)
        }
        return price;
    }

    // e) compute power support for a given usage and price
    private static final double THRESHOLD = 0.9375; // 93,75 øre er prisgrensen før du får strømstøtte
    private static final double PERCENTAGE = 0.9;   // 90 % av prisen over TRESHOLD dekkes

    private static double getSupport(double usage, double price){
        double support = 0;

        if (price > THRESHOLD){
            double difference = price - THRESHOLD;//delen av prisen som blir dekket
            support = difference * PERCENTAGE * usage; //endelig sum som du får i støtte etter forbruk og strømpris
        }
        return support;
    }

    // f) compute power support for a single day ( som utfra forbruk og strømpriser for en enkelt dag beregner strømstøtten for kunden på denne dagen)
    public static double computePowerSupport(double[] usage, double[] prices) {
        double support = 0;

        for (int i = 0; i < usage.length; i++){
            support += getSupport(usage[i], prices[i]);
        }
        return support;
    }

    private static final double NORGESPRIS_KWH = 0.5;

    // g) compute norges pris for a single day (som gitt forbruk time for time ('usage') beregner og returnerer hva kunden skal betale i pris for strømmen denne dagen)
    public static double computeNorgesPrice(double[] usage) {
        double price = 0;

        for (int i = 0; i < usage.length; i++) {
            price += usage[i] * NORGESPRIS_KWH;
        }
        return price;
    }

    // h) compute peak usage during a single day (som utfra time for time forbruket ('usage') beregner og returnerer det største strømforbruket som kunden har hatt på en time i løpet av dagen)
    public static double findPeakUsage(double[] usage) {
        double temp_max = 0;

        for (int i = 0; i < usage.length; i++){
            if (usage[i] > temp_max){
                temp_max = usage[i];
            }
        }
        return temp_max;
    }

    // i) average hourly power usage (som beregner og returnerer det gjennomsnitlige strømforbruk som kunden har hatt per time i løpet av dagen)
    public static double findAvgPower(double[] usage) {
        double average = 0;
        double sum = 0; //for å regne ut totalt forbruk

        for (int i = 0; i < usage.length; i++){
            sum += usage[i];
        }
        average = sum / usage.length;
        return average;
    }
}