package no.hvl.dat100.javel.oppgave3;

public class CustomerMain {

    public static void main(String[] args) {

        System.out.println("==============");
        System.out.println("OPPGAVE 3");
        System.out.println("==============\n");

        // e) Opprett og test Customer-objekt
        Customer c = new Customer(
                "Alice Smith",
                "alice@example.com",
                1001,
                PowerAgreementType.SPOTPRICE
        );

        // toString()
        System.out.println(c);
        System.out.println();

        // Test getters
        System.out.println("Hent navn: " + c.getName());
        System.out.println("Hent epost: " + c.getEmail());
        System.out.println("Hent id: " + c.getCustomer_id());
        System.out.println("Hent avtale: " + c.getAgreement());
        System.out.println();

        // Test setters
        c.setName("Alice S.");
        c.setEmail("alice.s@example.com");
        c.setCustomer_id(2002);
        c.setAgreement(PowerAgreementType.POWERSUPPORT);

        // Vis endringer
        System.out.println("Etter oppdatering:");
        System.out.println(c);
    }
}
