package no.hvl.dat100.javel.oppgave4;

import no.hvl.dat100.javel.oppgave3.Customer;

public class Customers {

    private Customer[] customers;

    // a) constructor
    public Customers(int size) {
        if (size < 0) throw new IllegalArgumentException("size < 0");
        customers = new Customer[size];
    }

    // b) count number of non-null references
    public int countNonNull() {
        int count = 0;
        for (Customer c : customers) {
            if (c != null) count++;
        }
        return count;
    }

    // c) return reference to customer with given id (if exists)
    public Customer getCustomer(int customer_id) {
        for (Customer c : customers) {
            if (c != null && c.getCustomer_id() == customer_id) {
                return c;
            }
        }
        return null;
    }

    // d) add a customer to the reference table (first null slot)
    public boolean addCustomer(Customer c) {
        if (c == null) return false;
        for (int i = 0; i < customers.length; i++) {
            if (customers[i] == null) {
                customers[i] = c;
                return true;
            }
        }
        return false; // no free slot
    }

    // e) remove customer with given id from reference table
    public Customer removeCustomer(int customer_id) {
        for (int i = 0; i < customers.length; i++) {
            Customer c = customers[i];
            if (c != null && c.getCustomer_id() == customer_id) {
                customers[i] = null; // free the slot
                return c;            // return removed reference
            }
        }
        return null; // not found
    }

    // f) return reference table with all customers (compact copy)
    public Customer[] getCustomers() {
        int count = countNonNull();
        Customer[] result = new Customer[count];
        int j = 0;
        for (Customer c : customers) {
            if (c != null) {
                result[j++] = c;
            }
        }
        return result;
    }
}
