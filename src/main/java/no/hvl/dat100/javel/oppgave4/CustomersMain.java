package no.hvl.dat100.javel.oppgave4;

import no.hvl.dat100.javel.oppgave3.Customer;
import no.hvl.dat100.javel.oppgave3.PowerAgreementType;

public class CustomersMain {

    public static void main(String[] args) {

        System.out.println("==============");
        System.out.println("OPPGAVE 4");
        System.out.println("==============\n");

        Customers registry = new Customers(10);

        // Opprett noen kunder
        Customer c1 = new Customer("Alice Smith",   "alice@example.com",   1001, PowerAgreementType.SPOTPRICE);
        Customer c2 = new Customer("Bob Johnson",   "bob@example.com",     1002, PowerAgreementType.NORGESPRICE);
        Customer c3 = new Customer("Charlie Rose",  "charlie@example.com", 1003, PowerAgreementType.POWERSUPPORT);
        Customer c4 = new Customer("Diana Prince",  "diana@example.com",   1004, PowerAgreementType.NORGESPRICE);
        Customer c5 = new Customer("Ethan Hunt",    "ethan@example.com",   1005, PowerAgreementType.POWERSUPPORT);

        // d) addCustomer
        System.out.println("Legg til kunder:");
        System.out.println(registry.addCustomer(c1));
        System.out.println(registry.addCustomer(c2));
        System.out.println(registry.addCustomer(c3));
        System.out.println(registry.addCustomer(c4));
        System.out.println(registry.addCustomer(c5));
        System.out.println();

        // b) countNonNull
        System.out.println("Antall lagrede kunder: " + registry.countNonNull());
        System.out.println();

        // c) getCustomer
        System.out.println("Hent kunde 1003:");
        System.out.println(registry.getCustomer(1003));
        System.out.println();

        // e) removeCustomer
        System.out.println("Fjern kunde 1002:");
        Customer removed = registry.removeCustomer(1002);
        System.out.println("Fjernet: " + (removed != null ? removed.getName() : "ingen"));
        System.out.println("Antall etter fjerning: " + registry.countNonNull());
        System.out.println();

        // f) getCustomers (kompakt kopi)
        System.out.println("Alle kunder (kompakt tabell):");
        Customer[] all = registry.getCustomers();
        for (Customer c : all) {
            System.out.println(c);
            System.out.println();
        }
    }
}

