package no.hvl.dat100.javel.oppgave3;

public class Customer {

    // a) objektvariable (attributter)
    private String name;
    private String email;
    private int customer_id;
    private PowerAgreementType agreement;

    // b) konstruktør som setter alle felt
    public Customer(String name, String email, int customer_id, PowerAgreementType agreement) {
        this.name = name;
        this.email = email;
        this.customer_id = customer_id;
        this.agreement = agreement;
    }

    // c) getter/setter for alle objektvariable
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public int getCustomer_id() {
        return customer_id;
    }
    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public PowerAgreementType getAgreement() {
        return agreement;
    }
    public void setAgreement(PowerAgreementType agreement) {
        this.agreement = agreement;
    }

    // d) toString – formatering slik oppgaven viser
    @Override
    public String toString() {
        return "Customer number " + customer_id + "\n" +
                "Name  " + name + "\n" +
                "Email " + email + "\n" +
                "Agreement " + agreement;
    }
}

