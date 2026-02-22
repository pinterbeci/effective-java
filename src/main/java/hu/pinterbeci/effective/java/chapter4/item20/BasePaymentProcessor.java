package hu.pinterbeci.effective.java.chapter4.item20;

public abstract class BasePaymentProcessor implements PaymentProcessor {

    // shared behavior - every payment goes through this
    @Override
    public void processPayment(double amount) {
        validate(amount);        // same for everyone
        log(amount);             // same for everyone
        doProcessPayment(amount); // different for everyone
    }

    @Override
    public void refund(double amount) {
        log(amount);             // same for everyone
        doRefund(amount);        // different for everyone
    }

    // subclasses MUST implement these
    protected abstract void doProcessPayment(double amount);

    protected abstract void doRefund(double amount);

    // shared logic lives here
    private void validate(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Invalid amount");
    }

    private void log(double amount) {
        System.out.println("Processing payment of: " + amount);
    }
}